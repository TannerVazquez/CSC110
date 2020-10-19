public class UserInfo implements Comparable<UserInfo> {
    public String SerialNum;
    public String CompanyName;
    public String EmployeeName;
    public String Description;
    public String Leave;

    
    public int compareTo(UserInfo other) {
    	return SerialNum.compareToIgnoreCase(other.SerialNum);
    	
    }
    
    public boolean equals(UserInfo other) {
    	return SerialNum.equals(other.SerialNum);
    	
    }
}