import java.util.ArrayList;

public class Company extends User {

	private String location;
	private int establishmentYear;
	private int phoneNumber;
	private ArrayList<JobOffer> companyOffers = new ArrayList<JobOffer>() ;
	
	
	public Company(String userName, String fullName, String password, String email, String phone,String location,int establishmentYear,int phoneNumber) {
		super(userName, fullName, password, email, phone);
		this.location=location;
		this.establishmentYear=establishmentYear;
		this.phoneNumber=phoneNumber;
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
	
	
	
}
