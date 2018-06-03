package saimond.etienne.business;

import org.apache.commons.validator.routines.UrlValidator;


public class B_Playlist {

	public static boolean isValidUrl(String url) {
		UrlValidator validator = new UrlValidator();
		if (validator.isValid(url)) {
			return true;
		}
		return false;
	}
}
