package com.pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Savepoint;

public class Pro9 {
	void main() {
		mathod1();
	}

	String sqlQuery1 = "update  TRAINSEATAVAILABILITY set   AVAILABLE_SEATS=AVAILABLE_SEATS-1 WHERE TRAIN_ID=?"
			+ "and   JOURNEY_DATE=? and CLASS=? AND  AVAILABLE_SEATS>0";
	String sqlQuery2 = "insert into  BOOKINGDETAILS  values(?,?,?,?,?)";
	String sqlQuery3 = "select PAYMENT_STATUS from CUSTOMERPAYMENT where  CUSTOMER_ID =? ";
	String sqlQuery4 = "update BOOKINGDETAILS  set STATUS='Confirmed' where   CUSTOMER_ID=? ";

	public Connection connect() {
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

	void mathod1() {
		IO.println("Implementing transacation Management:");
		try {
			Connection con = connect();
			IO.println("Database Connected SuccesFuly");
			IO.println("Before AutoCommit -> " + con.getAutoCommit());
			con.setAutoCommit(false);
			IO.println("After Disabling AutoCommit -> " + con.getAutoCommit());
			PreparedStatement pstmt1 = con.prepareStatement(sqlQuery1);
			pstmt1.setString(1, "12345");
			pstmt1.setString(2, "2024-10-10");
			pstmt1.setString(3, "SLEEPER");
			int rowCount = pstmt1.executeUpdate();
			if (rowCount == 0) {
				throw new RuntimeException("Seats not Avalaible for booking!!!");

			} else {
				IO.println("Seat is locked for booking");
				Savepoint sp = con.setSavepoint();
				PreparedStatement pstmt2 = con.prepareStatement(sqlQuery2);
				pstmt2.setString(1, "B102");
				pstmt2.setString(2, "12345");
				pstmt2.setString(3, "C123");
				pstmt2.setInt(4, 1);
				pstmt2.setString(5, "Payment Pending");

				int rowCount2 = pstmt2.executeUpdate();
				if (rowCount == 0)
					throw new RuntimeException("Booking record not created");
				else
					IO.println("Booking record created \n Awaiting for payment Confirmation!!!");
				PreparedStatement pstmt3 = con.prepareStatement(sqlQuery3);
				pstmt3.setString(1, "C123");
				ResultSet rs = pstmt3.executeQuery();
				String status = "Failed";
				if (rs.next()) {
					status = rs.getString(1);
					if (status.equals("Failed")) {
						throw new RuntimeException("Transaction Failed");
					} else {
						PreparedStatement pstmt4 = con.prepareStatement(sqlQuery4);
						pstmt4.setString(1, "C123");
						int rowCount3 = pstmt4.executeUpdate();
						if (rowCount3 == 0) {
							throw new RuntimeException("Transaction failed at payment portal");

						} else {
							IO.println("Ticket Booked Succufully");
							con.commit();
						}
					}
				} 
				else
					IO.println("Transaction Failed");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		;
	}

}
