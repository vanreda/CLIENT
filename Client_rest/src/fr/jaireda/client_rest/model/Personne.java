package fr.jaireda.client_rest.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by jaired on 16/04/15.
 */

@Root(name="identite")
public class Personne {
	@Element(name="nom")
    private String Nom;
	@Element(name="prenom")
	private String Prenom;
	@Element(name="adresse")
	private String Adresse; 
	@Element(name="tel")
	private String Tel;


    public Personne() {
    }

    public Personne(String tel, String adresse, String prenom, String nom) {
        Tel = tel;
        Adresse = adresse;
        Prenom = prenom;
        Nom = nom;
    }

    public String getNom() {
        return Nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public String getAdresse() {
        return Adresse;
    }

    public String getTel() {
        return Tel;
    }

    
    public void setNom(String nom) {
        Nom = nom;
    }

    
    public void setPrenom(String prenom) {
        Prenom = prenom;
    }
    
    public void setAdresse(String adresse) {
        Adresse = adresse;
    }
    
    public void setTel(String tel) {
        Tel = tel;
    }

    @Override
    public String toString() {
        return "Personne{" +
                "Nom='" + Nom + '\'' +
                ", Prenom='" + Prenom + '\'' +
                ", Adresse='" + Adresse + '\'' +
                ", Tel='" + Tel + '\'' +
                '}';
    }
}
