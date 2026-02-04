package com.pack1;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

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
			CallableStatement cs = con.prepareCall("{call insertData(?,?,?,?,?,?,?,?,?)}");
			int id = Integer.parseInt(IO.readln("Enter Student Id:"));
			cs.setInt(1,id);
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.registerOutParameter(3, Types.VARCHAR);
			cs.registerOutParameter(4, Types.INTEGER);
			cs.registerOutParameter(5, Types.VARCHAR);
			cs.registerOutParameter(6, Types.VARCHAR);
			cs.registerOutParameter(7, Types.INTEGER);
			cs.registerOutParameter(8, Types.VARCHAR);
			cs.registerOutParameter(9, Types.BIGINT);
			
			IO.println("id"+id);
			IO.println("Name:"+cs.getString(2));
			IO.println("Branch"+cs.getString(3));
			IO.println("Roll no"+cs.getInt(4));
			IO.println("HouseNO:"+cs.getString(5));
			IO.println("City"+cs.getString(6));
			IO.println("Pincode"+cs.getInt(7));
			IO.println("Mailid:"+cs.getString(8));
			IO.println("phone"+cs.getLong(9));
			
			
			cs.execute();
			
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
void main() {
	m1();
}
}
