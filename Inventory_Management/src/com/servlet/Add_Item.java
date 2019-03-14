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

import com.businesslogic.bl;
import com.database.Database_Connectivity;


@WebServlet("/Add_Item")
public class Add_Item extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Add_Item() {
        super();
        
    }

	
	public void init(ServletConfig config) throws ServletException {
		
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		boolean t = false;
		System.out.println("Inside add item servlet");
		PrintWriter out = response.getWriter();
		String iName = request.getParameter("itemname");
		String qpitem = request.getParameter("quantity/item");
		String ppitem = request.getParameter("price/item");
		String tquantity = request.getParameter("totalquantity");
		String tcost = request.getParameter("totalcost");
		String supid = request.getParameter("supplierid");
		String supname = request.getParameter("suppliername");
		String category = request.getParameter("category");
		Database_Connectivity dc1 = new Database_Connectivity();
		System.out.println("above add item calling");
		
		try {
			t = dc1.addItem(iName,qpitem,ppitem,tquantity,tcost,supid,supname,category);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("after calling add item");
		if(t == true)
		{
			System.out.println("ITEM ADDED SUCESSFULLY");
			RequestDispatcher rd = request.getRequestDispatcher("/table.html");
						rd.forward(request, response);
			
		}
		else
		{
			RequestDispatcher rd = request.getRequestDispatcher("/form.html");
			//System.out.println("request granted");
			rd.forward(request, response);
			System.out.println("ITEM FAILED TO BE ADDED");
		}
	}
	public void destroy() {
		
	}
}
