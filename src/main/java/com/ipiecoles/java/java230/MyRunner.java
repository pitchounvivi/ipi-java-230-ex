package com.ipiecoles.java.java230;

import com.ipiecoles.java.java230.repository.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner {

    @Autowired //pour pouvoir utiliser le repo (utilisation de Spring)
    private EmployeRepository employeRepository;

    @Override
    public void run(String... strings) throws Exception {
        System.out.println("slt");

        Long nbEmployes = employeRepository.count();
        System.out.println("il y a " + nbEmployes + " dans la bdd");


    }

    public static void print(Object t) {
        System.out.println(t);
    }
}
