package TestCase;
import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import businessLogic.Available_Slot;
import businessLogic.Orphanage;
import businessLogic.Person;


public class OrphanageTests { 
	
	Orphanage orphanage=new Orphanage();
	
	@org.testng.annotations.Test
	public void AvailableSlotInsertionTest() {
		
				String time="13:00:00";
				Boolean check=orphanage.insertAvailableSlot(Date.valueOf("2021-12-24"), time);
				assertEquals(check,true);
       
			}
	@Test
	public void AvailableSlotGetterTest() {
		
				String time="13:00:00";
				orphanage.insertAvailableSlot(Date.valueOf("2021-12-24"), time);
				List<Available_Slot> slots=orphanage.getAvailableSlots();
				Date d=slots.get(slots.size()-1).getAvailable_slot_date();
				assertEquals(d,Date.valueOf("2021-12-24"));
       
			}
	@Test
	public void NewAdoptionTest() {
				
				Boolean check=orphanage.MakeNewAdoption("2345", "5678");
				assertEquals(check,true);
				
			}
	@Test
	public void ReserveSlotTest() {
				
				Person P=new Person();
				P.setCnic("1024");
				P.setName("John");
				P.setGender("Male");
				P.setNationality("American");
				Boolean check=orphanage.reserveSlot(P,"2021-12-29", "12:00:00");
				assertEquals(check,true);
;				
			}


@Test
	void testslots1() {
		Orphanage orphanage=new Orphanage();
		Assert.assertEquals(true, orphanage.insertAvailableSlot(new Date(5000),"1111"));
	}
	@Test
	void testslots2() {
		Orphanage orphanage=new Orphanage();
		Assert.assertEquals(false, orphanage.insertAvailableSlot(new Date(5000),"1111"));
	}

	
	@Test
	void testadoption1() {
		Orphanage orphanage=new Orphanage();
		Assert.assertEquals(true, orphanage.MakeNewAdoption("33203-5366884-5","32011-1221111-1"));
	}
	@Test
	void testadoption2() {
		Orphanage orphanage=new Orphanage();
		Assert.assertEquals(false, orphanage.MakeNewAdoption("33203-5362244-5","32011-1342111-1"));
	}
		

}