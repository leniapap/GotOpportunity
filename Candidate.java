import java.io.Serializable;
import java.util.ArrayList;


//Klasi ypopsifiou i opoia klironomei thn klasi user 
public class Candidate extends User implements Serializable{//gia na ginei i eggrafi ton dedomenon

	  private int age;
	  private Skills skills;
	  private double rating;
	  private ArrayList<JobOffer> AppliedJobOffers;
	  
	public Candidate(String userName, String fullName, String password, String email,int age,Skills skills,String phoneNumber) {
		super(userName, fullName, password, email,phoneNumber);
		this.age=age;
		this.skills=skills;
		this.rating=0;
		AppliedJobOffers=new ArrayList<JobOffer>();
	}

	@Override
	public String getType()
	{
	    
		return "Candidate";
	}
	
	public double calculateRating()
	{
		rating=skills.getDegreeGrade()+skills.getEducationLevel()+skills.getWorkExperience()+skills.getForeignLanguages().size()+skills.getProgrammingLanguages().size()
			   +skills.getSoftwareKnowledge().size();
		
		return rating;
	}
	
	public void applyJobOffer(JobOffer aOffer) {
		AppliedJobOffers.add(aOffer);
	}
	
	public void updateSkills(Skills newSkills) {
		skills=newSkills;
		this.calculateRating();
	}
	
	public double getDegreeGrade() {
		return skills.getDegreeGrade();
	}
	
	public int getAge() {
		return age;
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
	
	public double getRating() {
		return rating;
	}

	public ArrayList<JobOffer> getAppliedJobOffers() {
		return AppliedJobOffers;
	}

	public Skills getSkills() {
		return skills ;
	}
	
	public void setAppliedJobOffers(ArrayList<JobOffer> appliedJobOffers) {
		AppliedJobOffers = appliedJobOffers;
	}
	
}
