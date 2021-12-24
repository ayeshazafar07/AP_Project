package businessLogic;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "available_slots_table")
public class Available_Slot {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int primaryKey;
	private Date available_slot_date;
	private Time available_slot_time;

	public Available_Slot() {

	}

	public Available_Slot(Date available_slot_date, Time available_slot_time) {
		this.available_slot_date = available_slot_date;
		this.available_slot_time = available_slot_time;
	}


	public Date getAvailable_slot_date() {
		return available_slot_date;
	}
	public void setAvailable_slot_date(Date available_slot_date) {
		this.available_slot_date = available_slot_date;
	}
	public Time getAvailable_slot_time() {
		return available_slot_time;
	}
	public void setAvailable_slot_time(Time available_slot_time) {
		this.available_slot_time = available_slot_time;
	}

	@Override
	public String toString() {
		return available_slot_date.toString() + "          " + available_slot_time.toString() + "\n";
	}
}
