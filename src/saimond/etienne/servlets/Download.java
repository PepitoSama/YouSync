package saimond.etienne.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import saimond.etienne.models.M_User;

@WebServlet("/download")
public class Download extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(true);
		M_User user = (M_User) session.getAttribute("connectedUser");
		
		if (user == null) {
			response.sendRedirect("login");
		} else {
		}
    }
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
		HttpSession session = request.getSession(true);
		M_User user = (M_User) session.getAttribute("connectedUser");
		
		if (user == null) {
			response.sendRedirect("login");
		} else {
			
		}
    }
}