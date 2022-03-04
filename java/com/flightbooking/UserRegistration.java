package com.flightbooking;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/userregistration")
public class UserRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String name=request.getParameter("name");
		String phno=request.getParameter("phno");
		String adno=request.getParameter("adno");
		HashMap<String,String> user=new HashMap<>();
		user.put("email", email);
		user.put("password", password);
		user.put("name", name);
		user.put("phno", phno);
		user.put("adno", adno);
		try {
		Connection1 dao=new Connection1();
		boolean result=dao.insertUser(user);
		HttpSession session=request.getSession();
		if(result) {
		session.setAttribute("message", "User Successfully Added ");
		}
		else {
		session.setAttribute("message","Invalid Details");
		}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("sorry");
		e.printStackTrace();
		}
		response.sendRedirect("UserPage.jsp");
		}	
}
