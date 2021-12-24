package businessLogic;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Date;

@Entity
public class Toy extends Item {
    private String name;
    private String category;

	public Toy(Date dateOfEntry, String name, String category) {
		super( dateOfEntry);
		this.name = name;
		this.category = category;
	}

	public Toy() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Toy{" +
				"name='" + name + '\'' +
				", category='" + category + '\'' +
				'}';
	}
}
