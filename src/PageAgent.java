import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

public class PageAgent {

    public static void createPageAgent(String agent) throws IOException {
        String blocMateriel= "";


        ArrayList infoAgents = Agents.infoAgents(agent);
        Map<String, String> materiel=  Materiels.listMateriels("../txt/liste.txt");
        System.out.println(infoAgents);
        System.out.println(Materiels.listMateriels("../liste.txt"));

        for (String item : materiel.keySet()) {
            if (infoAgents.contains(item)) {
                blocMateriel += "<div>  <input type=\"checkbox\"  onclick=\"return false;\" checked> <label for=\"scales\">" + materiel.get(item) + "</label></div>";
            }
            else{
                blocMateriel +="<div>  <input type=\"checkbox\"  onclick=\"return false;\"> <label for=\"scales\">"+materiel.get(item)+"</label></div>";
            }
        }

        System.out.println(blocMateriel);



        Path nouvFichier = Paths.get("../html/" + agent + ".html");
        String contenuPageAgent = "<!DOCTYPE html>\n" +
                "<html lang=\"fr\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Agent :" + agent + "</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<img src=\"../images/" + agent + ".png\"\n" +
                "     alt=\"Photo de l'agent \">\n" +
                "<p>" + blocMateriel + "</p>\n" +
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
