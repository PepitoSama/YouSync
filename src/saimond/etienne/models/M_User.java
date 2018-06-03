package saimond.etienne.models;

public class M_User {

	private int 	idUser;
	private String 	login;
	private String 	password;
	private String	email;
	private String 	name;
	private String 	lastName;
	private String	birth;
	private int 	connectionNumber;
	private boolean admin;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBirth() {
		return birth;
	}
	
	public String getStringBirth() {
		return birth;
	}

	public void setBirth(String birthDate) {
		this.birth = birthDate;
	}
	
	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public int getIdUser() {
		return idUser;
	}
	
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getConnectionNumber() {
		return connectionNumber;
	}
	
	public void setConnectionNumber(int connectionNumber) {
		this.connectionNumber = connectionNumber;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "User[idUser=" + idUser + ", login=" + login +", name=" + name + 
				", lastName =" + lastName + ", email=" + email + ", connectionNumber=" + connectionNumber + "]";
	}
	
}
