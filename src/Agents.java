import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.*;

public class Agents {

    /**
     * @param fichier fichier contenant la liste des agents
     * @return un ArrayList des agents contenu dans le fichier en paramètre
     */
    public static ArrayList<String> listAgents(String fichier) {
        ArrayList<String> agents = new ArrayList<>();
        try {
            FileReader file = new FileReader(fichier);
            BufferedReader bufferedReader = new BufferedReader(file);
            String line;
            line = bufferedReader.readLine();
            while (line != null) {
                agents.add(line);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return agents;
    }

    /**
     * @param listAgents Affiche l'ArrayList passée en paramètre
     */
    public static void afficherListAgents(ArrayList<String> listAgents) {
        System.out.println("Liste des agents :");
        for (String agent : listAgents) {
            System.out.println(agent);
        }
    }
}
