package Interface_Graph;

import Classes.Garage;
import Classes.Voiture;
import Exceptions.ChampVideException;
import Exceptions.DoublonException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class FXMLDocumentController implements Initializable {

    @FXML
    private ComboBox<String> cbTrier;
    @FXML
    private TextField txtNoSerie;
    @FXML
    private TextField txtMarque;
    @FXML
    private Label labelMsg;
    @FXML
    private TextField txtModele;
    @FXML
    private TextField txtAnnee;
    @FXML
    private TextField txtPrix;
    @FXML
    private TextField txtPhoto;
    @FXML
    private ListView<Voiture> listViewVoiture;
    @FXML
    private ImageView imgPhoto;

    //Déclaration objet Garage
    private Garage leGarage;
    //Déclaration objet Voiture
    private Voiture voitureSelectionnee;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //Ajout des options de tri au ComboBox
        String[] triStr = {"Numéro de série", "Marque", "Année", "Prix"};
        cbTrier.getItems().addAll(Arrays.asList(triStr));
        //Création du garage
        leGarage = new Garage("Garage Rose !", "600 rue Albert, Cowansville", "450-123-4567");

        //Ajout d'un listener pour la sélection d'une voiture dans la ListView
        listViewVoiture.getSelectionModel().selectedItemProperty().
                addListener(
                        new ChangeListener<Voiture>() {
                    @Override
                    public void changed(ObservableValue<? extends Voiture> ov,
                            Voiture oldValue, Voiture newValue) {
                        try {
                            //Affichage de la photo de la voiture sélectionnée
                            imgPhoto.setImage(new Image("/Images/" + newValue.getPhoto() + ".jpg"));
                        } catch (Exception e) {
                            labelMsg.setText("Erreur de photo.");
                        }
                        voitureSelectionnee = newValue;
                    }
                }
                );
    }

    @FXML
    private void Ajouter(ActionEvent event) {

        try {

            //Vérification des champs vides
            if (txtNoSerie.getText().isEmpty()) {
                throw new ChampVideException("Inscrivez le numéro de série SVP.");
            }

            if (txtMarque.getText().isEmpty()) {
                throw new ChampVideException("Inscrivez la marque SVP.");
            }

            if (txtModele.getText().isEmpty()) {
                throw new ChampVideException("Inscrivez le modèle SVP.");
            }

            if (txtAnnee.getText().isEmpty()) {
                throw new ChampVideException("Incrivez l'année SVP.");
            }

            if (txtPrix.getText().isEmpty()) {
                throw new ChampVideException("Incrivez le prix SVP.");
            }

            if (txtPhoto.getText().isEmpty()) {
                throw new ChampVideException("Insrivez la photo SVP.");
            }

            //Récupération des données dans l'interface
            String noSerie = txtNoSerie.getText();
            String marque = txtMarque.getText();
            String modele = txtModele.getText();
            int annee = Integer.parseInt(txtAnnee.getText());
            double prix = Double.parseDouble(txtPrix.getText());
            String photo = txtPhoto.getText();

            //Création de la voiture 
            voitureSelectionnee = new Voiture(noSerie, marque, modele, annee, prix, photo);

            //Vérification des doublons
            if (leGarage.getListeVoitures().contains(voitureSelectionnee)) {
                throw new DoublonException("La voiture existe déjà dans le garage.");
            }

            //Ajouter la voiture au garage
            leGarage.ajouterVoiture(voitureSelectionnee);

            //Mise à jour de la listview
            listViewVoiture.setItems(leGarage.getListeVoitures());

            //Réinitialiser les champs
            resetChamps();

        } catch (ChampVideException | DoublonException e) {
            // Gestion des exceptions ChampVideException et DoublonException
            labelMsg.setText(e.getMessage());
        } catch (NumberFormatException e) {
            // Gestion de l'exception NumberFormatException 
            labelMsg.setText("Format de l'année ou du prix invalide.");
        }
    }

    @FXML
    private void Supprimer(ActionEvent event) {
        //Supression de la voiture sélectionnée
        leGarage.supprimerVoiture(voitureSelectionnee);
    }

    @FXML
    private void Trier(ActionEvent event) {
        //Tri de la liste des voitures selon l'option sélectionnée dans le ComboBox
        String tri = cbTrier.getValue();
        ObservableList<Voiture> listeTriee = leGarage.getListeVoitures();

        switch (tri.toLowerCase()) {
            case "marque":
                listeTriee = leGarage.getListeVoitures("marque");
                break;
            case "année":
                listeTriee = leGarage.getListeVoitures("année");
                break;
            case "prix":
                listeTriee = leGarage.getListeVoitures("prix");
                break;
        }

        listViewVoiture.setItems(listeTriee);

    }

    //Méthode resetChamps
    public void resetChamps() {
        txtNoSerie.clear();
        txtMarque.clear();
        txtModele.clear();
        txtAnnee.clear();
        txtPrix.clear();
        txtPhoto.clear();
    }

}
