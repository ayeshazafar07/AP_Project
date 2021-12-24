package services;

import businessLogic.*;

import java.util.List;

public class fileHandler extends Database implements StorageHandler {
    @Override
    public Boolean saveDonor(Donor newDonor) {
        return null;
    }

    @Override
    public void updateDonor(Donor newDonor) {

    }

    @Override
    public Donor getDonor(String donorId) {
        return null;
    }

    @Override
    public List<Available_Slot> getAllAvailableSlots() {
        return null;
    }

    @Override
    public Boolean insertAvailableSlot(Available_Slot slot) {
        return null;
    }

    @Override
    public Boolean saveDonation(Donation donation) {
        return null;
    }

    @Override
    public Boolean saveInterivew(Interview interview) {
        return null;
    }

    @Override
    public Child getChild(String childid) {
        return null;
    }

    @Override
    public Parent getParent(String parentid) {
        return null;
    }

    @Override
    public Boolean addChild(Child child) {
        return null;
    }

    @Override
    public Boolean addParent(Parent parent) {
        return null;
    }

    @Override
    public Boolean addAdoption(Adoption a) {
        return null;
    }
}
