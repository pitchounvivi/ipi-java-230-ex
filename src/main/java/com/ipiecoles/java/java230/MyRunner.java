package com.ipiecoles.java.java230;

import com.ipiecoles.java.java230.model.Employe;
import com.ipiecoles.java.java230.repository.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MyRunner implements CommandLineRunner {

    @Autowired //pour pouvoir utiliser le repo (utilisation de Spring)
    private EmployeRepository employeRepository;

    @Override
    public void run(String... strings) throws Exception {
        System.out.println("slt");

        Long nbEmployes = employeRepository.count();
        System.out.println("il y a " + nbEmployes + " dans la bdd");

        Optional<Employe> employe = employeRepository.findById(55L);
        if (employe.isEmpty()){
            System.out.println("Employé est inexistant");
        } else {
            Employe e = employe.get();
            e.setSalaire(e.getSalaire() + 200);
            e = employeRepository.save(e);
            System.out.println(e.toString());
        }


        for (Employe emp : employeRepository.findAll()){
            System.out.println(emp.toString());
        }


    }

    public static void print(Object t) {
        System.out.println(t);
    }
}
