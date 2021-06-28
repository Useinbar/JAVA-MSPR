package com.sbcorp;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Collections;

public class PageIndex {

    /**
     * Méthode qui fabrique la page index.html à partir d'un fichier index-static.html (étant donné que seule la liste
     * des agents est vouée à être modifiée, on allège le nombre de ligne sous java en important un fichier html et en
     * ne modifiant qu'une partie de celui-ci.
     */
    public static void createPageIndex() throws IOException {

        Path indexStaticPath = Paths.get(Main.path+"html/index-static.html");
        Path indexPath = Paths.get(Main.path + "html/index.html");
        try {
            Files.copy(indexStaticPath, indexPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            System.out.println("Le fichier index-static n'a pas été trouvé");
        }

        //Création du String newBlocAgents (au format HTML) qui affichera la liste des agents + les liens hypertextes à insérer dans la page index.html
        String newBlocAgents = "";

        //on récupère la liste des agents
        ArrayList<String> listAgentsSorted = Material.txtToList(Main.path + "txt/staff.txt");

        // On trie les agents par ordre alphabétique par rapport à leur prénom
        Collections.sort(listAgentsSorted);

        //Pour chaque agent, on crée la partie html qui contient les liens hypertextes menant aux pages des différents agents
        for (String agent : listAgentsSorted) {
            ArrayList<String> listInfoAgent = Material.txtToList(Main.path + "txt/" + agent + ".txt");
            String prenom = listInfoAgent.get(1);
            String nom = listInfoAgent.get(0);
            newBlocAgents += "<a href=\"../" + agent + ".html\">" + nom + " " + prenom + " </a> <br><br>";
        }

        //On copie le contenue de index-static.html dans un String.
        // index-static.html contient le terme "BLOC_AGENTS". Il sert de balise pour nous indiquer où nous devons éditer le code
        //Puis on copie ce String dans le nouveau fichier (index.html)
        //Enfin, on remplace le terme "BLOC_AGENTS" par le morceau de code html généré au dessus (newBlocAgents).
        File indexFile = indexPath.toFile();
        String oldContent = "";
        BufferedReader reader = new BufferedReader(new FileReader(indexFile));
        String line = reader.readLine();
        while (line != null) {
            oldContent = oldContent + line + System.lineSeparator();
            line = reader.readLine();
        }
        String newContent = oldContent.replaceAll("BLOC_AGENTS", newBlocAgents);
        FileWriter writer = new FileWriter(indexFile);
        writer.write(newContent);
        reader.close();
        writer.close();
    }
}
