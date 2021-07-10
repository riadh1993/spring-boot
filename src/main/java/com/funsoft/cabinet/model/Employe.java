package com.funsoft.cabinet.model;

import javax.persistence.*;

@Entity
@Table(name="employes")
public class Employe {

    @Id
    @Column(name="user_id")
    private long id; // l'identifiant de l'employé ce n'est que l'identifiant du client
    private String nom;
    private String prenom;

    @OneToOne
    @MapsId
    @JoinColumn(name="user_id")
    private User user;

    @OneToOne(cascade =  CascadeType.ALL)
    @JoinTable(name = "emp_workstation",
            joinColumns = {@JoinColumn(name="employe_id",referencedColumnName = "user_id")}
            ,
            inverseJoinColumns = {@JoinColumn(name="wokstation_id",referencedColumnName = "id")}
    )
    private WorkStation workStation;

    public Employe() {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public WorkStation getWorkStation() {
        return workStation;
    }

    public void setWorkStation(WorkStation workStation) {
        this.workStation = workStation;
    }
}
