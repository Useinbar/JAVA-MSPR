package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.io.*;
import java.util.List;

public class Agents {

    /**
     * @param fichier fichier contenant la liste des agents
     * @return un ArrayList des agents contenu dans le fichier en paramètre
     */

    public static ArrayList<String> txtToList(String fichier) throws FileNotFoundException {
        String fichierTxt = Main.path+"txt/" + fichier + ".txt";
        ArrayList<String> listInfoAgents = new ArrayList<>();
        try {
            FileReader file = new FileReader(fichierTxt);
            BufferedReader bufferedReader = new BufferedReader(file);
            String line;
            line = bufferedReader.readLine();
            while (line != null) {
                listInfoAgents.add(line);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            //e.printStackTrace();
            throw new FileNotFoundException();
        }
        return listInfoAgents;

    }
}
