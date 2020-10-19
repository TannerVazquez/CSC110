import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import static java.lang.System.out;
import java.util.Collections;
import java.util.TreeSet;

public class Part2 {
    public static void main(String... args) throws IOException{
    	var StartTime = System.currentTimeMillis();
    	
    	var fileName = "./src/Sample500.csv";
        var filePath = Paths.get(fileName);

        if(!Files.exists(filePath)) 
            out.println("The File " + fileName + " could not be found");
        var userInfo = new TreeSet<UserInfo>(Collections.reverseOrder());
        var readStream = Files.newBufferedReader(filePath);
        var data = readStream.readLine();
        var count = 0;
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
        userInfo.add(user);
     
     }
        
       count ++; 
        }     
        
        readStream.close();

     out.println("Serial Number | Company Name | Employee Name | Leave");
    
     for (var users : userInfo) {
         out.println(users.SerialNum+ " | " +users.CompanyName+ " | " 
         +users.EmployeeName+ " | " +users.Description+ " | " +users.Leave);
     }
     		var EndTime = System.currentTimeMillis();
     		var TotalTime = EndTime - StartTime;
     		out.println("Time to Run" +(TotalTime)+ "ms"); 
     
     		
	var outfileName = "./src/Write.txt";
	var outfilePath = Paths.get(outfileName);
		
	var writeStream = Files.newBufferedWriter(outfilePath);
	
	writeStream.write("Serial Number | Company Name | Employee Name | Leave");
	writeStream.newLine();
	
	 for (UserInfo users: userInfo) {
		 writeStream.write(users.SerialNum+ " | " +users.CompanyName+ " | " 
		         +users.EmployeeName+ " | " +users.Description+ " | " +users.Leave);
		 writeStream.newLine();
		 
		 
	 }
	 	var Average  = (Float.valueOf(TotalTime)/count);
	 	writeStream.newLine();
	 	writeStream.write(String.valueOf(Average)+ " Average Time per Line in Milliseconds");
	
	 	writeStream.close();
	 	 out.println(Float.valueOf(TotalTime)/count + " Average Time per Line in ms");	
	}
	
   
        }
  
