import java.io.Serializable;
import java.util.ArrayList;

//Klasi etairias i opoia klironomei tin klasi user
public class Company extends User implements Serializable{ //gia na ginei i eggrafi ton dedomenon

	private String location;
	private int establishmentYear;
	private ArrayList<JobOffer> companyOffers = new ArrayList<JobOffer>() ;	
	
	public Company(String userName, String fullName, String password, String email, String phone,String location,int establishmentYear) {
		super(userName, fullName, password, email, phone);
		this.location=location;
		this.establishmentYear=establishmentYear;
		this.companyOffers =new ArrayList<JobOffer>();
	}

	@Override
	public String getType() {
		
		return "Company";
	}
	
	public void deleteJobOffer(JobOffer aJobOffer) {
		for(JobOffer jobOffer : companyOffers) {
			if(jobOffer.getOfferName().equals(aJobOffer.getOfferName()))
				companyOffers.remove(aJobOffer);
		}		
	}

	public ArrayList<JobOffer> getCompanyOffers() {
		return companyOffers;
	}

	public void addJobOffer(JobOffer aJob) {
		companyOffers.add(aJob);
	}
	
	
	
}
