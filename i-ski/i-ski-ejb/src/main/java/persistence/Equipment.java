package persistence;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * Entity implementation class for Entity: Equipment
 *
 */
@Entity

public class Equipment implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEquipment;
	private String name;
	private float price;
	private String description;
	private String image;
	@ManyToOne
	private User user;
	@OneToOne
	private Trade trade;
	private static final long serialVersionUID = 1L;

	public Equipment() {
		super();
	}

	public Equipment(int idEquipment) {
		super();
		this.idEquipment = idEquipment;
	}

	public Equipment(String name, float price, String description, String image, User user) {
		super();
		this.name = name;
		this.price = price;
		this.description = description;
		this.image = image;
		this.user = user;
	}

	public int getIdEquipment() {
		return this.idEquipment;
	}

	public void setIdEquipment(int idEquipment) {
		this.idEquipment = idEquipment;
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

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Trade getTrade() {
		return trade;
	}

	public void setTrade(Trade trade) {
		this.trade = trade;
	}

	public Equipment(String name, float price, String description, String image) {
		super();
		this.name = name;
		this.price = price;
		this.description = description;
		this.image = image;
	}

}
