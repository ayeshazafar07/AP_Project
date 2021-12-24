package services;

import businessLogic.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

public class DbHandler extends Database implements StorageHandler{

    @Override
    public Boolean saveDonor(Donor newDonor) {
        Boolean isAdded = null;
        Session session = FactoryProvider.getFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.save(newDonor.getAddress());
            session.save(newDonor.getContactInfo());
            session.save(newDonor);
            tx.commit();
            isAdded = true;
        } catch (Exception e){
            System.out.println("Phone number is used by another donor");
            isAdded = false;
        }
        session.close();
        return isAdded;
    }

    @Override
    public void updateDonor(Donor newDonor) {

    }

    @Override
    public Donor getDonor(String donorId) {
        Session session = FactoryProvider.getFactory().openSession();
        Transaction tx = session.beginTransaction();
        Donor donor = (Donor)session.get(Donor.class, donorId);
        tx.commit();
        session.close();
        return donor;
    }
    
    @Override
    public Child getChild(String childid) {
        Session session = FactoryProvider.getFactory().openSession();
        Transaction tx = session.beginTransaction();
        Child child = (Child)session.get(Child.class, childid);
        tx.commit();
        session.close();
        return child;
    }

    @Override
    public List<Available_Slot> getAllAvailableSlots() {
        Session session = FactoryProvider.getFactory().openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Available_Slot> cq = cb.createQuery(Available_Slot.class);
        Root<Available_Slot> rootEntry = cq.from(Available_Slot.class);
        CriteriaQuery<Available_Slot> all = cq.select(rootEntry);
        TypedQuery<Available_Slot> allQuery = session.createQuery(all);
        return allQuery.getResultList();
    }
    
    public List<Donation> getAllDonations() {
        Session session = FactoryProvider.getFactory().openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Donation> cq = cb.createQuery(Donation.class);
        Root<Donation> rootEntry = cq.from(Donation.class);
        CriteriaQuery<Donation> all = cq.select(rootEntry);
        TypedQuery<Donation> allQuery = session.createQuery(all);
        return allQuery.getResultList();
    }

    @Override
    public Boolean insertAvailableSlot(Available_Slot slot) {
        Session session = FactoryProvider.getFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(slot);
        tx.commit();
        session.close();
        return true;
    }

    @Override
    public Boolean saveDonation(Donation donation) {
        Boolean isAdded = null;
        Session session = FactoryProvider.getFactory().openSession();
        Transaction tx = session.beginTransaction();
        for (Item item : donation.getItems()) {
                if (item instanceof Book){
                    session.save(((Book) item).getTitle());
                }
                if (item instanceof DonatedMoney){
                    session.save(((DonatedMoney) item).getPayment());
                }
                session.save(item);
        }
        isAdded = false;
        session.save(donation);
        tx.commit();
        session.close();
        return isAdded;
    }

    @Override
    public Boolean saveInterivew(Interview interview) {
        Boolean isAdded = null;
        Session session = FactoryProvider.getFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.save(interview.getParent_to_meet().getAddress());
            session.save(interview.getParent_to_meet().getContactInfo());
            session.save(interview.getParent_to_meet());
            session.save(interview);
            tx.commit();
            isAdded = true;
        } catch (Exception e){
            System.out.println("Phone number is used by another donor");
            isAdded = false;
        }
        session.close();
        return isAdded;
    }

	@Override
    public Parent getParent(String parentid) {
        Session session = FactoryProvider.getFactory().openSession();
        Transaction tx = session.beginTransaction();
        Parent parent = (Parent)session.get(Parent.class, parentid);
        tx.commit();
        session.close();
        return parent;
    }

    @Override
    public Boolean addChild(Child child) {
        Boolean isAdded = null;
        Session session = FactoryProvider.getFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.save(child.getAddress());
            session.save(child);
            isAdded = true;
        } catch (Exception e){
            System.out.println("Phone number is used by another donor");
            isAdded = false;
        }
        tx.commit();
        session.close();
        return isAdded;
    }

    @Override
    public Boolean addParent(Parent parent) {
        Boolean isAdded = null;
        Session session = FactoryProvider.getFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.save(parent.getAddress());
            session.save(parent.getContactInfo());
            session.save(parent);
            isAdded = true;
        } catch (Exception e){
            System.out.println("Phone number is used by another donor");
            isAdded = false;
        }
        tx.commit();
        session.close();
        return isAdded;
    }

    @Override
    public Boolean addAdoption(Adoption a) {
        Boolean isAdded = null;
        Session session = FactoryProvider.getFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(a.getParent().getAddress());
        session.save(a.getParent().getContactInfo());
        session.save(a.getParent());
        for (Child child :
                a.getChild()) {
            session.delete(child);
            session.save(child);
        }
        session.save(a);
        tx.commit();
        session.close();
        return isAdded;
    }


}
