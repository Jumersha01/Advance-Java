package com.pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateProductDAO {
  public int updateProduct(ProductBean pb) {
	  int rowCount =0;
	  try {
		  Connection con = DBConnect.getCon();
		// PreparedStatement pstmt= con.prepareStatement("update product set price=? and pqty=? where pcode=?");
		  PreparedStatement pstmt = con.prepareStatement(
				    "UPDATE product SET pprice = ?, pqty = ? WHERE pcode = ?"
				);
		  pstmt.setString(1,pb.getP_price());
		  pstmt.setString(2,pb.getP_qty());
		  pstmt.setString(3,pb.getP_code());
		  rowCount = pstmt.executeUpdate();
	  }
	  catch(Exception e) {
		  e.printStackTrace();
	  }
	  return rowCount;
  }
}
