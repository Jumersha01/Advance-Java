package com.pack1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcPro13 {
	String driver = "oracle.jdbc.OracleDriver";
	String dbUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
	String dbUname = "Junaid";
	String dbPwd = "123";
    String sql1 = "insert into mydata2 values(?,?) ";
    String sql2 = "select FILE_DATA from mydata2 where id=?";

	Connection connect() {
		Connection con = null;
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(dbUrl, dbUname, dbPwd);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	void meth1() {
		 try {
			 Connection con = connect();
			 IO.println("Connection Created..!");
			PreparedStatement pstmt1= con.prepareStatement(sql1);
			pstmt1.setString(1, "101");
			pstmt1.setClob(2,new FileReader("D:\\Exams\\Data.txt"));
			
			int rowCount  = pstmt1.executeUpdate();
			  if(rowCount==0) {
				  throw new SQLException("File not inserted");
				  
			  }
			  else {
				  IO.println("File Inserted ");
				  
			  }
		 }
		 catch(Exception e) {
			 e.printStackTrace();
		 }
	}
	void meth2() {
		IO.println("Retriving the file from the Database");
		  try {
			  Connection con =connect();
			  IO.println("Database Connected..!");
			  PreparedStatement pstmt1 = con.prepareStatement(sql2);
			  pstmt1.setString(1,"101");
			  ResultSet rs = pstmt1.executeQuery();
			  if(rs.next()) {
				  Clob b =rs.getClob(1);
				  Reader data = b.getCharacterStream();
				  BufferedReader br = new BufferedReader(data);
				  FileWriter fw = new FileWriter("D:\\Exams\\Data2.txt");
				  String line;
				  while((line=br.readLine())!=null) {
					  fw.write(line);
				  }
				  br.close();
				  fw.close();
				  IO.println("Clob data Retrived ");
			  }
			  else {
				  throw new SQLException("Invalid Id");
			  }
			  
		  }
		  catch(Exception e) {
			  e.printStackTrace();
		  }
	}
	

	void main() {
//meth1();
		meth2();
	}
}
