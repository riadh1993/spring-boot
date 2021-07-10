package com.funsoft.cabinet.model;


//POJO
//Entité : c'est une classe avec une table associée au niveau de la base

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="clients")
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotEmpty
    @Size(min = 5,max = 10)
    @Pattern(regexp = "[a-zA-Z]+",message = "must not contain special caracters")
    @Column(name="nom_client")
    private String nom;


    @NotEmpty
    @Size(min = 5,max = 10)
    @Column(name="prenom_client")
    @Pattern(regexp = "[a-zA-Z]+",message = "must not contain special caracters")
    private String prenom;

    public Client(){

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

    @OneToMany(mappedBy="client",fetch =FetchType.LAZY,cascade = CascadeType.REMOVE)
    private List<Rv> lrdvs;

    public List<Rv> getLrdvs() {
        return lrdvs;
    }

    public void setLrdvs(List<Rv> lrdvs) {
        this.lrdvs = lrdvs;
    }


    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", lrdvs=" + lrdvs +
                '}';
    }
}
