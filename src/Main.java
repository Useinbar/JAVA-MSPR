import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
        PageIndex.pageIndex();
        ArrayList<String> agents;
        agents = Agents.listAgents("../txt/staff.txt");
        for (String agent : agents) {
            PageAgent.createPageAgent(agent);
        }

//        Agents.afficherListAgents(agents);
//
//        System.out.println();
//
//        Map<String, String> materiels;
//        materiels = Materiels.listMateriels("txt/liste.txt");
//        Materiels.afficherListMateriels(materiels);
//        PageIndex.index();
    }
}