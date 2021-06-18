package main;

import org.w3c.dom.ls.LSOutput;
import org.xml.sax.SAXException;
import org.apache.commons.codec.digest.Md5Crypt.*;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.apache.commons.codec.digest.Crypt.crypt;
import static org.apache.commons.codec.digest.Md5Crypt.apr1Crypt;

public class Main {

    final static String path = "";
//   final static String path = "../";


    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {


        PageIndex.pageIndex();
        ArrayList<String> agents;
        agents = Agents.txtToList("staff");

        Path htpasswdFile = Paths.get("txt/htpasswdFile.txt");
        List<String> lignes = new ArrayList<>();
        for (String agent : agents) {
            ArrayList<String> infoAgents;
            infoAgents = Agents.txtToList(agent);
//            System.out.println(infoAgents);
            // Création de la page de l'agent :
            PageAgent.createPageAgent(agent);

            // Edition du fichier htpasswdFile:
            String mdpCrypte = apr1Crypt(infoAgents.get(3));
            lignes.add(agent+":"+mdpCrypte);



        }
        System.out.println(lignes);
        try{
            Files.write(htpasswdFile,lignes);}
        catch (IOException e){
            e.printStackTrace();
        }
    }
}