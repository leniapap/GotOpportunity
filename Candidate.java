import java.util.ArrayList;

public class Candidate extends User {

	  private int age;
	  private Skills skills;
	  private double rating;
	  private ArrayList<JobOffer> AppliedJobOffers;
	  
	public Candidate(String userName, String fullName, String password, String email,int age,Skills skills, double rating,ArrayList<JobOffer> AppliedJobOffers,String phoneNumber) {
		super(userName, fullName, password, email,phoneNumber);
		this.age=age;
		this.skills=skills;
		this.rating=rating;
		AppliedJobOffers=new ArrayList<JobOffer>();
	}

	@Override
	public String getType()
	{
	    
		return "Candidate";
	}
	
	public void updateProfile(String age) 
	{
		
	}
	
	public double calculateRating()
	{
		rating=skills.getDegreeGrade()+skills.getEducationLevel()+skills.getWorkExperience()+skills.getForeignLanguages().size()+skills.getProgrammingLanguages().size()
			   +skills.getSoftwareKnowledge().size();
		
		return rating;
	}
	
	public double getDegreeGrade() {
		return skills.getDegreeGrade();
	}
	
	public int getEducationLevel() {
		return skills.getEducationLevel();
	}
	public ArrayList<String> getProgrammingLanguages() {
		return skills.getProgrammingLanguages();
	}
	public int getWorkExperience() {
		return skills.getWorkExperience();
	}
	public ArrayList<String> getForeignLanguages() {
		return skills.getForeignLanguages();
	}
	public ArrayList<String> getSoftwareKnowledge() {
		return skills.getSoftwareKnowledge();
	}
	


	
	
	

	
}
