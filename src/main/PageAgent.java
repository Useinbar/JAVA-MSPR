package main;

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


        ArrayList infoAgents = Agents.txtToList(Main.path+"txt/"+agent+".txt");

        Map<String, String> materiel=  Materiels.listMateriels(Main.path+"txt/liste.txt");

        for (String item : materiel.keySet()) {
            if (infoAgents.contains(item)) {
                blocMateriel += "<div>  <input type=\"checkbox\"  onclick=\"return false;\" checked> <label for=\"scales\">" + materiel.get(item) + "</label></div>";
            }
            else{
                blocMateriel +="<div>  <input type=\"checkbox\"  onclick=\"return false;\"> <label for=\"scales\">"+materiel.get(item)+"</label></div>";
            }
        }

        String prenom = (String) infoAgents.get(0);
        String nom = (String) infoAgents.get(1);
        Path nouvFichier = Paths.get(Main.path +"html/"+ agent + ".html");
        String contenuPageAgent = "<!DOCTYPE html>\n" +
                "<html lang=\"fr\">\n" +

                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <link rel=\"stylesheet\" href=\"../css/style.css\" />\n" +
                "    <title>Agent :" + agent + "</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1>"+prenom+" "+nom+"</h1>\n" +
                "<form> <input type=\"button\"  value=\"Retour à l'index\" onclick=\"\"history.go(-1)\"></form>\n"+
                "<img src=\"../images/" + agent + ".png \"\n" +
                "     alt=\"Photo de l'agent \"" +
                "width=\"500\" >\n" +
                "<center>"+
                "<p>" + blocMateriel +"</p></center>\n" +
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
