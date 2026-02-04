package com.pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Arrays;

public class JdbcPro14 {
	String driver = "oracle.jdbc.OracleDriver";
	String dbUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
	String dbUname = "Junaid";
	String dbPwd = "123";
	
	Connection connect() {
		Connection con = null;
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(dbUrl,dbUname,dbPwd);
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
	}
		return con;
	}
	void meth1() {
		IO.println("Implentin batch processing");
		try {
			Connection con = connect();
			Statement  stmt = con.createStatement();
			IO.println("How many Queries you want to add to the batch:");
			int noOfQueries = Integer.parseInt(IO.readln());
			for(int i = 1 ;i<=noOfQueries;i++) {
				stmt.addBatch(IO.readln("Enter Your Query: "+(i)));
			}
			IO.println(noOfQueries+" added to the batch");
			int rowCount[] = stmt.executeBatch();
			IO.println("=====>"+Arrays.toString(rowCount));
			stmt.clearBatch();
		}
		catch(Exception e) {
			
		}
	}
   void main() {
	   meth1();
   }
}
