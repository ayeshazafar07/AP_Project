package businessLogic;

import services.DbHandler;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class DonationCatalog {
    private ArrayList<Donation> donations;

    public DonationCatalog() {
        this.donations = new ArrayList<Donation>();
    }

    public DonationCatalog(ArrayList<Donation> donations) {
        this.donations = donations;
    }

    public ArrayList<Donation> getDonations() {
        return donations;
    }

    public void setDonations(ArrayList<Donation> donations) {
        this.donations = donations;
    }

    @Override
    public String toString() {
        String donationStr = "";
        for (Donation donation :
                donations) {
            donationStr.concat(donation.toString() + " ");
            System.out.println(donation.toString());
        }
        return donationStr;
    }

//    TODO: Creating donation -> add in List and in DB
    public Boolean addDonation(ArrayList<Item> items, String donorID){
        java.util.Date utilDate = new java.util.Date();
        Date currentDate = new Date(utilDate.getTime());
        Donation newDonation = new Donation(items, currentDate, donorID);
        DbHandler db = new DbHandler();
        Boolean isSaved = db.saveDonation(newDonation);
        if (isSaved){
            return true;
        }
        else {
            return false;
        }

    }

	public List<Donation> getDonationHistory() {
		DbHandler db = new DbHandler();
		List<Donation> d=db.getAllDonations();
		return d;
	}




}
