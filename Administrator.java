import java.io.Serializable;
import java.util.ArrayList;

//Klassi diaxeirisis xriston kai job offers. Edo ginetai i epivevaiosi ton eisodon logariasmon kai i diagrafi logariasmon

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
	
	//verification eisodou xristi mesa sto system
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
	
	//se periptosi diagrafis logariasmou, diagrafoume kai ola tou ta dedomena
	//diladi tin iparxi tou sto sinolo ton xriston, tin iparxi tou apo ta applied job offers kai ta shortlist-ratelist tous
	public void deleteAccount(User aUser) {
		uList.remove(aUser);
		for(JobOffer offer : jobOffersList)
		{
			if(offer.getEnrolledCandidates().contains(aUser)) 
			{
			    offer.getRateList().remove(offer.getEnrolledCandidates().indexOf(aUser));
				offer.getEnrolledCandidates().remove(aUser);
			}
				if(offer.getShortList().contains(aUser)) 
				{
					offer.getShortRateList().remove(offer.getShortList().indexOf(aUser));
					offer.getShortList().remove(aUser);
						
				}
	    }
					
				
		}
	}

	
	

