import java.io.*;
import java.nio.file.*;
import java.util.*;

public class index {
    public static void main(String[] args) throws IOException {

        Path indexStaticPath = Paths.get("html/index-static.html");
        Path indexPath = Paths.get("html/index.html");

        if (Files.exists(indexStaticPath)) {
            System.out.println("Le fichier existe");

            Files.copy(indexStaticPath, indexPath,StandardCopyOption.REPLACE_EXISTING);

            List<String> lines = null;
            try {
                lines = Files.readAllLines(indexStaticPath);
                System.out.println(lines);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            }
        }
    }
