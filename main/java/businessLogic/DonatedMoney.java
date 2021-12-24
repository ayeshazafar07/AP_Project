package businessLogic;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.sql.Date;

@Entity
public class DonatedMoney extends Item{
    private int amount;
    @OneToOne
    private Payment payment;

    public DonatedMoney(Date dateOfEntry, int amount, Payment payment) {
        super(dateOfEntry);
        this.amount = amount;
        this.payment = payment;
    }

    public DonatedMoney() {

    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "DonatedMoney{" +
                "amount=" + amount +
                ", payment=" + payment.toString() +
                '}';
    }
}
