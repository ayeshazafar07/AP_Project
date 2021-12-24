package businessLogic;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "persons_table")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Person {
	@Id
	private String cnic;
    private String name;
    private Date dateOfBirth;
    private String gender;
    private String nationality;
    @OneToOne
	private Address address;

    public Person(String cnic,String name, Date dateOfBirth, String gender, String nationality, Address address) {
        this.cnic = cnic;
		this.setName(name);
        this.setDateOfBirth(dateOfBirth);
        this.setGender(gender);
        this.setNationality(nationality);
        this.setAddress(address);
    }
    public Person(Person p)
    {
    	this.setCnic(p.cnic);
    	this.setName(p.name);
        this.setDateOfBirth(p.dateOfBirth);
        this.setGender(p.gender);
        this.setNationality(p.nationality);
        this.setAddress(p.address);
    }
	public Person() {
		
	}

	public Person(String cnic) {
		this.setCnic(cnic);
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

public Boolean VerifyPerson(String cnic) {
		
		if(cnic.length()==13)
		return true;
		else return false;
		
	}
	public String getCnic() {
		return cnic;
	}
	public void setCnic(String cnic) {
		this.cnic = cnic;
	}
}
