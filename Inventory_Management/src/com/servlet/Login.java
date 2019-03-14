package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.database.Database_Connectivity;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }


	public void init(ServletConfig config) throws ServletException 
	{
	
	}

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		Database_Connectivity dc = new Database_Connectivity();
		PrintWriter out = response.getWriter();
		String uName = request.getParameter("username");
		String uPass = request.getParameter("password");
		System.out.println(uName+":"+uPass);
		boolean k = dc.validate(uName, uPass);
		
		if(k == true)
		{
			RequestDispatcher rd = request.getRequestDispatcher("/index.html");
			//System.out.println("request granted");
			rd.forward(request, response);
		}
		else
		{
			RequestDispatcher rd = request.getRequestDispatcher("/login.html");
			System.out.println("request not granted");
			rd.include(request, response);
		}
	}

	
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
