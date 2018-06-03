package saimond.etienne.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import saimond.etienne.models.M_User;

@WebServlet("/admin")
public class S_Admin extends HttpServlet {

	private static final long serialVersionUID = 4879920839425797541L;
	public static final String 	VIEW = "/WEB-INF/jsp/admin/Admin.jsp";
	protected void 	doGet(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {

		System.out.println("In the admin doPost");
		
		HttpSession session = request.getSession(true);
		M_User user = (M_User) session.getAttribute("connectedUser");
		
		if (user == null) {
			response.sendRedirect("login");
		} else if (user.isAdmin()){
			request.getRequestDispatcher(VIEW).forward(request, response);
		} else {
			response.sendRedirect("connected");
		}
	}

	protected void 	doPost(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {

		System.out.println("In the admin doPost");
		
		HttpSession session = request.getSession(true);
		if (session.getAttribute("connectedUser") == null) {
			response.sendRedirect("login");
		} else {
			request.getRequestDispatcher(VIEW).forward(request, response);
		}
	}
}
