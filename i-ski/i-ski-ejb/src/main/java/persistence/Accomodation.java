package persistence;

import java.io.Serializable;
//import java.util.List;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
//import javax.persistence.OneToMany;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: Accommodation
 *
 */
@Entity

public class Accomodation implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAccomodation;
	private String name;
	private float price;
	private int capacity;
	private String description;
	private String accomodationType;

	@ManyToMany(cascade = CascadeType.MERGE)
	private List<SkiTrip> skiTrips;

	@OneToMany(mappedBy = "accomodation")
	private List<Event> evens;
	private static final long serialVersionUID = 1L;

	public Accomodation() {
		super();
	}

	public Accomodation(String name, float price, int capacity, String description) {
		super();
		this.name = name;
		this.price = price;
		this.capacity = capacity;
		this.description = description;
	}

	public int getIdAccomodation() {
		return this.idAccomodation;
	}

	public void setIdAccomodation(int idAccomodation) {
		this.idAccomodation = idAccomodation;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getCapacity() {
		return this.capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAccomodationType() {
		return this.accomodationType;
	}

	public void setAccomodationType(String accomodationType) {
		this.accomodationType = accomodationType;
	}

	public List<Event> getEvens() {
		return evens;
	}

	public void setEvens(List<Event> evens) {
		this.evens = evens;
	}

	public List<SkiTrip> getSkiTrips() {
		return skiTrips;
	}

	public void setSkiTrips(List<SkiTrip> skiTrips) {
		this.skiTrips = skiTrips;
	}

}
