
import java.io.*;
import java.nio.file.*;

import java.util.ArrayList;


public class PageIndex {
    public static void pageIndex() throws IOException {

/** On copie le index-static.html, qui est le "corps" de l'index html dans le fichier index.html.
 **/

        Path indexStaticPath = Paths.get("../index-static.html");
        Path indexPath = Paths.get("../index.html");
        try {
            Files.copy(indexStaticPath, indexPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            System.out.println("Le fichier index-static n'a pas été trouvé");
        }
/**
 * Création du String qui affichera la liste des agents + les liens hypertextes à insérer dans la page html.index
 */
        String newBlocAgents = "";
        for (String agent : Agents.listAgents("../txt/staff.txt")) {
            ArrayList<String> listInfoAgent = Agents.infoAgents(agent);
            System.out.println(listInfoAgent.get(0));
            String prenom = listInfoAgent.get(1);
            String nom = listInfoAgent.get(0);
            newBlocAgents += "<a href=\"../" + agent + ".html\">" + prenom + " " + nom + " </a> <br>";
        }

        System.out.println(newBlocAgents);


/** On convertit le html en File, on copie le contenu de index.html dans oldcontent.
 * Puis on remplace le BLOC_AGENTS par la liste des agents dans un String newContent.
 * Enfin, on balance le newContent dans le fichier index.html.
 */
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
