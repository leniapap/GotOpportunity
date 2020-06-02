import java.io.Serializable;

//yperklasi user tin opoia klironomoun oi klaseis candidate kai company
public abstract class User implements Serializable{//gia na ginei i eggrafi ton dedomenon

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
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getFullName() {
		return fullName;
	}

	
	
}
