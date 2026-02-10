import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Jdbc_01 {
    void main() {
    	Connection con = connects();
    	IO.println("1.register");
    	IO.println("2.Login");
    	 
    	int choice = Integer.parseInt(IO.readln());
    	switch(choice) {
    	case 1->{
    		IO.println("Registering the user...");
    		String id = IO.readln("Enter Employee id:");
    		String name = IO.readln("Enter Employee name:");
    		int sal =Integer.parseInt(IO.readln("Enter Employee salary:"));
    		String fname = IO.readln("Enter Employee first name:");
    		String lname = IO.readln("Enter Employee last name:");
    		String mail = IO.readln("Enter Employee mail id:");
    		String phone = IO.readln("Enter Employee phone no:");
    		try {
    			PreparedStatement pstmt = con.prepareStatement("insert into  employe_info values (?,?,?,?,?,?,?)");
    			pstmt.setString(1,id);
    			pstmt.setString(2,name);
    			pstmt.setInt(3,sal);
    			pstmt.setString(4,fname);
    			pstmt.setString(5,lname);
    			pstmt.setString(6,mail);
    			pstmt.setString(7,phone);
    			
    		}
    		catch(Exception e) {
    			e.printStackTrace();
    		}
    		
    		
    		
    	}
    	}
    	
    }
    
    public Connection connects() {
    	  String driver = "oracle.jdbc.OracleDriver";
   	   String dbUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
   	   String user ="Junaid";
   	   String pswd = "123";
   	  
   	   Connection con = null;
   	  
   	   
   	  try {
   		  Class.forName(driver);
   		   con = DriverManager.getConnection(dbUrl,user,pswd);
   		  
   		  
   	  }
   	  catch(Exception e)
   	  {
   		  e.printStackTrace();
   	  }
   	   
   	  return con;
   
    }
}
