package businessLogic;

import java.util.Date;
import javax.persistence.*;


@Entity
@Table(name = "donor_table")
public class Donor  extends Person{
	@OneToOne
    private ContactInfo contactInfo;

	public Donor(String cnic,String name, Date dateOfBirth, String gender, String nationality, Address address, ContactInfo contactInfo) {
        super(cnic,name, dateOfBirth, gender, nationality, address);
        this.setContactInfo(contactInfo);
    }

	public Donor() {
		super();
	}

	public ContactInfo getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(ContactInfo contactInfo) {
		this.contactInfo = contactInfo;
	}

	@Override
	public String toString() {
		return this.getCnic() + "   " + this.getName() + "\n" + contactInfo.toString();
	}

}
