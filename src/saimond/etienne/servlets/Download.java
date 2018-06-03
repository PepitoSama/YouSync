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

import saimond.etienne.business.B_Download;
import saimond.etienne.business.B_Playlist;
import saimond.etienne.dao.D_Playlist;
import saimond.etienne.models.M_Playlist;
import saimond.etienne.models.M_User;

@WebServlet("/download")
public class Download extends HttpServlet {

	private static final long serialVersionUID = 2596951202216809339L;
	public static final String 	VIEW = "/WEB-INF/jsp/connected/Connected.jsp";
	public static final String URL_FIELD = "txtUrl";
	public static final String 	ERROR_FIELD = "txtError";
	public static final String 	RESULT_FIELD = "txtValid";
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		private String result;
		private String resError;
		
		HttpSession session = request.getSession(true);
		M_User user = (M_User) session.getAttribute("connectedUser");
		
		if (user == null) {
			response.sendRedirect("login");
		} else {
		}
    }
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
		HttpSession session = request.getSession(true);
		
		if (session.getAttribute("connectedUser") == null) {
			response.sendRedirect("login");
		} else {
			M_User user = (M_User) session.getAttribute("connectedUser");
			String playlistUrl = request.getParameter("txtPlaylistUrl");
			
			if (B_Playlist.isValidUrl(playlistUrl)) {
				B_Download.download(user.getIdUser(), playlistUrl);
				request.setAttribute("validMessage", "Succes !");
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