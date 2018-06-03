package saimond.etienne.models;

import java.sql.Date;

public class M_Playlist {
		
	private int 	IdPlaylist;
	private int 	IdUserPlaylist;
	private String 	url;
	private Date 	LastSync;
	
	public M_Playlist(String url) {
		setUrl(url);
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getIdPlaylist() {
		return IdPlaylist;
	}

	public void setIdPlaylist(int idPlaylist) {
		IdPlaylist = idPlaylist;
	}

	public int getIdUserPlaylist() {
		return IdUserPlaylist;
	}

	public void setIdUserPlaylist(int idUserPlaylist) {
		IdUserPlaylist = idUserPlaylist;
	}

	public Date getLastSync() {
		return LastSync;
	}

	public void setLastSync(Date lastSync) {
		LastSync = lastSync;
	}
}
