package com.database;
import java.sql.*;

import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;

import com.beans.signup;

public class Database_Connectivity {

	private static String url = "jdbc:mysql://localhost:3306/sims";
	private static String username = "root";
	private static String password = "";
	private static String driver = "com.mysql.jdbc.Driver";
	private static Connection con = null;
	private static PreparedStatement pstmt;
	private static ResultSet rs;
	private static final long serialVersionUID = 1L;
	
	private String full_Name;
	private String mobile;
	private String newpassword;
	private String confirm_Password;
	private String role;
	
	public static Connection getConnection()
	{
		
		try {
			System.out.println("above driver");
			Class.forName(driver);
			System.out.println("inside driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		try {
		 con = DriverManager.getConnection(url, username, password);
		 System.out.println("inside connection");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}
	public boolean validate(String uName,String uPass)
	{
		Database_Connectivity.getConnection();
		boolean t = false;
		try {
			pstmt = con.prepareStatement("select * from login");
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				if((rs.getString(1)).equals(uName) && rs.getString(2).equals(uPass))
				{
					t = true;
					break;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return t;
	}
	public boolean fetch(ArrayList<signup> s1)
	{
		boolean t = false;
		Iterator itr=s1.iterator();
		while(itr.hasNext())
		{
			signup signew = (signup)itr.next();
			full_Name = signew.getFull_Name();
			mobile = signew.getMobile();
			newpassword = signew.getPassword();
			confirm_Password = signew.getConfirm_Password();
			role = signew.getRole();
		}
		boolean check = validate(full_Name,newpassword);
		if(check == true)
		{
			t = true;
		}
	return t;	
	}
	public void sendtorequest(signup sig1)
	{
		System.out.println("inside of send to request function");
		full_Name =sig1.getFull_Name();
		mobile = sig1.getMobile();
		newpassword = sig1.getPassword();
		confirm_Password = sig1.getConfirm_Password();
		role = sig1.getRole();
		try
		{
			pstmt = con.prepareStatement("insert into requestlist values(?,?,?,?)");
			pstmt.setString(1, full_Name);
			pstmt.setString(2, mobile);
			pstmt.setString(3,newpassword);
			pstmt.setString(4,role);
			pstmt.execute();
		}
			catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("end of send to requeest function");
	}
	public boolean addItem(String iName,String qpitem,String ppitem,String tquantity,String tcost,String supid,String supname,String category) throws SQLException
	{
		System.out.println("inside db add item");
		boolean t = false;
	
			System.out.println("inside add item");
			pstmt = con.prepareStatement("insert into addinventory values(?,?,?,?,?,?,?,?)");
			System.out.println("after pstmt in addd item");
			pstmt.setString(1, iName);
			System.out.println("after i name addition");
			pstmt.setString(2, qpitem);
			pstmt.setString(3, ppitem);
			pstmt.setString(4, tquantity);
			pstmt.setString(5, tcost);
			pstmt.setString(6, supid);
			pstmt.setString(7, supname);
			pstmt.setString(8, category);
			pstmt.execute();
			t = true;
		
		
		System.out.println("before return");
		return t;
	}

}
