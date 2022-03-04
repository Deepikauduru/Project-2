package com.flightbooking;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/password")
public class Password extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		try {
		Connection1 dao=new Connection1();
		HttpSession session=request.getSession();
		if(dao.changeAdminPassword(email,password)) {
		session.setAttribute("message", "Password Changed "
				+ "Successfully");
		}
		else {
		session.setAttribute("message", "Invalid Details");
		}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("sorry");
		e.printStackTrace();
		}
		response.sendRedirect("Page.jsp");
		}
	

}
