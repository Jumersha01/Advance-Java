package com.pack1;

import java.sql.Connection;

public class Pro10 {
	String driver = "oracle.jdbc.OracleDriver";
	String dburl = "jdbc:oracle:thin:@localhost:1521:orcl";
	String dbUname = "Junaid";
	String dbPwd = "123";
	void meth1() {
		ConnectionPooling cp = new ConnectionPooling(driver,dburl,dbUname,dbPwd);
		
		cp.con_Initialization();
		IO.println("\n----User 1------");
		Connection con1 = cp.con_Acquisition();
		IO.println("User 1 :"+con1);
		IO.println("--->"+cp.v.size());
		
		
		IO.println("\n----User 2------");
		Connection con2 = cp.con_Acquisition();
		IO.println("User 1 :"+con2);
		IO.println("--->"+cp.v.size());
		
		
		
		IO.println("\n----User 3------");
		Connection con3 = cp.con_Acquisition();
		IO.println("User 1 :"+con3);
		IO.println("--->"+cp.v.size());
		
		IO.println("----------------------");

		cp.con_Return(con1);
		cp.con_Return(con2);
		cp.con_Return(con3);
		
		
	}
	void main() {
		Pro10 obj = new Pro10();
		obj.meth1();
	}
}
