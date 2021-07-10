package com.funsoft.cabinet.repository;

import com.funsoft.cabinet.model.Medecin;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MedecinRepository extends CrudRepository<Medecin, Long> {
    // select * from medecins xhere specialitr="spec";
    public List<Medecin> findBySpecialite(String spec);


    public List<Medecin> findByNom(String nom);

    public List<Medecin> findBySpecialiteAndNom(String spec, String nom);
    @Query(value="Select m from Medecin m where m.specialite = :spec "+
            "and (m.nom Like :pseudo or m.prenom Like :pseudo)")
    public List<Medecin> Search(@Param("spec") String s, @Param("pseudo") String p);

}
