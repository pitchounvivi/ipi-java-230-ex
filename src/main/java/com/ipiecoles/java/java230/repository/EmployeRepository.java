package com.ipiecoles.java.java230.repository;

import com.ipiecoles.java.java230.model.Employe;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface EmployeRepository extends CrudRepository<Employe, Long> {
    //cela suffit pour utiliser toutes les méthodes CrudRepository

    Employe findByMatricule(String matricule);

    List<Employe> findByNomAndPrenom(String nom, String prenom);

    List<Employe> findByNomIgnoreCase(String nom);

    List<Employe> findByDateEmbaucheBefore(LocalDate date);

    List<Employe> findByDateEmbaucheAfter(LocalDate date);

    List<Employe> findBySalaireIsGreaterThanOrderBySalaireDesc(Double salaire);

}
