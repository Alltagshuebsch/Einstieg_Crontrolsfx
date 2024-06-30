package de.alltagshuebsch.einstieg_crontrolsfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.scene.image.WritableImage;
import javafx.util.StringConverter;

import javax.swing.*;
import java.util.List;

import static java.lang.System.*;
import static javafx.scene.image.Image.*;

public class Einstieg_ControlsFxController {

    public TextField txtAnzahlEintraege;

    public TextField txtAnzahlBilder;

    public Label lblBilderInfo;

    private Gallery gallery;
    private String galeriePfad = "C:\\Users\\Allta\\OneDrive\\Strukturiert\\Ausbildung\\Workspace\\Java Workspace\\Einstieg_Crontrolsfx\\src\\main\\resources\\pictures\\gallery\\";


    @FXML
    private TitledPane AccordeonAufgabenteilDrei;

    @FXML
    private TitledPane accordeonAufgabeEins;

    @FXML
    private TitledPane accordeonAufgabenteilZwei;

    @FXML
    private Button btnAddEintrag;

    @FXML
    private Button btnAlleWerteAuslesen;

    @FXML
    private Button btnAusgewähltenWertAuslesen;

    @FXML
    private Button btnBilderFuellen;

    @FXML
    private Button btnEintragLoeschen;

    @FXML
    private Button btnGalerieLeeren;

    @FXML
    private Button btnListeLeeren;

    @FXML
    private Button btnMehrInfosUeberBild;

    @FXML
    private Button btnParrot;

    @FXML
    private ComboBox<GalleryObj> cmbBilder;

    @FXML
    private ImageView imgFenster;

    @FXML
    private ListView<String> lwListe;

    @FXML
    private Menu menuDatei;

    @FXML
    private Menu menuInfo;

    @FXML
    private MenuItem menuItemBeenden;

    @FXML
    private MenuItem menuItemInformationen;

    @FXML
    private TextField txtBoxEintragBauarbeiter;

    @FXML
    private TextField txtFieldParrotText;

    @FXML
    private Text txtParrotText;

    @FXML
    void onActionAddEintrag(ActionEvent event) {
            try {
                ;
                for (int i = 1; i <= Integer.parseInt(txtBoxEintragBauarbeiter.getText()) ; i++) {
                    lwListe.getItems().add("Eintrag " +i);
                }
            }catch (NumberFormatException e) {
                lwListe.getItems().add(txtBoxEintragBauarbeiter.getText());
            }
    }

    @FXML
    void onActionAlleWerteAuslesen(ActionEvent event) {
        List <String> alleEintraege = lwListe.getItems();
        for (String eintrag : alleEintraege){
            out.println(eintrag);
        }
    }

    @FXML
    void onActionBildAnzeigen(ActionEvent event) {
        if (cmbBilder.getValue() != null) {
            imgFenster.setImage(cmbBilder.getSelectionModel().getSelectedItem().getImage());
        } else imgFenster.setImage(null);
    }

    @FXML
    void onActionBilderFuellen(ActionEvent event) {
        try {
            int zahl = Integer.parseInt(txtAnzahlBilder.getText());

            if (zahl <= 1) {
                zahl = 1;
            } else {
                if (zahl > 12) {
                    zahl = 12;
                }
            }
            cmbBilder.getItems().clear();
            gallery = new Gallery(zahl, galeriePfad);
            for (GalleryObj bild : gallery.galleryObjList){
                cmbBilder.getItems().add(bild);
            }
        }catch (NumberFormatException e) {
            txtAnzahlBilder.setText("0");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Fehler");
            alert.setHeaderText("Es darf nur eine Zahl eingebeben werden!");
        }
    }

    @FXML
    void onActionEintragLöschen(ActionEvent event) {
        lwListe.getItems().remove(lwListe.getSelectionModel().getSelectedIndex());
    }

    @FXML
    void onActionGalerieLeeren(ActionEvent event) {
        cmbBilder.getItems().clear();
        cmbBilder.getSelectionModel().clearSelection();
        lblBilderInfo.setText(null);
    }

    @FXML
    void onActionListeLeeren(ActionEvent event) {
        lwListe.getItems().clear();
    }

    @FXML
    void onActionMehrInformationen(ActionEvent event) {
        if (cmbBilder.getValue() != null) {
            GalleryObj selectedGalleryObj = cmbBilder.selectionModelProperty().getValue().getSelectedItem();
            String output = ("Autor: " + selectedGalleryObj.getAutor() + "\n" +
                    "Titel: " + selectedGalleryObj.getTitel() + "\n" +
                    "Beschreibung: " + selectedGalleryObj.getBeschreibung() + "\n" +
                    "Stil: " + selectedGalleryObj.getStil());

            lblBilderInfo.setText(output);
        } else lblBilderInfo.setText(null);
    }

    @FXML
    void onActionPapageiAnsprechen(ActionEvent event) {
        txtParrotText.setText("Krah! " +txtFieldParrotText.getText());
        txtFieldParrotText.clear();
    }

    @FXML
    void onActionProgrammBeenden(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void onActionWertAuslesen(ActionEvent event) {
        out.println(lwListe.getSelectionModel().getSelectedItem());
    }

    public void initialize(){
        cmbBilder.setConverter(new StringConverter<GalleryObj>() {
            @Override
            public String toString(GalleryObj galleryObj) {
                if (galleryObj == null){
                    return null;
                } else {
                    return galleryObj.getTitel();
                }
            }

            @Override
            public GalleryObj fromString(String s) {
                return null;
            }
        });
    }
}
