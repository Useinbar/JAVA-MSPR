package com.sbcorp;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MaterialTest {

    /**
     * Test nominal : vérifie la présence des quelques éléments du fichier passé en paramètre
     * dans la liste retournée par la méthode txtToList
     *
     * @throws FileNotFoundException
     */
    @Test
    public void testListMaterielsNominal() throws FileNotFoundException {
        Map<String, String> materiels = Material.listMateriels("src/test/resources/liste.txt");
        assertEquals("Mousqueton", materiels.get("mousqueton"));
        assertEquals("Bombes lacrymogènes", materiels.get("lacrymo"));
        assertEquals("Talkies walkies", materiels.get("talky"));
    }

    /**
     * Test de cas particuliers : Vérifie qu'une liste vide est retournée si le fichier est vide
     *
     * @throws FileNotFoundException
     */
    @Test
    public void testListMaterielsFichierVide() throws FileNotFoundException {
        Map<String, String> materiels = Material.listMateriels("src/test/resources/listeVide.txt");
        assertEquals(0, materiels.size());
    }

    /**
     * Test de cas particuliers : Vérifie qu'une exeption est levée si le fichier
     * n'existe pas
     */
    @Test
    public void testListMaterielsFileNotFound() {
        assertThrows(IOException.class, () -> {
            Material.listMateriels("fileNotFount");
        });
    }
    /**
     * Test nominal : vérifie la présence des quelques éléments du fichier passé en paramètre
     * dans la liste retournée par la méthode txtToList
     *
     * @throws FileNotFoundException
     */
    @Test
    public void testTxtToListNominal() throws FileNotFoundException {
        ArrayList<String> agents = Material.txtToList("src/main/resources/txt/staff.txt");
        assertEquals("cberthier", agents.get(0));
        assertEquals("afoley", agents.get(3));
        assertEquals("jrouletabille", agents.get(7));
    }

    /**
     * Test de cas particuliers : Vérifie qu'une liste vide est retournée si le fichier est vide
     *
     * @throws FileNotFoundException
     */
    @Test
    public void testTxtToListAgentsFichierVide() throws FileNotFoundException {
        ArrayList<String> agents = Material.txtToList("src/test/resources/staffTest.txt");
        assertEquals(0, agents.size());
    }

    /**
     * Test de cas particuliers : Vérifie qu'une exeption est levée si le fichier
     * n'existe pas
     */

    @Test
    public void testToListAgentsFileNotFound() {
        assertThrows(IOException.class, () -> {
            Material.txtToList("src/test/resources/fileNotFound.txt");
        });
    }
}
