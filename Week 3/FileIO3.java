package WalkSeries2;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class FileIO3 {
public static void main(final String... args) throws IOException {
    final var fileName = "./W2/WalkSeries2/src/main/java/WalkSeries2/data copy.txt";
    final var filePath = Paths.get(fileName);
    if (!Files.exists(filePath)) {
        System.out.println("The File" + fileName + "Could not be found");
    }

    final var readStream = Files.newBufferedReader(filePath);
var data = readStream.readLine();
System.out.println("The Data");

while (data != null){
    System.out.println (data.toUpperCase());
data = readStream.readLine();
}
   

    }
}