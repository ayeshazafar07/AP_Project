package businessLogic;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "books_table")
public class Book extends Item{
	@ManyToOne
//	@JoinColumn(name="primaryKey", nullable=false)
    private Title title;
    private String publisher;

	public Book() {

	}

	public Title getTitle() {
		return title;
	}
	public void setTitle(Title title) {
		this.title = title;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Book(Date dateOfEntry, Title title, String publisher) {
		super( dateOfEntry);
		this.title = title;
		this.publisher = publisher;
	}

	@Override
	public String toString() {
		return "Book{" +
				"title=" + title.toString() +
				", publisher='" + publisher + '\'' +
				'}';
	}
}
