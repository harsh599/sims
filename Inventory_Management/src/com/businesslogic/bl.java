package com.businesslogic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class bl 
{
	private static Connection con = null;
	private static PreparedStatement pstmt;
	private static ResultSet rs;
	public boolean addItem(String iName,String qpitem,String ppitem,String tquantity,String tcost,String supid,String supname,String category)
	{
		boolean t = false;
		try {
			System.out.println("inside add item");
			pstmt = con.prepareStatement("insert into addinventory values(?,?,?,?,?,?,?,?)");
			System.out.println("after pstmt in addd item");
			pstmt.setString(1, iName);
			pstmt.setString(2, qpitem);
			pstmt.setString(3, ppitem);
			pstmt.setString(4, tquantity);
			pstmt.setString(5, tcost);
			pstmt.setString(6, supid);
			pstmt.setString(7, supname);
			pstmt.setString(8, category);
			pstmt.execute();
			t = true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("outside of add item");
		return t;
	}

}
