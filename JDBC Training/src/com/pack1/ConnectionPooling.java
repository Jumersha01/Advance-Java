package com.pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Vector;

public class ConnectionPooling {
       String driver,dbUrl,dbUname,dbPwd;
       Vector<Connection> v = new Vector();

	   public ConnectionPooling(String driver, String dbUrl, String dbUname, String dbPwd) {
		super();
		this.driver = driver;
		this.dbUrl = dbUrl;
		this.dbUname = dbUname;
		this.dbPwd = dbPwd;
	   }
	   public void con_Initialization() {
		   IO.println("Conneciton Pool is Empty: ");
		   IO.println("There are "+v.size()+" Connection Objects");
		   while(v.size()<5) {
			   try {
				   Class.forName(driver);
				   Connection con = DriverManager.getConnection(dbUrl,dbUname,dbPwd);
				   v.addElement(con);
			   }
			   catch(Exception e) {
				   e.printStackTrace();
			   }
		   }
		   for(Object o:v) {
			   IO.println(o);
			   IO.println("There are "+v.size()+ "Connection Objects");
			   
		   }
	   }
	   public Connection con_Acquisition() {
		   Connection con = v.get(0);
		   v.remove(0);
		   return con;
	   }
	   public void con_Return(Connection con) {
		   IO.println("Adding the Connetion Objet to the ConnectionPool");
		   v.addElement(con);
		   IO.println("There are "+v.size()+ "Connection Objects");
		    for(Object o : v) {
		    	IO.println(o);
		    }
	   }
	      
}
