package com.flightbooking;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/FlightList")
public class FlightList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String from=request.getParameter("from");
		String to=request.getParameter("to");
		String departure=request.getParameter("departure");
		try {
		Connection1 dao = new Connection1();
		List<String[]> flights=dao.getDetails(from, to,
		departure);
		HttpSession session=request.getSession();
		session.setAttribute("flights", flights);
		} 
		catch ( ClassNotFoundException |SQLException e) {
		e.printStackTrace();
		}
		response.sendRedirect("FlightList.jsp");
	}
		


}