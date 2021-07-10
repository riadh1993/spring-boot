package com.funsoft.cabinet.model;
import java.util.List;
public class Recherche {
    private String specialite;
    private String pseudo;
    private List<Medecin> meds;
    public Recherche(){

    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public List<Medecin> getMeds() {
        return meds;
    }

    public void setMeds(List<Medecin> meds) {
        this.meds = meds;
    }
}
