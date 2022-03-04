package com.flightbooking;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/AdminLogin")
public class LoginAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		 String email=request.getParameter("email");
		 String password=request.getParameter("password");
		 try {
		 Connection1 dao=new Connection1();
		 if(dao.checkAdmin(email,password)) {
		 response.sendRedirect("Home.jsp");
		 }
		 else {
		 HttpSession session=request.getSession();
		 session.setAttribute("message", "Invalid Details");
		 response.sendRedirect("Page.jsp");
		 }
		 } catch (ClassNotFoundException | SQLException e) {
		 // TODO Auto-generated catch block
		 e.printStackTrace();
		 }
		 }
	

}
