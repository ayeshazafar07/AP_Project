package businessLogic;

//import services.DbHandler;

import services.DbHandler;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class DonorCatalog {
    private ArrayList<Donor> donors;
    
    
    
	public ArrayList<Donor> getAllDonors() {
		
		
		//get all donors info name and id
		//from db and store in donorslist
		return donors;
	}
	
    
    
    public ArrayList<Donor> getDonors() {
        return donors;
    }

    public DonorCatalog() {
        this.donors = new ArrayList<Donor>();
    }

    public DonorCatalog(ArrayList<Donor> donors) {
        this.donors = donors;
    }

    public void setDonors(ArrayList<Donor> donors) {
        this.donors = donors;
    }

//    TODO: Make View Donor Functionality
    public String getDonor(String CNIC){
        DbHandler db = new DbHandler();
        Donor donor = db.getDonor(CNIC);
        String s = null;
        if (donor == null) {
            s=new String("Couldn't get donor");
        }
        else {
            s=new String(donor.toString());
        }
		return s;
    }

    //TODO: Make Register Donor Functionality
    public void createDonor(String cnic,String name, Address address, Date dateOfBirth, String gender, String nationality, ContactInfo contactInfo){
        Donor newDonor = new Donor(cnic,name, dateOfBirth, gender, nationality, address, contactInfo);
        DbHandler db = new DbHandler();
        Donor isDonor = db.getDonor(cnic);
        if (isDonor == null) {
            Boolean isAdded = db.saveDonor(newDonor);
            if (isAdded){
                this.donors.add(newDonor);
                System.out.println("New Donor Added!");
            }
            else {
                System.out.println("Donor couldn't be Added!");
            }
        }
        else {
            System.out.println("Donor is already there!");
        }
    }


}
