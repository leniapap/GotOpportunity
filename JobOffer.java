import java.util.ArrayList;

public class JobOffer {

	private String offerName;
	private ArrayList<Candidate> enrolledCandidates;
	private ArrayList<Candidate> shortList;
	private ArrayList<Integer> rateList;
	private Skills offerSkills;
	
	
	
	public JobOffer(String offerName, ArrayList<Candidate> enrolledCandidates, ArrayList<Candidate> shortList,
			ArrayList<Integer> rateList,Skills offerSkills) {
		
		this.offerName = offerName;
		this.enrolledCandidates = enrolledCandidates;
		this.shortList = shortList;
		this.rateList = rateList;
		this.offerSkills=offerSkills;
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
	
	
	
	
	
	
}
