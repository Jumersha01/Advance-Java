package com.pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcPro16 {

	String driver = "oracle.jdbc.OracleDriver";
	String dbUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
	String dbUname = "Junaid";
	String dbPwd = "123";
	String sql1 = "select * from food";
	int total = 0;

	Connection connect() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(dbUrl, dbUname, dbPwd);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	void display() {
		try {
			Connection con = connect();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql1);
			while (rs.next()) {
				IO.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void order() {
		int foodId = Integer.parseInt(IO.readln("Enter food id:"));
		int qty = Integer.parseInt(IO.readln("Enter food quantity:"));
		
		try {
			int price=0;
			Connection con = connect();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql1);
			while(rs.next()) {
				if(foodId==rs.getInt(1)) {
				price =rs.getInt(3);
				}
			}
				
		
			PreparedStatement pstmt=con.prepareStatement("insert into Orders1 values(?,?,?,?)");
			pstmt.setInt(1, 101);
			pstmt.setInt(2, foodId);
			pstmt.setInt(3, qty);
			pstmt.setInt(4, (qty*price));
			
			int rowCount = pstmt.executeUpdate();
			if(rowCount==0) {
				IO.println("Row not inserted");
				
			      char ch = IO.readln("Enter Your Choice: ").charAt(0);
			      if(ch=='Y'||ch=='y')
			      {
			    	  Statement stmt1 = con.createStatement();
						ResultSet rs1 = stmt1.executeQuery("Select * from Orders1");
						while(rs1.next()) {
							IO.println(rs1.getInt(1)+" "+rs1.getInt(2)+" "+ rs1.getInt(3)+" "+rs.getInt(4));
						} 
			    	  
			      }
			      else {
			    	    IO.println("Closing the Application..");
			    	    System.exit(0);
			      }
			}
			else {
				IO.println("Row inserted");
			}
			
		
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	void main() {
		display();
		order();

	}
}
