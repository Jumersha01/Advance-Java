package com.pack1;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class pro8 {
	void main() throws Exception{
		//retriveData();
		totalSal();
	}

	public Connection connect () {
		String driver = "oracle.jdbc.OracleDriver";
		String dburl = "jdbc:oracle:thin:@localhost:1521:orcl";
		String dbUname = "Junaid";
		String dbPwd = "123";
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(dburl, dbUname, dbPwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	void retriveData() {
		IO.print("Implementing  callablestatement ===> Procedure 2");	
	       
		Connection conn = connect();
		try {
			CallableStatement cstmt = conn.prepareCall("{call RetrieveEmpData(?,?,?,?,?)}");
			System.out.println("Enter Employee Id");
			String id= IO.readln();
			cstmt.setString(1, id);
			
			cstmt.registerOutParameter(2, Types.VARCHAR);
			cstmt.registerOutParameter(3, Types.VARCHAR);
			cstmt.registerOutParameter(4, Types.NUMERIC);
			cstmt.registerOutParameter(5, Types.NUMERIC);
			
			cstmt.execute();
			System.out.println("Employee Details");
			System.out.println("Employee id "+id);
			System.out.println("Employee name "+cstmt.getString(2));
			System.out.println("Employee name "+cstmt.getString(3));
			System.out.println("Employee name "+cstmt.getDouble(4));
			System.out.println("Employee name "+cstmt.getDouble(5));
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	 public void totalSal()  throws Exception {
		 Connection conn = connect();
		 try {
				CallableStatement cstmt = conn.prepareCall("{call ?:=RetrieveTsal(?)}");
				String empid=IO.readln("Enter emp id");
				cstmt.setString(2, empid);
				cstmt.registerOutParameter(1, Types.NUMERIC);
				cstmt.execute();
				System.out.println("Employee Details");
				System.out.println("Employee id "+ empid);
				System.out.println("Employee Total Salary "+cstmt.getInt(1));
				
			}catch(Exception e) {
				e.printStackTrace();
			}
	 }
}
