import java.io.Serializable;
import java.util.ArrayList;

public class Administrator implements Serializable
{
	private ArrayList<JobOffer> jobOffersList ;
	private ArrayList<User> uList;
	
	public Administrator()
	{
		uList=new ArrayList<User>();
		jobOffersList = new ArrayList<JobOffer>();
	}
	
	public void addUser(User aUser)
	{
		uList.add(aUser);
	}
	
	public void addJobOffer(JobOffer aJobOffer) {
		jobOffersList.add(aJobOffer);
	}
	
	public ArrayList<Integer> logAttempt(String aUsername, String aPassword)
	{
		ArrayList<Integer>  verification=new ArrayList<Integer>();
		int counter=0;
		verification.add(-1);
		verification.add(-1);
		verification.add(-1);
		for(User user:uList)
		{
			if(user.getUserName().equals(aUsername))
					{
				       verification.set(0,1);
				       if(user.getPassword().equals(aPassword)) {
				       	    verification.set(1,1);
				       		verification.set(2,counter);
				       		break;
				       }
				       else 
				    	   verification.set(1,-1);
				           
					}
			else
				verification.set(1,-1);
			counter++;
		}
		return verification;
	}
	
	
	
	public String makeAppointment(Candidate aCandidate) 
	{
		return aCandidate.getPhoneNumber();
	}
	
	public ArrayList<User> getuList()
	{
		return uList;
		
	}
	public ArrayList<JobOffer> getjobOffersList()
	{
		return jobOffersList;
		
	}
	
	public void deleteAccount(User aUser) {
		uList.remove(aUser);
	}

	
	
}
