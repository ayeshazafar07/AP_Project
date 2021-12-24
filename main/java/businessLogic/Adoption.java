package businessLogic;

import services.DbHandler;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Adoption {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int primaryKey;

	@OneToMany
	private List<Child> child;

	@OneToOne
	private Parent parent;
	private LocalDate Adoption_date;
	public Adoption() {
		this.child = new ArrayList<Child>();
	}
	public Boolean CreateNewAdoption(String pcnic, String ccnic) {
		DbHandler db = new DbHandler();
		Parent dbParent = db.getParent(pcnic);
		if (dbParent == null){
			this.parent = new Parent(pcnic);
		}
		Child dbChild = db.getChild(ccnic);
		this.child.add(dbChild);
		return true;
	}
	public List<Child> getChild() {
		return child;
	}
	public void setChild(List<Child> child) {
		this.child = child;
	}
	public Parent getParent() {
		return parent;
	}
	public void setParent(Parent parent) {
		this.parent = parent;
	}
	public LocalDate getAdoption_date() {
		return Adoption_date;
	}
	public void setAdoption_date(LocalDate adoption_date) {
		Adoption_date = adoption_date;
	}
	public void addchild(List<Child> c)
	{
		for(int i=0;i<c.size();i++)
		{
			child.add(c.get(i));
		}
	}

}
