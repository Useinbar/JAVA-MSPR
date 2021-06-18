package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Materiels {

    /**
     * @param fichier fichier contenant la liste de materiels
     * @return une MapList contenant la liste de matériels disponibles
     */
    public static Map<String, String> listMateriels(String fichier) throws FileNotFoundException {
        Map<String, String> materiels = new HashMap<>();

        try {
            FileReader file = new FileReader(fichier);
            BufferedReader bufferedReader = new BufferedReader(file);
            String line = bufferedReader.readLine();

            String[] champs;
            String clef;
            String valeur;

            while (line != null) {
                champs = line.split("\t");
                clef = champs[0];
                valeur = champs[1];
                materiels.put(clef, valeur);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            //e.printStackTrace();
            throw new FileNotFoundException();
        }
        return materiels;
    }
}
