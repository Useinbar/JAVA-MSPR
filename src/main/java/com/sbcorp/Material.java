package com.sbcorp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.apache.commons.codec.digest.Md5Crypt.apr1Crypt;

public class Material {

    /**
     * listMateriels permet d'obtenir la liste du matériel de l'entreprise sur Java
     * @param fichier fichier contenant la liste du matériel de l'entreprise.
     * @return une Map contenant la liste de matériels disponibles (avec comme clé le nom abrégé de l'objet et en valeur
     * son nom entier
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

            throw new FileNotFoundException();
        }
        return materiels;
    }

    /**
     * txtToist transforme un fichier texte (.txt) en un ArrayList sur Java.
     * @param fichier est n'importe quel fichier texte
     * @return un ArrayListe ou chaque élement de la liste est une ligne du fichier texte d'entrée
     */
    public static ArrayList<String> txtToList(String fichier) throws FileNotFoundException {

        ArrayList<String> listInfoAgents = new ArrayList<>();
        try {
            FileReader file = new FileReader(fichier);
            BufferedReader bufferedReader = new BufferedReader(file);
            String line;
            line = bufferedReader.readLine();
            while (line != null) {
                listInfoAgents.add(line);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
//            e.printStackTrace();
            throw new FileNotFoundException();
        }
        return listInfoAgents;

    }

    /**
     * La méthode génère, à partir du nom d'un agent, un fichier .nomDeLAgent (htpasswd) contenant un mot de passe hashé
     * (le mot de passe est récupéré dans le fichier texte associé à l'agent, et est hashé avec la fonction APR1
     * (qui est une fonction s'appuyant sur une base de MD5)
     * @param agent : on rentre en paramètre l'identifiant de l'agent (première lettre du prénom+nom) (comme cbertier)
     * @throws FileNotFoundException
     */
    public static void Crypt(String agent) throws FileNotFoundException {
        List<String> lignes = new ArrayList<>();
        Path htpasswdFile = Paths.get(Main.path+"src/main/resources/htpasswd/." + agent);
        ArrayList<String> infoAgents;
        infoAgents = Material.txtToList(Main.path + "src/main/resources/txt/" + agent + ".txt");
        // Edition du fichier htpasswdFile:
        String mdpCrypte = apr1Crypt(infoAgents.get(3));
        lignes.add(agent + ":" + mdpCrypte);

        try {
            Files.write(htpasswdFile, lignes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
