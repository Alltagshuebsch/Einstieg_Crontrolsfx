package de.alltagshuebsch.einstieg_crontrolsfx;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Gallery {
    List <GalleryObj> galleryObjList = new ArrayList<GalleryObj>();

    Gallery(int AnzahlBilder, String galeriePfad){
        try (BufferedReader br = new BufferedReader(new FileReader(galeriePfad+"info.CSV"))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null && i < AnzahlBilder) {
                String[] values = line.split(";");
                galleryObjList.add(new GalleryObj(values[0],values[1],values[2],values[3],values[4], galeriePfad));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<GalleryObj> getGalleryObjList() {
        return galleryObjList;
    }
    public void setGalleryObjList(List<GalleryObj> galleryObjList) {
        this.galleryObjList = galleryObjList;
    }

}
