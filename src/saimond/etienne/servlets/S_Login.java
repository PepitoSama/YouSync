package saimond.etienne.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import saimond.etienne.dao.D_Context;
import saimond.etienne.dao.D_User;
import saimond.etienne.models.M_User;

@WebServlet(urlPatterns = "/login", loadOnStartup = 1)
public class S_Login extends HttpServlet {

	private static final long serialVersionUID = 758132688251718196L;
	public static final String 	VIEW = "/WEB-INF/jsp/user/login/Login.jsp";
	
	@Override
	public void init() throws ServletException {
		D_Context.init(this.getServletContext());
		System.out.println("Creating servlet");
	}

	protected void 	doGet(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {

		System.out.println("In the login doGet");

		// Check if user is alreay connected
		HttpSession session = request.getSession(true);
		if (session.getAttribute("connectedUser") != null) {
			response.sendRedirect("connected");
			return;
		}

		request.setAttribute("login", "");
		request.setAttribute("password", "");
		request.setAttribute("host", D_Context.getHost());
		request.setAttribute("errorMessage", "");
		request.getRequestDispatcher(VIEW).forward(request, response);
		return;
	}

	protected 	void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {

		System.out.println("In the login doPost");

		String login = request.getParameter("txtLogin");
		String password = request.getParameter("txtPassword");

		request.setAttribute("login", login);
		request.setAttribute("password", password);

		M_User connectedUser = D_User.isValidLogin(login, password);
		HttpSession session = request.getSession(true);
		if (connectedUser != null) {
			session.setAttribute("connectedUser", connectedUser);
			response.sendRedirect("connected");
			return;

		} else {
			request.setAttribute("errorMessage", "Bad identity");
			System.out.println("Hum");
			request.getRequestDispatcher(VIEW).forward(request, response);
			return;
		}

	}
}
