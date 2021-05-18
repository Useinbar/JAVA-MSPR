import java.io.*;
import java.nio.file.*;
import java.util.*;

public class TxtToHtml {
    public static void main(String[] args) {
        Path filePath = Paths.get("GoSecuri/src/txt/liste.txt");
        System.out.println(filePath);
        System.out.println("test");
        if (Files.exists(filePath)) {
            System.out.println("test2");// Si le fichier existe, on le lit
            List<String> lines = null;
            try {
// Récupération des lignes du fichier sous la forme d'une liste
                lines = Files.readAllLines(filePath);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
// Affichage du contenu du fichier dans la console
            for (String line : lines) {
                System.out.println("\t" + line);
            }
        }
        else{
            System.out.println("Nope");
        }
    }
}
