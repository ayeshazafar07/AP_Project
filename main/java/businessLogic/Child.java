package businessLogic;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "child_table")
public class Child extends Person{
    private Date dateOfEntry;
	private String status;
	private String backgroundDetails;

	public Child(String cnic) {
		super(cnic);
	}

	public Child(String cnic, String name, Date dateOfBirth, String gender, String nationality, Address address, Date dateOfEntry, String status, String backgroundDetails) {
        super(cnic,name, dateOfBirth, gender, nationality, address);
        this.setDateOfEntry(dateOfEntry);
        this.setStatus(status);
        this.setBackgroundDetails(backgroundDetails);
    }

	public Child() {

	}

	public String getBackgroundDetails() {
		return backgroundDetails;
	}

	public void setBackgroundDetails(String backgroundDetails) {
		this.backgroundDetails = backgroundDetails;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDateOfEntry() {
		return dateOfEntry;
	}

	public void setDateOfEntry(Date dateOfEntry) {
		this.dateOfEntry = dateOfEntry;
	}
}
