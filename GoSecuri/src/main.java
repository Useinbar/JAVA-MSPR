import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class main {
    public static void main(String[] args) throws IOException {


        String fileContent = "Hello Learner !! Welcome to howtodoinjava.com.";
        Path path = Paths.get("GoSecuri/src/html/accueil.html");
        Files.write(path, fileContent.getBytes());
    }
}



