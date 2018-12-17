package model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name="getAllShelves", query="SELECT s FROM Shelf s"),
	@NamedQuery(name="findAllShelfsWithProductID", query="SELECT s FROM Shelf s WHERE s.product.id = :productId")
})

public class Shelf extends EntityModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private float capacity;
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Product product=null;
	private float rentPrice;

	
	public Shelf(){};
	
	public Shelf(float capacity,float rentPrice) {
		super();
		this.capacity = capacity;

		this.rentPrice = rentPrice;
	}
	public float getCapacity() {
		return capacity;
	}
	public void setCapacity(float capacity) {
		this.capacity = capacity;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public void removeProduct (){
		this.product = null;
	}
	public float getRentPrice() {
		return rentPrice;
	}
	public void setRentPrice(float rentPrice) {
		this.rentPrice = rentPrice;
	}
	@Override
	public String toString() {
		if(product!=null)
			return "Shelf [capacity=" + capacity + ", product=" + product.getId() + ", rentPrice=" + rentPrice + "]";
		else
			return "Shelf [capacity=" + capacity + ", product=" +" nada"+ ", rentPrice=" + rentPrice + "]";
	}	
}

