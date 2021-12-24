package businessLogic;

import Exceptions.ChildNotFoundException;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Orphanage {
    private Address address;
    private ContactInfo contact_info;
    private DonationCatalog donation_catalog;
    private AdoptionCatalog adoption_catalog;
    private ChildrenCatalogue children_catalogue;
    private DonorCatalog donorCatalog;
    private InterviewSchedule interviewSchedule=new InterviewSchedule();

	public Orphanage() {
		this.donorCatalog = new DonorCatalog();
		this.donation_catalog = new DonationCatalog();
		this.interviewSchedule = new InterviewSchedule();
		this.adoption_catalog = new AdoptionCatalog();
		this.children_catalogue = new ChildrenCatalogue();
	}
	
	public   List<Available_Slot> getAvailableSlots() {
		
		 
		return interviewSchedule.getAvailableSlots();
		
	}
	
	public   List<Donation> getDonationHistory() {
		
		 
		return donation_catalog.getDonationHistory();
		
	}
	
	public Boolean insertAvailableSlot(Date d,String t)
	{
		return interviewSchedule.insertAvailableSlot(d,t);
		
	}
	
	public DonorCatalog getDonorCatalog1() {
		return donorCatalog;
	}

	public void setDonorCatalog1(DonorCatalog donorCatalog) {
		this.donorCatalog = donorCatalog;
	}

    public DonationCatalog viewalldonors()
    {
    	
    	donorCatalog.getAllDonors();
		return donation_catalog;
 
    }
    
    
    public Boolean MakeNewAdoption(String pcnic, String ccnic)
    {
    	return adoption_catalog.MakeNewAdoption(pcnic,ccnic);
    }
    
    public Address getAddress() {
		return address;
	}
	
	public boolean reserveSlot(Person person,String date, String time)
	{
		
		return interviewSchedule.reserveSlot(person,date,time);
		
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public ContactInfo getContact_info() {
		return contact_info;
	}
	public void setContact_info(ContactInfo contact_info) {
		this.contact_info = contact_info;
	}
	public DonationCatalog getDonation_catalog() {
		return donation_catalog;
	}
	public void setDonation_catalog(DonationCatalog donation_catalog) {
		this.donation_catalog = donation_catalog;
	}
	public AdoptionCatalog getAdoption_catalog() {
		return adoption_catalog;
	}
	public void setAdoption_catalog(AdoptionCatalog adoption_catalog) {
		this.adoption_catalog = adoption_catalog;
	}
	
	public InterviewSchedule getInterviewSchedule() {
		return interviewSchedule;
	}
	public void setInterviewSchedule(InterviewSchedule interviewSchedule) {
		this.interviewSchedule = interviewSchedule;
	}
	public Boolean Login(String text, String text2) {
		if(text.equals("OMS@OMS.com")&&text2.equals("nfhoms"))
			return true;
			else return false;
	}
	public static Boolean VerifyPerson(String cnic) {
		Person person=new Person();
		return person.VerifyPerson(cnic);
		
	}

	public ChildrenCatalogue getChildren_catalogue() {
		return children_catalogue;
	}

	public void setChildren_catalogue(ChildrenCatalogue children_catalogue) {
		this.children_catalogue = children_catalogue;
	}
	public DonorCatalog getDonorCatalog() {
		return donorCatalog;
	}
	public void setDonorCatalog(DonorCatalog donorCatalog) {
		this.donorCatalog = donorCatalog;
	}
	
	
	public String  viewDonorHandler(String CNIC){
		return this.donorCatalog.getDonor(CNIC);
	}
	
	public String  viewChildHandler(String CNIC) throws ChildNotFoundException {

		return this.children_catalogue.getChild(CNIC);
	}
	
	public String  viewParent(String CNIC){
		return this.adoption_catalog.getParent(CNIC);
	}

	public void registerDonorHandler(String cnic,String name, Date dateOfBirth, String gender, String nationality, Address address, ContactInfo contactInfo) {
		this.donorCatalog.createDonor(cnic,name, address, dateOfBirth, gender, nationality, contactInfo);
	}

	public void addChildHandler(String cnic,String name, Date dateOfBirth, String gender, String nationality, Date dateOfEntry, String status, String backgroundDetails){
		Address address = new Address("Pakistan", "Karachi", 1, 2);
		this.children_catalogue.addChild(cnic, name, dateOfBirth, gender, nationality, address, dateOfEntry, status, backgroundDetails);
	}



	public void addDonation(ArrayList<Item> items, String donorID){
		System.out.println("FDF");
		this.donation_catalog.addDonation(items, donorID);
	}




}
