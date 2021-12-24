package services;

import businessLogic.*;

import java.util.List;

public interface StorageHandler {
    Boolean saveDonor(Donor newDonor);
    void updateDonor(Donor newDonor);
    Donor getDonor(String donorId);
    List<Available_Slot> getAllAvailableSlots();
    Boolean insertAvailableSlot(Available_Slot slot);
    Boolean saveDonation(Donation donation);
    Boolean saveInterivew(Interview interview);
	Child getChild(String childid);
	Parent getParent(String parentid);
    Boolean addChild(Child child);
    Boolean addParent(Parent parent);
    Boolean addAdoption(Adoption a);
}
