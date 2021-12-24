package businessLogic;

import java.util.Date;

public class Manager extends Person {
	
    private ContactInfo contactInfo;
    public Manager(String cnic,String name, Date dateOfBirth, String gender, String nationality, Address address, ContactInfo contactInfo) {
        super(cnic,name, dateOfBirth, gender, nationality, address);
        this.setContactInfo(contactInfo);
    }


	public ContactInfo getContactInfo() {
		return contactInfo;
	}


	public void setContactInfo(ContactInfo contactInfo) {
		this.contactInfo = contactInfo;
	}
}
