import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.Map;

public class TxtToHtml {
    public static void main(String[] args) {

        Map<String,String> stuff = new HashMap<>();

        Path filePath = Paths.get("GoSecuri/src/txt/liste.txt");
        System.out.println("test");
        if (Files.exists(filePath)) {
            List<String> lines = null;
            try {
                lines = Files.readAllLines(filePath);
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            for (String line : lines) {
                String[] a = line.split("\\t"); // On sépare le code de son libelé
//                System.out.println(a[1]);
                stuff.put(a[0], a[1]); // Le code est la clé, le libelé sa valeur
//                System.out.println();
                }
            System.out.println(stuff.values());
            System.out.println(stuff.keySet());
        }
        else{
            System.out.println("Le fichier n'a pas pu être lu.");
        }
    }
}
