package saimond.etienne.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import saimond.etienne.models.M_Playlist;

import java.sql.DriverManager;

public class D_Playlist extends D_Context {

	public static boolean addUrl(int loginUser, String playlistUrl) throws SQLException {

		try (Connection connection = DriverManager.getConnection(dbURL, dbLogin, dbPassword)) {

			String strSql 	= "INSERT INTO T_Playlists(IdUserPlaylist, UrlPlaylist) " 
							+ "VALUES (?, ?);";

			PreparedStatement statement = connection.prepareStatement(strSql);
			statement.setInt(1, loginUser);
			statement.setString(2, playlistUrl);
			
			int resultSet = statement.executeUpdate();

			if (resultSet > 0) {
				System.out.println("yé");
				return true;
				
			} else {
				System.out.println("nup");
				return false;
			}
		}
	}
	
	public static M_Playlist getPlaylist(int idPlaylist) {
		try (Connection connection = DriverManager.getConnection(dbURL, dbLogin, dbPassword)) {

			String strSql 	= "SELECT *" 
							+ "FROM T_Playlist;"
							+ "WHERE IdPlaylist = ?";

			PreparedStatement statement = connection.prepareStatement(strSql);
			statement.setInt(1, idPlaylist);
			
			ResultSet resultSet = statement.executeQuery(strSql);
			if (resultSet.next()) {
				M_Playlist playlist =  new M_Playlist(resultSet.getString("url"));
					playlist.setIdPlaylist(resultSet.getInt("idPlaylist"));
					playlist.setIdUserPlaylist(resultSet.getInt("idUserPlaylist"));
					playlist.setLastSync(resultSet.getDate("lastSync"));
				return playlist;
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static ArrayList<M_Playlist> getAllUserPlaylist(int IdUser) {
		
		ArrayList<M_Playlist> playlistList = new ArrayList<M_Playlist>();
		
		try (Connection connection = DriverManager.getConnection(dbURL, dbLogin, dbPassword)) {
			
			String strSql 	= " SELECT * " 
							+ " FROM T_Playlists "
							+ " WHERE IdUserPlaylist = ?;";
	
			PreparedStatement statement = connection.prepareStatement(strSql);
			statement.setInt(1, IdUser);
			System.out.println(statement.toString());
			ResultSet resultSet = statement.executeQuery();
			
			if (resultSet.next()) {
			    do {
			    	M_Playlist playlist = new M_Playlist(resultSet.getString("urlPlaylist"));
					playlist.setIdPlaylist(resultSet.getInt("idPlaylist"));
					playlist.setIdUserPlaylist(resultSet.getInt("idUserPlaylist"));
					playlist.setUrl(resultSet.getString("urlPlaylist"));
					playlist.setLastSync(resultSet.getDate("lastSync"));
					playlistList.add(playlist);
			    } while(resultSet.next());
			} else {
				playlistList.add(new M_Playlist("You dont have playlist yet"));
			}
			
			return playlistList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
			return null;
	}
}