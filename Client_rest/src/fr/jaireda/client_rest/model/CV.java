package fr.jaireda.client_rest.model;


import java.util.ArrayList;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by jaired on 16/04/15.
 */


@Root(strict=false, name="cv")
public class CV {
	@Element(name="titre",required=false)
    private String Titre;
	@Element(name="identite", required=false)
    private Personne Identite;
	@Element(required=false)
    private ArrayList<Formation> Cursus;
	@Element(required=false)
    private ArrayList<Experience> ExperiencesPro;
	@Element(required=false)
    private ArrayList<Competence> Competences;
	@Element(required=false)
    private ArrayList<Langue> Langues;
	@Element(required=false)
    private ArrayList<Loisir> Loisirs;


    public CV(String titre, Personne identite) {
        Titre = titre;
        Identite = identite;
        this.Cursus=new ArrayList<Formation>();
        this.ExperiencesPro=new ArrayList<Experience>();
        this.Competences=new ArrayList<Competence>();
        this.Langues=new ArrayList<Langue>();
        this.Loisirs=new ArrayList<Loisir>();

    }
    public CV(String titre, String nom, String prenom, String tel, String adresse) {
        Titre = titre;
        Identite.setNom(nom);
        Identite.setPrenom(prenom);
        Identite.setAdresse(adresse);
        Identite.setTel(tel);
        this.Cursus=new ArrayList<Formation>();
        this.ExperiencesPro=new ArrayList<Experience>();
        this.Competences=new ArrayList<Competence>();
        this.Langues=new ArrayList<Langue>();
        this.Loisirs=new ArrayList<Loisir>();

    }



    public CV(){

    }
    public String getTitre() {
        return Titre;
    }


    public void setTitre(String titre) {
        Titre = titre;
    }

    public Personne getIdentite() {
        return Identite;
    }

    public void setIdentite(Personne identite) {
        Identite = identite;
    }

    public ArrayList<Formation> getCursus() {
        return Cursus;
    }

    public void setCursus(ArrayList<Formation> cursus) {
        Cursus = cursus;
    }

    public ArrayList<Experience> getExperiencesPro() {
        return ExperiencesPro;
    }

    public void setExperiencesPro(ArrayList<Experience> experiencesPro) {
        ExperiencesPro = experiencesPro;
    }

    public ArrayList<Competence> getCompetences() {
        return Competences;
    }
    
    public void setCompetences(ArrayList<Competence> competences) {
        Competences = competences;
    }

    public ArrayList<Langue> getLangues() {
        return Langues;
    }
    

    public void setLangues(ArrayList<Langue> langues) {
        Langues = langues;
    }

    public ArrayList<Loisir> getLoisirs() {
        return Loisirs;
    }
    

    public void setLoisirs(ArrayList<Loisir> loisirs) {
        Loisirs = loisirs;
    }
	@Override
	public String toString() {
		return "CV [Titre=" + Titre + ", Identite=" + Identite + ", Cursus="
				+ Cursus + ", ExperiencesPro=" + ExperiencesPro
				+ ", Competences=" + Competences + ", Langues=" + Langues
				+ ", Loisirs=" + Loisirs + "]";
	}

   

}
