package Classes;

import java.util.Collections;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import Comparators.*;

public class Garage {

    private String nom;
    private String adresse;
    private String telephone;
    private ObservableList<Voiture> listeVoitures;

    //Constructeur
    public Garage(String nom, String adresse, String telephone) {
        this.nom = nom;
        this.adresse = adresse;
        this.telephone = telephone;
        //Initialisation de la liste des voitures   
        listeVoitures = FXCollections.observableArrayList();
    }

    //Setters et getters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    //GetListeVoiture pour obtenir la liste des voitures triée selon un critère donné
    public ObservableList<Voiture> getListeVoitures(String tri) {

        tri.toLowerCase();

        switch (tri) {
            case "numéro de série":
                Collections.sort(listeVoitures, new NoSerieComparator());
                break;

            case "marque":
                Collections.sort(listeVoitures, new MarqueComparator());
                break;
            case "année":
                Collections.sort(listeVoitures, new AnneeComparator());
                break;
            case "prix":
                Collections.sort(listeVoitures, new PrixComparator());
                break;
        }
        return listeVoitures;
    }

    //GetListeVoiture sans paramètre (trier avec le numéro de série par défaut)
    public ObservableList<Voiture> getListeVoitures() {
        return getListeVoitures("numéro de série");
    }

    public void setListeVoitures(ObservableList<Voiture> listeVoitures) {
        this.listeVoitures = listeVoitures;
    }

    //Méthode ajouterVoiture
    public boolean ajouterVoiture(Voiture voiture) {
        if (listeVoitures.contains(voiture)) {
            return false;
        }
        listeVoitures.add(voiture);
        return true;
    }

    //Méthode supprimerVoiture 
    public boolean supprimerVoiture(Voiture voiture) {
        if (listeVoitures.contains(voiture)) {
            listeVoitures.remove(voiture);
            return true;
        }
        return false;
    }
    


}
