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

    /**
     * @param fichier fichier contenant la liste des agents
     * @return un ArrayList des agents contenu dans le fichier en paramètre
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
