import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;

public class PageAgent {

    public static void createPageAgent(String agent) throws IOException {

        Path nouvFichier = Paths.get("html/" + agent + ".html");
        String contenuPageAgent = "<!DOCTYPE html>\n" +
                "<html lang=\"fr\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Agent :" + agent + "</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<img src=\"images/" + agent + ".png\"\n" +
                "     alt=\"Photo de l'agent \">\n" +
                "<p>" + Materiels.afficherListMateriels() + "</p>\n" +
                "</body>\n" +
                "\n" +
                "</html>\n" +
                "\n";


//        try {
        Files.write(nouvFichier, Collections.singleton(contenuPageAgent));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
