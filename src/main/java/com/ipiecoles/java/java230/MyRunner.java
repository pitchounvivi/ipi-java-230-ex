package com.ipiecoles.java.java230;

import com.ipiecoles.java.java230.model.Employe;
import com.ipiecoles.java.java230.repository.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MyRunner implements CommandLineRunner {

    @Autowired //pour pouvoir utiliser le repo (utilisation de Spring)
    private EmployeRepository employeRepository;

    @Override
    public void run(String... strings) throws Exception {
        System.out.println("slt");

//        Long nbEmployes = employeRepository.count();
//        System.out.println("il y a " + nbEmployes + " dans la bdd");
//
//        Optional<Employe> employe = employeRepository.findById(55L);
//        if (employe.isEmpty()){
//            System.out.println("Employé est inexistant");
//        } else {
//            Employe e = employe.get();
//            e.setSalaire(e.getSalaire() + 200);
//            e = employeRepository.save(e);
//            System.out.println(e.toString());
//        }
//
//
//        for (Employe emp : employeRepository.findAll()){
//            System.out.println(emp.toString());
//        }


        Employe e = employeRepository.findByMatricule("C00004");
        if (e != null){
            System.out.println(e.toString());
        }
        System.out.println("Employé non trouvé");


        List<Employe> employeList = employeRepository.findByNomAndPrenom("Barre", "Maxime");
        for (Employe employe : employeList){
            System.out.println(employe.toString());
        }

        List<Employe> employeList1 = employeRepository.findBySalaireIsGreaterThanOrderBySalaireDesc(2300.0);
        for (Employe employe : employeList1){
            System.out.println(employe.toString());
        }

        PageRequest pageRequest = PageRequest.of(0, 5, Sort.Direction.ASC, "prenom");
        Page<Employe> employeList2 = employeRepository.findByNomIgnoreCase("Andre", pageRequest);
        for (Employe employe : employeList2){
            System.out.println(employe.toString());
        }



    }

    public static void print(Object t) {
        System.out.println(t);
    }
}
