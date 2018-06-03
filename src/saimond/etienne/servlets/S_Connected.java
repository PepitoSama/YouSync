package saimond.etienne.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import saimond.etienne.business.B_Playlist;
import saimond.etienne.dao.D_Playlist;
import saimond.etienne.models.M_Playlist;
import saimond.etienne.models.M_User;

@WebServlet("/connected")
public class S_Connected extends HttpServlet {

	private static final long serialVersionUID = 1260340102976682513L;
	public static final String 	VIEW = "/WEB-INF/jsp/connected/Connected.jsp";
	private static final String URL_FIELD = "txtUrl";
	public static final String 	ERROR_FIELD = "txtError";
	public static final String 	RESULT_FIELD = "txtValid";
	
	private String result;
	private String resError;
	
	protected void 	doGet(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
		
		System.out.println("In the Connected doGet");
		
		HttpSession session = request.getSession(true);
		M_User user = (M_User) session.getAttribute("connectedUser");
		
		request.setAttribute(URL_FIELD, "");
		request.setAttribute("errorMessage", "");
		request.setAttribute("validMessage", "");
		
		if (user == null) {
			response.sendRedirect("login");
			return;
		} else {
			request.setAttribute("playlistUrl", "");
			ArrayList<M_Playlist> playlistList = D_Playlist.getAllUserPlaylist(user.getIdUser());
			request.setAttribute("playlistList", playlistList);
			this.getServletContext().getRequestDispatcher(VIEW).forward(request, response);
			return;
		}
	}

	protected void 	doPost(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
		
		System.out.println("In the Connected doPost");
		
		HttpSession session = request.getSession(false);
		
		if (session.getAttribute("connectedUser") == null) {
			response.sendRedirect("login");
		} else {
			M_User user = (M_User) session.getAttribute("connectedUser");
			
			String playlistUrl = request.getParameter("txtPlaylistUrl");
			
			if (B_Playlist.isValidUrl(playlistUrl)) {
				try {
					D_Playlist.addUrl(user.getIdUser(), playlistUrl);
					request.setAttribute("validMessage", "Succes !");
				} catch (SQLException e) {
					e.printStackTrace();
					request.setAttribute("errorMessage", "SQL Error");
				}
			} else {
				request.setAttribute("errorMessage", "Invalid URL");
			}
			ArrayList<M_Playlist> playlistList = D_Playlist.getAllUserPlaylist(user.getIdUser());
			request.setAttribute("playlistList", playlistList);
			this.getServletContext().getRequestDispatcher(VIEW).forward(request, response);
			return;
		}
	}
}
