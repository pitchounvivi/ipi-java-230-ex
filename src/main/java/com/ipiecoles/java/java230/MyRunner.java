package com.ipiecoles.java.java230;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner {

    @Override
    public void run(String... strings) throws Exception {
        System.out.println("slt");




    }

    public static void print(Object t) {
        System.out.println(t);
    }
}
