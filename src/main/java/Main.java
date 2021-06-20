import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
//import org.apache.commons.codec.digest.Md5Crypt.apr1Crypt;

public class Main {

//    final static String path = "";
   final static String path = "../";


    public static void main(String[] args) throws IOException {

        PageIndex.pageIndex();
        ArrayList<String> agents;
        agents = Agents.txtToList(path + "src/main/resources/txt/staff.txt");

        for (String agent : agents) {
            List<String> lignes = new ArrayList<>();
            Path htpasswdFile = Paths.get("src/main/resources/txt/." + agent);
            ArrayList<String> infoAgents;
            infoAgents = Agents.txtToList(path + "src/main/resources/txt/" + agent + ".txt");

//            System.out.println(infoAgents);
            // Création de la page de l'agent :
            PageAgent.createPageAgent(agent);

            // Edition du fichier htpasswdFile:
//            String mdpCrypte = apr1Crypt(infoAgents.get(3));
//            lignes.add(agent + ":" + mdpCrypte);

            try {
                Files.write(htpasswdFile, lignes);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}