package com.funsoft.cabinet.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="medecins")
public class Medecin implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nom;
    private String prenom;
    private String specialite;

    public Medecin() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    @OneToMany(mappedBy="medecin",fetch =FetchType.LAZY,cascade = CascadeType.REMOVE)
    private List<Rv> lrdvs;

    public List<Rv> getLrdvs() {
        return lrdvs;
    }

    public void setLrdvs(List<Rv> lrdvs) {
        this.lrdvs = lrdvs;
    }
}
