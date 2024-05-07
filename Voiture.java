package Classes;

import java.text.DecimalFormat;

public class Voiture {
    
    DecimalFormat dec2 = new DecimalFormat("#.00");

    //Attribut privates
    private String noSerie;
    private String marque;
    private String modele;
    private int annee;
    private double prix;
    private String photo;

    //Constructeur avec tous les paramètres
    public Voiture(String noSerie, String marque, String modele, int annee, double prix, String photo) {
        this.noSerie = noSerie;
        this.marque = marque;
        this.modele = modele;
        this.annee = annee;
        this.prix = prix;
        this.photo = photo;
    }

    //Getters et setters
    public String getNoSerie() {
        return noSerie;
    }

    public void setNoSerie(String noSerie) {
        this.noSerie = noSerie;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    //Redéfinition méthode equals (selon le numéro de série)
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        //Conversion de l'objet de type Objet en objet de type Voiture
        Voiture voiture = (Voiture) obj;

        return (this.getNoSerie().equalsIgnoreCase(voiture.noSerie));
    }

    @Override
    public String toString() {
        return "Voiture " + noSerie + " { " + marque + " " + modele + ", " + annee + ", " + dec2.format(prix) + " $ }";
    }
    
    
}
