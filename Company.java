import java.io.Serializable;
import java.util.ArrayList;

public class Company extends User implements Serializable{

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
