package Week4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class trial2 { 

    public static void main(String... args)  throws IOException{
        var fileName = "W4/Week4/src/main/java/Week4/data2.txt";
        var filePath = Paths.get(fileName);
        if(!Files.exists(filePath)){
            System.out.println("The File "+ fileName + " Could not be found");
        }

        var userInfos = new ArrayList<String>(); 

        var readStream = Files.newBufferedReader(filePath);
        var data = readStream.readLine(); 


         while(data !=null){ 
            data = readStream.readLine(); 
            if(data !=null ){
                userInfos.add(data);
            }
         }

            var userDetails= new ArrayList<User>();
            System.out.println("------------NAMES------------"); 
            for (var userData : userInfos) {
                var elements  = userData.split(",");   
                var user = new User();
                user.Name = elements [0];
                user.Address = elements[1];
                user.PhoneNumber = elements[2];
                userDetails.add(user);
    
            }
            for (var userInfo : userDetails) {
                System.out.println(userInfo.Name + "|" +userInfo.PhoneNumber+ "|" + userInfo.Address);
                

            var fileName2 = "W4/Week4/src/main/java/Week4/data3.txt";
            var filePath2 = Paths.get(fileName2);

            
            Files.write(filePath2, userInfos);
            
            }
        
    }
}
