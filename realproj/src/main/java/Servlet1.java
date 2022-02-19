import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import static javax.swing.JOptionPane.showMessageDialog;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet1 extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		PrintWriter out = res.getWriter();	
		res.setContentType("text/html");
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		String gender = req.getParameter("gender");
		String bldgrp = req.getParameter("bldgrp");
		String dob = req.getParameter("dob");
		String mobile =req.getParameter("mobile");
		String email = req.getParameter("email");
		String state = req.getParameter("state");
		String district = req.getParameter("district");
		String city = req.getParameter("city");
		
		
		
		
		    try {
		    	
		    	Class.forName("com.mysql.jdbc.Driver");
		        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/bld","root","1234");
		    	PreparedStatement ps=con.prepareStatement("insert into bloodbank values(?,?,?,?,?,?,?,?,?,?)");
		    	ps.setString(1, name); 
		    	ps.setInt(2, age); 
		    	ps.setString(3, gender); 
		    	ps.setString(4, bldgrp);
		    	ps.setString(5, dob); 
		    	ps.setString(6, mobile);
		    	ps.setString(7, email);
		    	ps.setString(8, state);
		    	ps.setString(9, district);
		    	ps.setString(10, city);

		    	
		    	ps.executeUpdate();

		    	ps.close();

		    	con.close();

		    	}

		    	catch (Exception e)

		    	{
		    		
		    	System.out.println(e);

		    	}
		    RequestDispatcher dis = req.getRequestDispatcher("h.html");
			
			dis.forward(req,res);
		    
		  }	    
	}

		    	

		

