
public abstract class User {

	private String userName ;
	private String fullName ;
	private String password ;
	private String email ;
	private String phone;

	public User(String userName, String fullName, String password, String email,String phone) {

		this.userName = userName;
		this.fullName = fullName;
		this.password = password;
		this.email = email;
		this.phone=phone;
	}
	
	public abstract String getType();
	
	public boolean isUser(String aUserName) {
		if(userName.equals(aUserName))
			return true ;
		else
			return false ;
	}

	public String getUserName() {
		return userName;
	}

	
	public String getPassword() {
		return password;
	}

    public String getPhoneNumber()
    {
    	return phone;
    }
	
	
}
