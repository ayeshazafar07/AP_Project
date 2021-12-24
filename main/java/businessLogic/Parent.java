package businessLogic;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "parent_table")
public class Parent extends Person {
	@OneToOne
    private ContactInfo contactInfo;

    public Parent(String cnic,String name, Date dateOfBirth, String gender, String nationality, Address address, int parentId, ContactInfo contactInfo) {
        super(cnic,name, dateOfBirth, gender, nationality, address);
        this.setContactInfo(contactInfo);
    }

	public Parent() {
		// TODO Auto-generated constructor stub
	}
	public Parent(Parent p)
	{
		
	}
	public 	Parent(Person p) {
		super(p);
	}

	public Parent(String pcnic) {
		super(pcnic);
		this.contactInfo = new ContactInfo("03333066490", "email.com");
		Address address = new Address("Pakistan", "Lahore", 9, 10);
		this.setAddress(address);
	}

    public ContactInfo getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(ContactInfo contactInfo) {
		this.contactInfo = contactInfo;
	}
}
