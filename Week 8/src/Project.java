import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import static java.lang.System.out;
import java.util.TreeSet;

public class Project {
	    public static void main(String... args) throws IOException{
	    	
	    	var fileName = "./src/Sample500.csv";
	        var filePath = Paths.get(fileName);

	        if(!Files.exists(filePath)) 
	            out.println("The File " + fileName + " could not be found");
	        
	        var startTime = System.currentTimeMillis();
	        var userInfo = new TreeSet<UserInfo>();
	        var readStream = Files.newBufferedReader(filePath);
	        var data = readStream.readLine();
	        
	        var LineCount = 0;
	        
	        var outfileName = "./src/BadData.txt";
	    	var outfilePath = Paths.get(outfileName);
	    	var writeStream = Files.newBufferedWriter(outfilePath);
	    	
	    	var isBadData = false;
	    	
	        while(data !=null && data.length()>0) {
	            data = readStream.readLine();
	            LineCount ++; 
	            
				    if (data!= null) {
				    var elements = data.split(",");
				    var user = new UserInfo();
				    
				    if (elements.length < 8) isBadData = true;
				    else {
				    	if (!elements[0].isBlank())
				    	user.SerialNum = elements[0];
				    
				    	else isBadData = true;
				    
					    if (!elements[1].isBlank()) 
					    	user.CompanyName = elements[1];
					    
					    	else isBadData = true;
					    
					    if (!elements[2].isBlank()) 
					    	user.EmployeeName = elements[2];
					    
					    	else isBadData = true;
					    
					    if (!elements[3].isBlank()) 
					    	user.Description = elements[3];
					    
					    	else isBadData = true;
					    
					    if (!elements[4].isBlank()) 
					    	user.Leave = elements[4];
					    
					    	else isBadData = true;
					    if (!elements[5].isBlank()) 
					    	user.Phone = elements[5];
					    
					    	else isBadData = true;
					    if (!elements[6].isBlank()) 
					    	user.Address = elements[6];
					    
					    else isBadData = true;
					    
				    	user.Time = elements[7];
				    
				    }
				   
				    if(!isBadData) {
			    	userInfo.add(user);
				    }
				    
		    		else {
			    		writeStream.write("Row number: " + LineCount);
			    		writeStream.newLine();
			    		isBadData = false;
			    	}
			    } 	
	        }      
		    
		    readStream.close();
		    writeStream.close();
		
	        var outfileName1 = "./src/GoodData.txt";
	        var outfilePath1 = Paths.get(outfileName1);
    		
	    	writeStream = Files.newBufferedWriter(outfilePath1);
		    	
			writeStream.write("Serial Number | Company Name | Employee Name | Leave | Phone | Address | Time");
			writeStream.newLine();
		
			for (UserInfo users: userInfo) {
				writeStream.write(users.SerialNum+ " | " +users.CompanyName+ " | " 
			         +users.EmployeeName+ " | " +users.Description+ " | " +users.Leave+ "|"
			         +users.Phone+ "|" +users.Address+ "|" +users.Time);
				writeStream.newLine();
		    }
			writeStream.close();
			
			var endTime = System.currentTimeMillis();
			out.println("Data Structure: TreeSet");
			out.println("Time Taken:" + (endTime - startTime) + " ms");
    }
	    	
	    	
	    
}

