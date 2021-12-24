package businessLogic;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "donations_table")
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int primaryKey;
    @OneToMany
    private List<Item> items;
    private Date donationDate;
    private String donorID;

    public Donation(ArrayList<Item> items, Date donationDate, String donorID) {
        this.items = items;
        this.donationDate = donationDate;
        this.donorID = donorID;
    }

    public Donation() {
        this.items = new ArrayList<Item>();
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public Date getDonationDate() {
        return donationDate;
    }

    public void setDonationDate(Date donationDate) {
        this.donationDate = donationDate;
    }

    public String getDonorID() {
        return donorID;
    }

    public void setDonorID(String donorID) {
        this.donorID = donorID;
    }

    @Override
    public String toString() {
        String itemsStr = "";
        for (Item item: items) {
//            itemsStr.concat(item.toString());
            System.out.println(item.toString());
        }
        return "Donation{" +
                "items=" + items +
                ", donationDate=" + donationDate +
                ", donorID=" + donorID +
                '}';
    }

//    Adding donated items(Toys, Books, Money)
    public void addItems(Item item){
        System.out.println(item.toString());
    }

}
