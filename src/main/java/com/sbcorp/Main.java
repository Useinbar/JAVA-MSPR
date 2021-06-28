package com.sbcorp;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    final static String path = "";
//    final static String path = "../";
    public static void main(String[] args) throws IOException {
        // Création de la page index :
        PageIndex.createPageIndex();

        // On transforme le fichier staff.txt en une liste
        ArrayList<String> agents;
        agents = Material.txtToList(path + "txt/staff.txt");

        //Pour chaque agent, on va créer sa page (agent.html) et son htpasswd avec la méthode Crypt de Material
        for (String agent : agents) {
            PageAgent.createPageAgent(agent);
            Material.Crypt(agent);
            System.out.println("Test Soutenance MSPR JAVA");
        }
    }
}

//src/main/resources/