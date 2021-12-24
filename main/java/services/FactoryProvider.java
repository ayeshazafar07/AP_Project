package services;

import businessLogic.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

//SINGLETON!
public class FactoryProvider {
    public static SessionFactory factory;

    public static SessionFactory getFactory() {
        if (factory == null) {
            Configuration config = new Configuration().configure("hibernate.cfg.xml");
            config.addAnnotatedClass(Donor.class);
            config.addAnnotatedClass(ContactInfo.class);
            config.addAnnotatedClass(Address.class);
            config.addAnnotatedClass(Available_Slot.class);
            config.addAnnotatedClass(Item.class);
            config.addAnnotatedClass(Book.class);
            config.addAnnotatedClass(Toy.class);
            config.addAnnotatedClass(Title.class);
            config.addAnnotatedClass(Donation.class);
            config.addAnnotatedClass(Parent.class);
            config.addAnnotatedClass(DonatedMoney.class);
            config.addAnnotatedClass(Payment.class);
            config.addAnnotatedClass(Child.class);
            config.addAnnotatedClass(Parent.class);
            config.addAnnotatedClass(Adoption.class);
            ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
            factory = config.buildSessionFactory(reg);
        }
        return factory;
    }

    public static void closeFactory(){
        if (factory.isOpen()){
            factory.close();
        }
    }
}
