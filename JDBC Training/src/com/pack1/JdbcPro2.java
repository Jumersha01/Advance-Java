package com.pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

public class JdbcPro2 {
	String driver = "oracle.jdbc.OracleDriver";
	String dburl = "jdbc:oracle:thin:@localhost:1521:orcl";
	String dbUname = "Junaid";
	String dbPwd = "123";
	String query = "Select * from employee";
	String query1 = "insert into employee values ('105','Mannan','shah',50000,'pune')";
	String query2 = "delete from employee where EID ='108'";
	String query3 = " update employee set esal=90000 where eid='102'";

	Connection connects() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(dburl, dbUname, dbPwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	void showData() {
		try {
			Connection con = connects();
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(query);

			while (rs.next()) {

				IO.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getInt(4) + " "
						+ rs.getString(5));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void insertData() {
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(dburl, dbUname, dbPwd);
			Statement stm = con.createStatement();
			int rowCount = stm.executeUpdate(query1);
			if (rowCount == 0) {
				IO.println("Data not inserted ");
			} else {
				IO.println(rowCount + " Data Inserted ");
				IO.println("------------------------");
				showData();
			}

		} catch (SQLIntegrityConstraintViolationException e) {
			IO.println("Duplicate Empid's are not allowed :");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void deletEmpData() {
		try {
			Connection con = connects();
			Statement stm = con.createStatement();
			int rowCont = stm.executeUpdate(query2);

			if (rowCont == 0) {
				IO.println("Row with id not foud");
			} else {
				IO.println("Row deleted do you want to see emp table? (y/n)");

			}
			char choice = IO.readln().charAt(0);
			switch (choice) {
			case 'y', 'Y' -> showData();
			case 'n', 'N' -> System.exit(0);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void updateEmp() {
		try {
			Connection con = connects();
			Statement stm = con.createStatement();
			int rowCount = stm.executeUpdate(query3);
			if (rowCount == 0) {
				IO.println("Row is not Updated:");
			} else {
				IO.println("Row Updated do you want to See? (y/n):");
				char choice = IO.readln().charAt(0);
				switch (choice) {
				case 'y', 'Y' -> showData();
				case 'n', 'N' -> System.exit(0);
				}
				;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void main() {
		JdbcPro2 j = new JdbcPro2();
		j.updateEmp();
	}
}
