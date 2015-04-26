package fr.jaireda.client_rest.model;

import java.util.Date;

/**
 * Created by jaired on 16/04/15.
 */

public class Formation {
    private String Diplome;
    private int Année;


    public Formation() {
    }

    public Formation(String diplome, int année) {
        Diplome = diplome;
        Année = année;
    }

    public String getDiplome() {
        return Diplome;
    }
    

    public void setDiplome(String diplome) {
        Diplome = diplome;
    }

    public int getAnnée() {
        return Année;
    }
    

    public void setAnnée(int année) {
        Année = année;
    }

    @Override
    public String toString() {
        return "Formation{" +"Diplome='" + Diplome + '\'' +", Année=" + Année +'}';
    }
    
}
