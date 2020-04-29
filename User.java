
public abstract class User {

	private String userName ;
	private String fullName ;
	private String password ;
	private String email ;

	public User(String userName, String fullName, String password, String email) {

		this.userName = userName;
		this.fullName = fullName;
		this.password = password;
		this.email = email;
	}
	
	public abstract String getType();
	
	public boolean isUser(String aUserName) {
		if(userName.equals(aUserName))
			return true ;
		else
			return false ;
	}
}
