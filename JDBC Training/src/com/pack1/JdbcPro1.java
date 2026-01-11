

package com.pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class JdbcPro1 {
void connect() {
	IO.println("Connecting to the Database");
	String driver = "oracle.jdbc.OracleDriver";
	String dburl ="jdbc:oracle:thin:@localhost:1521:orcl";
	String dbUname="Junaid";
	String dbPwd = "123";
	
	try {
		Class.forName(driver);
		Connection con = DriverManager.getConnection(dburl,dbUname,dbPwd);
		IO.println("Connection Created");
		con.close();
		
	}
	catch(Exception e) {
		e.printStackTrace();
		
	}
}
public static void main(String [] args) {
	JdbcPro1 obj = new JdbcPro1();
	obj.connect();
	
}

}
