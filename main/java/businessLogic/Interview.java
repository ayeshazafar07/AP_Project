package businessLogic;

import services.DbHandler;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Interview {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int primaryKey;
	private LocalDate interview_date;
	@OneToOne
	private Parent Parent_to_meet;
	private String time_to_meet;

	public LocalDate getInterview_date() {
		return interview_date;
	}

	public void setInterview_date(LocalDate interview_date) {
		this.interview_date = interview_date;
	}

	public Parent getParent_to_meet() {
		return Parent_to_meet;
	}


	public void setParent_to_meet(Parent parent_to_meet) {
		Parent_to_meet = parent_to_meet;
	}

	public boolean MakeNewAppointment(Person p, LocalDate d,String t) {
		
		Parent_to_meet= new Parent(p);
		interview_date=d;
		setTime_to_meet(t);
		
		// make new parent in db
		// make new interview in db
		// after succesful insertion return true
		//else return false;
		return true;
	}

	public String getTime_to_meet() {
		return time_to_meet;
	}

	public void setTime_to_meet(String time_to_meet) {
		this.time_to_meet = time_to_meet;
	}
}
