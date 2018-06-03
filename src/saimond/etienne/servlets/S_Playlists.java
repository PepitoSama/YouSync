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

import saimond.etienne.dao.D_Playlist;
import saimond.etienne.business.B_Playlist;
import saimond.etienne.models.M_Playlist;
import saimond.etienne.models.M_User;

@WebServlet("/playlists")
public class S_Playlists extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String 	VIEW = "/WEB-INF/jsp/connected/Playlists/Playlists.jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("In the addPlaylist doGet");

		HttpSession session = request.getSession(true);
		
		M_User user = (M_User) session.getAttribute("connectedUser");
		
		if (user == null) {
			response.sendRedirect("login");
		} else {
			ArrayList<M_Playlist> playlistList= D_Playlist.getAllUserPlaylist(user.getIdUser());
			request.setAttribute("playlistList", playlistList);
			
			request.getRequestDispatcher(VIEW).forward(request, response);
		}
		request.setAttribute("playlistUrl", "");
		request.setAttribute("errorMessage", "");
		request.setAttribute("validMessage", "");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("In the addPlaylist doPost");

		String playlistUrl = "";

		HttpSession session = request.getSession(true);

		if (session.getAttribute("connectedUser") == null) {
			response.sendRedirect("login");
		} else {
			M_User user = (M_User) session.getAttribute("connectedUser");
			playlistUrl = request.getParameter("txtPlaylistUrl");
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
			request.getRequestDispatcher(VIEW).forward(request, response);
		}
	}
}
