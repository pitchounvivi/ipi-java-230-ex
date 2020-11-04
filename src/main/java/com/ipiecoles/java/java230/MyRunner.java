package com.ipiecoles.java.java230;

import com.ipiecoles.java.java230.model.Employe;
import com.ipiecoles.java.java230.model.Manager;
import com.ipiecoles.java.java230.model.Technicien;
import com.ipiecoles.java.java230.repository.EmployeRepository;
import com.ipiecoles.java.java230.repository.ManagerRepository;
import com.ipiecoles.java.java230.repository.TechnicienRepository;
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

    @Autowired //pour pouvoir utiliser le repo (utilisation de Spring)
    private TechnicienRepository technicienRepository;

    @Autowired //pour pouvoir utiliser le repo (utilisation de Spring)
    private ManagerRepository managerRepository;

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

//mis en commentaire lors de l'exercice de mise en relation des table/model
        /*Employe e = employeRepository.findByMatricule("C00004");
        if (e != null){
            System.out.println(e.toString());
        }
        System.out.println("Employé non trouvé");

        //
        List<Employe> employeList = employeRepository.findByNomAndPrenom("Barre", "Maxime");
        for (Employe employe : employeList){
            System.out.println(employe.toString());
        }

        //
        List<Employe> employeList1 = employeRepository.findBySalaireIsGreaterThanOrderBySalaireDesc(2300.0);
        for (Employe employe : employeList1){
            System.out.println(employe.toString());
        }

        //pagination
        PageRequest pageRequest = PageRequest.of(0, 5, Sort.Direction.ASC, "prenom");
        Page<Employe> employeList2 = employeRepository.findByNomIgnoreCase("Andre", pageRequest);
        System.out.println("Nombre de result tot : " + employeList2.getTotalElements());
        System.out.println("Nombre pages tot : " + employeList2.getTotalPages());
        System.out.println("Taille page : " + employeList2.getSize());
        System.out.println("Trié par : " + employeList2.getSort().toString());
        for (Employe employe : employeList2){
            System.out.println(employe.toString());
        }


        //
        //test d'une requête en JPA
        List<Employe> employeList3 = employeRepository.findByNomOrPrenomAllIgnoreCase("JULIEN");
        for (Employe employe : employeList3){
            System.out.println(employe.toString());
        }

        //Mise en place des relations = mapping
        Iterable<Employe> employeIterable = employeRepository.findAll();

        for (Employe employe : employeIterable){
            //System.out.println(employe.toString());
            System.out.println(employe.getPrimeAnnuelle());
        }*/


        /*Iterable<Technicien> technicienIterable = technicienRepository.findAll();
        for (Technicien employe : technicienIterable){
            System.out.println(employe.toString());
            System.out.println(employe.getPrimeAnnuelle());
            System.out.println(employe.getManager().getNom());
        }*/

//        Optional<Manager> managerIterable = managerRepository.findById(44L);
//        for (Technicien technicien : managerIterable.get().getEquipe()){
//            System.out.println(technicien.toString());
//        }

        Manager manager = managerRepository.findOneWithEquipeById(44L);
        for(Technicien technicien : manager.getEquipe()){
            System.out.println(technicien.toString());
        }

    }

    public static void print(Object t) {
        System.out.println(t);
    }
}
