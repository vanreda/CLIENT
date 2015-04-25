package fr.jaireda.client_rest.model;

import java.util.ArrayList;

/**
 * Created by jaired on 16/04/15.
 */

public class Langue {
    private String Nom;
    private int Niveau;

    public Langue(String nom, int niveau) {
        Nom = nom;
        Niveau = niveau;
    }

    public Langue() {
    }

    public String getNom() {
        return Nom;
    }
    
    public void setNom(String nom) {
        Nom = nom;
    }

    public int getNiveau() {
        return Niveau;
    }
    
    public void setNiveau(int niveau) {
        Niveau = niveau;
    }


    @Override
    public String toString() {
        return "Langue{" +
                "Nom='" + Nom + '\'' +
                ", Niveau=" + Niveau +
                '}';
    }

    /**
     * Created by jaired on 16/04/15.
     */

    public static class CVController {

        private CV unCV;


        public CVController() {
            CV cv=new CV();
            Personne per=new Personne("JAI","REDA", "mont st aignant","000000");
            ArrayList<Formation> formations=new ArrayList<Formation>();
            formations.add(new Formation("bac+2",2008));
            formations.add(new Formation("bac+3",2011));

            cv.setIdentite(per);
            cv.setCursus(formations);



        }

       
        CV getCVs(){
            return this.unCV;
        }

    }
}
