package de.alltagshuebsch.einstieg_crontrolsfx;

import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class GalleryObj {
    String dataname;
    String autor;
    String titel;
    String beschreibung;
    String stil;
    Image image;

    public GalleryObj(String dataname, String autor, String titel, String stil, String beschreibung, String galeriepfad) {
        this.dataname = dataname;
        this.autor = autor;
        this.titel = titel;
        this.beschreibung = beschreibung;
        this.stil = stil;
        try {
            image = new Image(new FileInputStream(galeriepfad + dataname + ".png"));
        } catch (IOException ex){
            ex.printStackTrace();
        }

    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public String getDataname() {
        return dataname;
    }

    public void setDataname(String dataname) {
        this.dataname = dataname;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getStil() {
        return stil;
    }

    public void setStil(String stil) {
        this.stil = stil;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
