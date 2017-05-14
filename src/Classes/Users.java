package Classes;

public class Users {
	
	private String userName;
	private String password;
	private int permission;
	
	public Users(String user, String pass, int per ){
		this.userName = user;
		this.password=pass;
		this.permission = per;
	}

	public String getUserName() {
		return userName;
	}

	public String getPass() {
		return password;
	}

	public int getPermission() {
		return permission;
	}
	

}
