package fr.jaireda.client_rest.model;

/**
 * Created by jaired on 16/04/15.
 */

public class Loisir {
    private String Loisir;

    public Loisir() {
    }

    public Loisir(String loisir) {
        Loisir = loisir;
    }

    public String getLoisir() {
        return Loisir;
    }
    
    public void setLoisir(String loisir) {
        Loisir = loisir;
    }


    @Override
    public String toString() {
        return "Loisir{" +
                "Loisir='" + Loisir + '\'' +
                '}';
    }
}
