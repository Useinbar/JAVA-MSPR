import java.util.ArrayList;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        ArrayList<String> agents;
        agents = Agents.listAgents("txt/staff.txt");
        Agents.afficherListAgents(agents);

        System.out.println();

        Map<String, String> materiels;
        materiels = Materiels.listMateriels("txt/liste.txt");
        Materiels.afficherListMateriels(materiels);
    }
}