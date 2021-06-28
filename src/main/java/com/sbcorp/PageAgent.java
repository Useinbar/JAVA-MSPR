package com.sbcorp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

public class PageAgent {

    /**
     * createPageAgent est chargé de créer les pages de chaque agent
     * @param agent l'identifiant de l'agent (première lettre du prénom+nom) (comme cbertier par exemple)
     */
    public static void createPageAgent(String agent) throws IOException {
        String blocMateriel = "";


        ArrayList infoAgents = Material.txtToList(Main.path + "txt/" + agent + ".txt");

        Map<String, String> materiel = Material.listMateriels(Main.path + "txt/liste.txt");

        // Pour chaque matériel, si l'agent possède l'objet, on lui mettra une case coché (checked) devant le nom de l'objet
        // Sinon, elle sera décochée.
        // onclick="return false;" permet de rendre la boite statique (on ne pourra pas passer à l'autre)
        for (String item : materiel.keySet()) {
            if (infoAgents.contains(item)) {
                blocMateriel += "<div>  <input type=\"checkbox\"  onclick=\"return false;\" checked> <label for=\"scales\">" + materiel.get(item) + "</label></div>";
            } else {
                blocMateriel += "<div>  <input type=\"checkbox\"  onclick=\"return false;\"> <label for=\"scales\">" + materiel.get(item) + "</label></div>";
            }
        }

        //On crée la page html de l'agent, et on insère dedans le "grand" String qui se nomme contenuPageAgent.
        String prenom = (String) infoAgents.get(0);
        String nom = (String) infoAgents.get(1);
        Path nouvFichier = Paths.get(Main.path + "html/" + agent + ".html");
        String contenuPageAgent = "<!DOCTYPE html>\n" +
                "<html lang=\"fr\">\n" +

                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <link rel=\"stylesheet\" href=\"../css/style.css\" />\n" +
                "    <title>Agent :" + agent + "</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1>" + prenom + " " + nom + "</h1>\n" +
                "<form> <input type=\"button\"  value=\"Retour à l'index\" onclick=\"history.go(-1)\"></form>\n" +
                "<img src=\"../images/" + agent + ".png \"\n" +
                "     alt=\"Photo de l'agent \"" +
                "width=\"400\" >\n" +
                "<center>" +
                "<p>" + blocMateriel + "</p></center>\n" +
                "</body>\n" +
                "\n" +
                "</html>\n" +
                "\n";

        Files.write(nouvFichier, Collections.singleton(contenuPageAgent));

    }
}
