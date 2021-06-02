import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;


public class index {
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {

/*** On copie le index-static.html, qui est le "corps" de l'index html dans le fichier index.html.
 */
        Path indexStaticPath = Paths.get("html/index-static.html");
        Path indexPath = Paths.get("html/index.html");
        try {
            Files.copy(indexStaticPath, indexPath,StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            System.out.println("Le fichier index-static n'a pas été trouvé");
        }
/**
 * Création du String qui affichera la liste des agents + les liens hypertextes à insérer dans la page html.index
 */


       String stringAgents="Kenny Rapina";


/*** On convertit le html en File, on copie le contenu de index.html dans oldcontent.
 * Puis on remplace le BLOC_AGENTS par la liste des agents dans un String newContent.
 * Enfin, on balance le newContent dans le fichier index.html.
 */
        File indexFile= indexPath.toFile();
        String oldContent = "";
        BufferedReader reader = new BufferedReader(new FileReader(indexFile));
        String line = reader.readLine();
        while (line != null)
        {
            oldContent = oldContent + line + System.lineSeparator();
            line = reader.readLine();
        }
        String newContent = oldContent.replaceAll("BLOC_AGENTS", stringAgents);
        FileWriter writer = new FileWriter(indexFile);
        writer.write(newContent);
        reader.close();
        writer.close();

    }
}
