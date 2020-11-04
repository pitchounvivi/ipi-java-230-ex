package com.ipiecoles.java.java230.repository;

import com.ipiecoles.java.java230.model.Employe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface EmployeRepository extends PagingAndSortingRepository<Employe, Long> {
    //cela suffit pour utiliser toutes les méthodes CrudRepository

    Employe findByMatricule(String matricule);

    List<Employe> findByNomAndPrenom(String nom, String prenom);

    List<Employe> findByNomIgnoreCase(String nom);

    List<Employe> findByDateEmbaucheBefore(LocalDate date);

    List<Employe> findByDateEmbaucheAfter(LocalDate date);

    List<Employe> findBySalaireIsGreaterThanOrderBySalaireDesc(Double salaire);



    //utilisation pagination (surcharge de la méthode du crutRepo)
    Page<Employe> findByNomIgnoreCase(String nom, Pageable pageable);


    //ceci est une requête native (on utilise les tables)
    @Query(value = "SELECT * FROM Employe WHERE salaire > (SELECT avg(e2.salaire) FROM Employe e2)", nativeQuery = true)
    //@Query(value = "SELECT Employe e, AVG(*.salaire) as moyenne where e.salaire > moyenne", nativeQuery = true)// autre écriture
    List<Employe> findEmployePlusRiches();


    //ceci est unr requête native (on utilise la table)
    @Query(value = "SELECT e.* FROM Employe e "+
            "WHERE e.nom = :nom "+
            "OR WHERE e.prenom = :prenom", nativeQuery = true)
        List<Employe> findByNomOuPrenom(@Param("nom") String nom,@Param("prenom") String prenom);


    //ceci est une requête JPA ou JPQL (on utilise la classe)
    //@Query("from Employe where lower(prenom) = :nomOuPrenom or lower(nom) = :nomOuPrenom ")//autre écriture
    @Query("select e from Employe e where lower(e.prenom) = :nomOuPrenom or lower(e.nom) = :nomOuPrenom ")//
    List<Employe> findByNomOrPrenomAllIgnoreCase(@Param("nomOuPrenom") String nomOuPrenom);


}
