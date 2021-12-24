package businessLogic;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import Exceptions.ChildNotFoundException;
import services.DbHandler;

public class ChildrenCatalogue {
	List<Child> childrenlist;

	public ChildrenCatalogue() {
		this.childrenlist = new ArrayList<>();
	}

	public ChildrenCatalogue(List<Child> childrenlist) {
		this.childrenlist = childrenlist;
	}


	public String getChild(String CNIC) throws ChildNotFoundException {
		
		        DbHandler db = new DbHandler();
		        Child child = db.getChild(CNIC);
		        String s = null;
		if (child == null) {
			s=new String("Couldn't get donor");
		}
		else {
			s=new String(child.toString());
		}

		return s;
		    
	}


	public void addChild(String cnic, String name, Date dateOfBirth, String gender, String nationality, Address address, Date dateOfEntry, String status, String backgroundDetails) {
		DbHandler db = new DbHandler();
		Child newChild = new Child(cnic, name, dateOfBirth, gender, nationality, address, dateOfEntry, status, backgroundDetails);
		Boolean isAdded = db.addChild(newChild);
		if (isAdded){
			this.childrenlist.add(newChild);
			System.out.println("ADDED CCHILD!");
		}
	}
}
