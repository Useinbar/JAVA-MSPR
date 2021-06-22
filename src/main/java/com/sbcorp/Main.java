package com.sbcorp;

import com.sbcorp.Material;
import com.sbcorp.PageAgent;
import com.sbcorp.PageIndex;

import java.io.IOException;

import java.util.ArrayList;


public class Main {

    final static String path = "";
//   final static String path = "../";


    public static void main(String[] args) throws IOException {

        PageIndex.createPageIndex();
        ArrayList<String> agents;
        agents = Material.txtToList(path + "src/main/resources/txt/staff.txt");

        for (String agent : agents) {
            PageAgent.createPageAgent(agent);
            Material.Crypt(agent);
        }
    }
}