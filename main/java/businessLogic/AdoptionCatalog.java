package businessLogic;

import java.util.List;

import services.DbHandler;

public class AdoptionCatalog {
	
	List<Adoption> adoptionlist;
	
	public Boolean MakeNewAdoption(String pcnic, String ccnic) {
		
		Adoption a=new Adoption();
		Boolean added = a.CreateNewAdoption(pcnic, ccnic);
		DbHandler db = new DbHandler();
		Boolean isAdded = db.addAdoption(a);
		if (isAdded){
			this.adoptionlist.add(a);
		}
		return isAdded;
		
	}

	public String getParent(String CNIC) {
		 
		        DbHandler db = new DbHandler();
		        Parent parent = db.getParent(CNIC);
		        String s = null;
		        if (parent == null) {
		            s=new String("Couldn't get Parent");
		        }
		        else {
		            s=new String(parent.toString());
		        }
				return s;
		    }
	
	
}
