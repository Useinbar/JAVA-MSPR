
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AgentsTest {

    /**
     * Test nominal : vérifie la présence des quelques éléments du fichier passé en paramètre
     * dans la liste retournée par la méthode txtToList
     *
     * @throws FileNotFoundException
     */
    @Test
    public void txtToListNominal() throws FileNotFoundException {
        ArrayList<String> agents = Agents.txtToList("txt/staff.txt");
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
    public void testListAgentsFichierVide() throws FileNotFoundException {
        ArrayList<String> agents = Agents.txtToList("txtTest/staffTest.txt");
        assertEquals(0, agents.size());
    }

    /**
     * Test de cas particuliers : Vérifie qu'une exeption est levée si le fichier
     * n'existe pas
     */

    @Test
    public void testListAgentsFileNotFound() {
        assertThrows(IOException.class, () -> {
            Agents.txtToList("/txt/fileNotFound.txt");
        });
    }
}
