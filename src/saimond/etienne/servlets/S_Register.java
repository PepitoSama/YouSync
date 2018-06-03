package saimond.etienne.servlets;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import saimond.etienne.dao.D_User;
import saimond.etienne.models.M_User;

@WebServlet("/register")
public class S_Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static final String 	VIEW			= "/WEB-INF/jsp/user/register/Register.jsp";
	private static final String LOGIN_FIELD		= "txtLogin";
	private static final String EMAIL_FIELD		= "txtEmail";
	private static final String PASS_FIELD		= "txtPassword";
	private static final String CONF_FIELD		= "txtRePassword";
	private static final String NAME_FIELD		= "txtName";
	private static final String LASTNAME_FIELD	= "txtLastName";
	private static final String BIRTH_FIELD		= "txtBirth";
	public static final String 	ERROR_FIELD		= "txtError";
	public static final String 	RESULT_FIELD	= "txtValid";

	private String result;
	private String resError;

	private Map<String, String> error = new HashMap<String, String>();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher(VIEW).forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

		resetError();
		
		String login		= getFieldValue(request, LOGIN_FIELD);
		String email		= getFieldValue(request, EMAIL_FIELD);
		String password		= getFieldValue(request, PASS_FIELD);
		String confirm		= getFieldValue(request, CONF_FIELD);
		String name			= getFieldValue(request, NAME_FIELD);
		String lastName		= getFieldValue(request, LASTNAME_FIELD);
		String birthDate	= getFieldValue(request, BIRTH_FIELD);
		M_User user			= new M_User();
	
		try {
			loginValid(login);
		} catch (Exception e) {
			setError(LOGIN_FIELD, e.getMessage());
		}
		user.setLogin(login);
	
		try {
			emailValid(email);
		} catch (Exception e) {
			setError(EMAIL_FIELD, e.getMessage());
		}
		user.setEmail(email);
	
		try {
			passwordValid(password, confirm);
		} catch (Exception e) {
			setError(PASS_FIELD, "");
			setError(CONF_FIELD, e.getMessage());
		}
		user.setPassword(password);
	
		try {
			nameValid(name);
		} catch (Exception e) {
			setError(NAME_FIELD, e.getMessage());
		}
		user.setName(name);
	
		try {
			nameValid(lastName);
		} catch (Exception e) {
			setError(LASTNAME_FIELD, e.getMessage());
		}
		user.setName(name);
	
		try {
			birthValid(birthDate);
		} catch (Exception e) {
			setError(BIRTH_FIELD, e.getMessage());
		}
		user.setBirth(birthDate);
		
		System.out.println(error.toString());
		if (error.isEmpty()) {
			result = "Succes.";
			resError = "";
			
			Date birth = Date.valueOf(birthDate);
	        try {
			D_User.setInfo(login, password, birth, name, lastName, email);
			} catch (SQLException e) {
				result = "";
				resError = "Failed to add in DB";
				e.printStackTrace();
			}
		} else {
			result = "";
			resError = "Failed.";
		}
		request.setAttribute(ERROR_FIELD, resError);
		request.setAttribute(RESULT_FIELD, result);
	
		request.setAttribute("error", error);
	
		this.getServletContext().getRequestDispatcher(VIEW).forward(request, response);
	}

	private void birthValid(String birth) throws Exception {
		if (birth == null) {
			throw new Exception("Enter a correct date.");
		}

	}

	private void loginValid(String login) throws Exception {
		if (login == null) {
			throw new Exception("Enter a correct login.");
		}
	}

	private void emailValid(String email) throws Exception {
		if (email != null) {
			if (!email.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")) {
				throw new Exception("Enter a correct mail.");
			}
		} else {
			throw new Exception("Enter a valid mail.");
		}
	}

	private void passwordValid(String motDePasse, String confirmation) throws Exception {
		if (motDePasse != null && confirmation != null) {
			if (!motDePasse.equals(confirmation)) {
				throw new Exception("Password are not matching.");
			} else if (motDePasse.length() < 8) {
				throw new Exception("Password length must be superior to 8.");
			}
		} else {
			throw new Exception("Enter password and confirm it.");
		}
	}

	private void nameValid(String name) throws Exception {
		if (name == null) {
			throw new Exception("Enter a valid name.");
		} else if (name.length() < 3){
			throw new Exception("Name must be superior to 3 character.");
		}
	}

	/*
	 * Add error to error Map
	 */
	private void setError(String champ, String message) {
		error.put(champ, message);
	}

	/*
	 * return null if field is empty
	 */
	private String getFieldValue(HttpServletRequest request, String nomChamp) {

		String valeur = request.getParameter(nomChamp);
		if (valeur == null || valeur.trim().length() == 0) {
			return null;
		} else {
			return valeur.trim();
		}
	}
	
	public String getResult() {
		return result;
	}
	
	public Map<String, String> getErrors() {
		return error;
	}
	
	//Clean cache
	private void resetError() {
		this.error = new HashMap<String, String>();
	}
}	