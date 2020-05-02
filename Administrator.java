import java.util.ArrayList;

public class Administrator 
{

	private ArrayList<User> uList;
	
	public Administrator()
	{
		uList=new ArrayList<User>();
	}
	
	public void addUser(User aUser)
	{
		uList.add(aUser);
	}
	
	public ArrayList<Boolean> logAttempt(String aUsername, String aPassword)
	{
		 ArrayList<Boolean>  verification=new ArrayList<Boolean>();
		for(User user:uList)
		{
			if(user.getUserName().equals(aUsername))
					{
				       verification.add(true);
				       if(user.getPassword().equals(aPassword))
				       	   verification.add(true);
				       
				       else 
				    	   verification.add(false);
				       		         
					}
			else
				verification.add(false);
			
		}
		return verification;
	}
	
	public Candidate compare2Candidates(Candidate cand1,Candidate cand2,JobOffer currentJob)
	{
		Candidate bestCandidate;
		int rate1=currentJob.getRating(cand1);
		int rate2=currentJob.getRating(cand2);
		int bestRate=Integer.compare(rate1,rate2);
		if(bestRate==0)
		{
			if(cand1.calculateRating()>cand2.calculateRating()) {
				bestCandidate=cand1;
			}
			else
				bestCandidate=cand2;
		}
		else if(bestRate>0) {
			bestCandidate=cand1;
		}
		else
		{
			bestCandidate=cand2;
	
		}
		return bestCandidate;
	}
	
	public String makeAppointment(Candidate aCandidate) 
	{
		return aCandidate.getPhoneNumber();
	}

	
}
