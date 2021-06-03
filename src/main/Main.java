package main;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class Main {

//    final static String path = "";
   final static String path = "../";


    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {



        PageIndex.pageIndex();
        ArrayList<String> agents;
        agents = Agents.listAgents(Main.path+"txt/staff.txt");
        for (String agent : agents) {
            PageAgent.createPageAgent(agent);
        }

//        main.Agents.afficherListAgents(agents);
//
//        System.out.println();
//
//        Map<String, String> materiels;
//        materiels = main.Materiels.listMateriels("txt/liste.txt");
//        main.Materiels.afficherListMateriels(materiels);
//        main.PageIndex.index();
    }
}