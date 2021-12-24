package businessLogic;

import org.hibernate.Session;
import services.DbHandler;
import services.FactoryProvider;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
//        System.out.println("Hello world");
//
//        System.out.println("YO?");
        Orphanage orphanage = new Orphanage();
        orphanage.addChildHandler("1234", "jj", Date.valueOf("2000-10-1"), "Male", "Pakistani", Date.valueOf("2000-10-1"), "not adopted", "bg");
//        Date dateOfEntry = Date.valueOf("1999-10-21");
//        Payment payment = new Payment(200, "cheque");
//        DonatedMoney money = new DonatedMoney(4, dateOfEntry, 200, payment);
//        ArrayList<Item> items = new ArrayList<Item>();
//        items.add(money);
//        orphanage.addDonation(items, 2);
//        Toy toy = new Toy(1, dateOfEntry, "Spider-man", "Action figure");
//        java.util.Date utilDate = new java.util.Date();
//        Date currentDate = new Date(utilDate.getTime());
//        Title title = new Title("Tuesdays with Morrie", "summary", "Mitch Ablom");
//        Book book = new Book(3, currentDate, title, "penguin");
//        items.add(book);
//        orphanage.viewDonorHandler("200");
//        String info = "some Donor";
//        String name = "Hussain";
//        Date dateOfBirth = Date.valueOf("1999-10-21");
//        String gender = "male";
//        Address address = new Address("Pakistan", "karachi", 1, 2);
//        ContactInfo contactInfo = new ContactInfo("56", "mshk9991@gmail.com");
//        String CNIC = "444";
//        String nationality = "Pakistani";
//        orphanage.registerDonorHandler(CNIC, name, dateOfBirth, gender, nationality, address, contactInfo);
//        Date dateOfEntry = Date.valueOf("2001-5-21");
//        Time timeOfMeet = Time.valueOf("05:32:00");
//        Available_Slot slot = new Available_Slot(dateOfEntry, timeOfMeet);
//        DbHandler db = new DbHandler();
//        List<Available_Slot> slots = db.getAllAvailableSlots();
//        for (Available_Slot slot :
//                slots) {
//            System.out.println(slot.toString());
//        }
////        db.insertAvailableSlot(slot);
//        Session session = FactoryProvider.getFactory().openSession();
//        CriteriaBuilder cb = session.getCriteriaBuilder();
//        CriteriaQuery<Donation> cq = cb.createQuery(Donation.class);
//        Root<Donation> rootEntry = cq.from(Donation.class);
//        CriteriaQuery<Donation> all = cq.select(rootEntry);
//        TypedQuery<Donation> allQuery = session.createQuery(all);
//        List<Donation> test = allQuery.getResultList();
//
//        for (Donation donation :
//                test) {
//            System.out.println(donation.toString());
//        }

    }
}
