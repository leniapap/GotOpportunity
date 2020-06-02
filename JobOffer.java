import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//Klasi JobOffer stin opoia pragmatopoieitai kai i sigkrisi kai taxinomisi ton candidates epi mias job offer
public class JobOffer implements Comparator<Candidate>,Comparable<Candidate>,Serializable{ ////gia na ginei i eggrafi ton dedomenon
    //xrisimopoieitai o comparator kai i comparable gia tin katallili sigkrisi kai taxinomisi ton ipopsifion
	private String offerName;
	private ArrayList<Candidate> enrolledCandidates;
	private ArrayList<Candidate> shortList;
	private ArrayList<Integer> rateList;
	private Skills offerSkills;
	
	
	
	public JobOffer(String offerName,Skills offerSkills) {
		
		this.offerName = offerName;
		this.enrolledCandidates = new ArrayList<Candidate>();
		this.shortList = new ArrayList<Candidate>();
		this.rateList = new ArrayList<Integer>();
		this.offerSkills=offerSkills;
	}
	
	public Candidate compare2Candidates(Candidate cand1,Candidate cand2)
	{
		Candidate bestCandidate;
		int rate1=this.getRating(cand1);
		int rate2=this.getRating(cand2);
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
			bestCandidate=cand2;
		}
		else
		{
			bestCandidate=cand1;

		}
		return bestCandidate;
	}
	public void addToShortlist(Candidate aCandidate)
	{
		shortList.add(aCandidate);
	}
	
	public void addCandidateToJobOffer(Candidate aCandidate)
	{
		
		enrolledCandidates.add(aCandidate);
		updateRateList(aCandidate);
		
	}
	
	public void updateRateList(Candidate aCandidate)
	{
		int rate=0;
	    int counter=0;
		if(offerSkills.getDegreeGrade()<=aCandidate.getDegreeGrade())
		    rate+=aCandidate.getDegreeGrade()-offerSkills.getDegreeGrade();
		if(offerSkills.getEducationLevel()<=aCandidate.getEducationLevel())
			rate+=aCandidate.getEducationLevel()-offerSkills.getEducationLevel();
		if(offerSkills.getWorkExperience()<=aCandidate.getWorkExperience())
			rate+=aCandidate.getWorkExperience()-offerSkills.getWorkExperience();
		for(String language :offerSkills.getProgrammingLanguages())
		{
			for(String languageCandidate: aCandidate.getProgrammingLanguages())
			{
				if (language.equals(languageCandidate)) {
					
					counter++;
				}
			}
			
		}
		if (counter==offerSkills.getProgrammingLanguages().size())
			rate+=2;
		
		counter=0;
		for(String foreignLanguage :offerSkills.getForeignLanguages())
		{
			for(String foreignlanguageCandidate: aCandidate.getForeignLanguages())
			{
				if (foreignLanguage.equals(foreignlanguageCandidate)) {
					
					counter++;
				}
			}
			
		}
		if (counter==offerSkills.getForeignLanguages().size())
			rate+=2;
		counter=0;
		for(String software :offerSkills.getSoftwareKnowledge())
		{
			for(String softwareCandidate: aCandidate.getSoftwareKnowledge())
			{
				if (software.equals(softwareCandidate)) {		
					counter++;
				}
			}
		}
		if (counter==offerSkills.getSoftwareKnowledge().size())
			rate+=2;	
		rateList.add(rate);
	}
	
	public int  getRating(Candidate aCandidate)
	{
		int position=-1;
		for(Candidate candidates: enrolledCandidates) 
		{
			if (aCandidate.equals(candidates))
				position=enrolledCandidates.indexOf(candidates);
		}
		return rateList.get(position);	
	}
	
	public 	void sortCandidates(int criterion)
	{
		if(criterion==0)//age
			Collections.sort(enrolledCandidates,new Sortbyage());
		if(criterion==1)//degree grade
			Collections.sort(enrolledCandidates,new SortbyDegreeGrade());
		if(criterion==2) //educational level
			Collections.sort(enrolledCandidates,new SortbyEducationalLevel());
		if(criterion==3) //work experience
			Collections.sort(enrolledCandidates,new SortbyWorkExperience());
	}
	
	public String getOfferName() {
		return offerName;
	}

	@Override
	public int compare(Candidate cand1, Candidate cand2) {
		return 0;
	}

	@Override
	public int compareTo(Candidate arg0) {
		return 0;
	}

	public ArrayList<Candidate> getEnrolledCandidates() {
		return enrolledCandidates;
	}

	public ArrayList<Candidate> getShortList() {
		return shortList;
	}

	public double  getDegreeGrade() {
		return offerSkills.getDegreeGrade();
	}
	
	public int  getWorkExperience() {
		return offerSkills.getWorkExperience();
	}
	
	public ArrayList<String>  getForeignLanguages() {
		return offerSkills.getForeignLanguages();
	}
	
	public ArrayList<String>  getProgrammingLanguages() {
		return offerSkills.getProgrammingLanguages();
	}

	public ArrayList<String>  getSoftwareKnowledge() {
		return offerSkills.getSoftwareKnowledge();
	}
	public int  getEducationLevel() {
		return offerSkills.getEducationLevel();
	}
}
class Sortbyage implements Comparator<Candidate> 
{ 
    
    public int compare(Candidate cand1,Candidate cand2) 
    { 
    	if(cand1.getAge()>cand2.getAge())
    		return 1;
    	else if(cand1.getAge()==cand2.getAge()) 
    	{
    		if(cand1.getRating()>cand2.getRating())
    			return 1;
    		else if(cand1.getRating()==cand2.getRating())
    			return 0;
    	}
    	return -1;
    } 
} 

class SortbyDegreeGrade implements Comparator<Candidate> 
{ 
   
    public int compare(Candidate cand1, Candidate cand2) 
    { 
    	if(cand1.getDegreeGrade()>cand2.getDegreeGrade())
    		return 1;
    	else if(cand1.getDegreeGrade()==cand2.getDegreeGrade()) 
    	{
    		if(cand1.getRating()>cand2.getRating())
    			return 1;
    		else if(cand1.getRating()==cand2.getRating())
    			return 0;
    	}
    	return -1;
    } 
} 

class SortbyEducationalLevel implements Comparator<Candidate> 
{ 
   
    public int compare(Candidate cand1, Candidate cand2) 
    { 
    	if(cand1.getEducationLevel()>cand2.getEducationLevel())
    		return 1;
    	else if(cand1.getEducationLevel()==cand2.getEducationLevel()) 
    	{
    		if(cand1.getRating()>cand2.getRating())
    			return 1;
    		else if(cand1.getRating()==cand2.getRating())
    			return 0;
    	}
    	return -1;
    	
    } 
} 

class SortbyWorkExperience implements Comparator<Candidate> 
{ 
   
    public int compare(Candidate cand1, Candidate cand2) 
    { 
    	if(cand1.getDegreeGrade()>cand2.getDegreeGrade())
    		return 1;
    	else if(cand1.getDegreeGrade()==cand2.getDegreeGrade()) 
    	{
    		if(cand1.getRating()>cand2.getRating())
    			return 1;
    		else if(cand1.getRating()==cand2.getRating())
    			return 0;
    	}
    	return -1;
    } 
} 
