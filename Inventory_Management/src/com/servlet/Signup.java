package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.signup;
import com.database.Database_Connectivity;



@WebServlet("/Signup")
public class Signup extends HttpServlet {
	
       
  
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Database_Connectivity dc = new Database_Connectivity();
		PrintWriter out = response.getWriter();
		signup sig = new signup();
		sig.setFull_Name(request.getParameter("fullname"));
		sig.setMobile(request.getParameter("mobile"));
		sig.setPassword(request.getParameter("password"));
		sig.setConfirm_Password(request.getParameter("confirmpassword"));
		sig.setRole(request.getParameter("role"));
		ArrayList<signup> list=new ArrayList<signup>();
		list.add(sig);
		boolean tik = dc.fetch(list);
		if(tik == true)
		{
			System.out.println("inside if");
			RequestDispatcher rd = request.getRequestDispatcher("/login.html");
			System.out.println("outside if");
			rd.include(request, response);
			out.println("User already registered");
		}
		else
		{
			System.out.println("inside else of send to request");
			dc.sendtorequest(sig);
			System.out.println("outside of send to request function");
			RequestDispatcher rd = request.getRequestDispatcher("/login.html");
			rd.include(request, response);
			out.println("User sucessfully registered");
		}
		
			
	}

}
