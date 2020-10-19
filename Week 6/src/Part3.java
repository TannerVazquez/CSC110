import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import static java.lang.System.out;
import java.util.HashMap;
import java.util.Map;

public class Part3 {
    public static void main(String... args) throws IOException{
    	var StartTime = System.currentTimeMillis();
    	
    	var fileName = "./src/Sample500.csv";
        var filePath = Paths.get(fileName);

        if(!Files.exists(filePath)) 
            out.println("The File " + fileName + " could not be found");

        var userInfo = new HashMap<Integer, UserInfo>();
        var readStream = Files.newBufferedReader(filePath);
        var data = readStream.readLine();
        
        var key = 1;
        while(data !=null && data.length()>0) {
            data = readStream.readLine();
        
            
        if (data!= null) {
        var elements = data.split(",");
        var user = new UserInfo();
        user.SerialNum = elements [0];
        user.CompanyName = elements [1];
        user.EmployeeName = elements [2];
        user.Description = elements[3];
        user.Leave = elements[4];
        
        userInfo.put(key, user);
        key++;
     }
        }     
        
        readStream.close();

     out.println("Serial Number | Company Name | Employee Name | Leave");
    
     for (Map.Entry<Integer, UserInfo> m: userInfo.entrySet())  {
         out.println(m.getValue().SerialNum+ " | " +m.getValue().CompanyName+ " | " 
         +m.getValue().EmployeeName+ " | " +m.getValue().Description+ " | " +m.getValue().Leave);
     }
     			var EndTime = System.currentTimeMillis();
     			out.println("Time to Run" +(EndTime-StartTime)+ "ms");
        }
    }
