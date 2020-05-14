package hu.am.logging.entity;

public class User {
	
	public String username;
	public String password;
	
	public boolean loggedIn = false;
	
	public User (String username, String password) {
		this.username=username;
		this.password=password;
	}

}
