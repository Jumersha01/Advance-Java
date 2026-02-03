package com.pack1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcPro12 {
	String driver = "oracle.jdbc.OracleDriver";
	String dbUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
	String dbUname = "Junaid";
	String dbPwd = "123";
	String sql1 = "insert into mydata values(?,?)";
	String sql2 = "select pic from mydata where PIC_ID=?";
	
	
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
	
	void m1 () {
		Connection con = connect();
		try {
			PreparedStatement pstmt1 = con.prepareStatement(sql1);
			pstmt1.setString(1,"101");
			FileInputStream fis = new FileInputStream("C:\\Users\\DELL\\Pictures\\Saved Pictures\\oct.png");
			pstmt1.setBlob(2, fis,fis.available());
			int rowCount = pstmt1.executeUpdate();
			if(rowCount==0) {
				throw new RuntimeException("Image not inserted");
			}else {
				IO.println("Image Inserted");
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	void m2() {
		Connection con = connect();
		try {
			PreparedStatement pstmt1 = con.prepareStatement(sql2);
			pstmt1.setString(1,"101");
			ResultSet rs = pstmt1.executeQuery();
			if(rs.next()) {
				Blob b = rs.getBlob(1);
				byte arr[]=b.getBytes(1,(int)b.length());
				FileOutputStream fos = new FileOutputStream("C:\\Users\\DELL\\Pictures\\Saved Pictures\\oct2.png");
				fos.write(arr);
				IO.println("Image Retrived!");
				fos.close();
			}
			else {
				IO.println("Image not found");
			}
	}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
 void main() {
	 //m1();
	 m2();
 }
 
}
