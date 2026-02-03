package com.pack1;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class Lab01 {
	String driver ="oracle.jdbc.OracleDriver";
	String dburl = "jdbc:oracle:thin:@localhost:1521:orcl";
	String uname = "Junaid";
	String pwd = "123";
	
	Connection connect () {
		Connection con=null;
		try {
			IO.println("Connecting to database..");
			Class.forName(driver);
			con = DriverManager.getConnection(dburl,uname,pwd);
			
		}
		catch(Exception e) {
		e.printStackTrace();
		}
		return con;
	}
	
	void m1 () {
		try {
			Connection con = connect();
			CallableStatement cs = con.prepareCall("{cal insertData(?,?,?,?,?,?,?,?,?)}");
			cs.setString(1, "1");
			cs.setString(2, "35");
			cs.setString(3, "Junaid");
			cs.setString(4,"Science");
			cs.setString(5, "4");
			cs.setString(6,"Jalgaon");
			cs.setInt(7, 123);
			cs.setString(8,"junnu@gmail.com");
			cs.setInt(9,902142);
			
			boolean isCame = cs.execute();
			if(isCame) {
				IO.println("Procedure execute");
			}
			else{
				IO.println("Faced some Problem");
			}
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
void main() {
	m1();
}
}
