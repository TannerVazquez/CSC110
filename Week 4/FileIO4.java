package Week4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;


public class FileIO4 {
    public static void main(String... args) throws IOException{
         var fileName = "./W2/WalkSeries2/src/main/java/WalkSeries2/data.txt";
         var filePath = Paths.get (fileName);

        if(!Files.exists(filePath)){
        System.out.println("The File" + fileName + "Could not be found");
    }

        var ThatArray = new ArrayList<String>();
        var readStream = Files.newBufferedReader(filePath);
        var data = readStream.readLine();



while(data !=null && data.length()>0) {
    ThatArray.add(data);
    data = readStream.readLine();
    

    
}


Collections.sort(ThatArray);
        

System.out.println("\nThat Sorted Array Reverse");
        for (Object item : ThatArray){
        System.out.println(item);
        }

var fileName2 = "W4/Week4/src/main/java/Week4/data2.txt";
var filePath2 = Paths.get (fileName2);

if (!Files.exists(filePath2)) {
    System.out.println("The File" + fileName2 + "Could not be found");

}

Files.write(filePath2, ThatArray);


}


    }
