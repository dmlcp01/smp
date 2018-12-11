package dto;

import model.Entity;

public class ShelfDTO extends Entity{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private float capacity;
	private ProductDTO productdto = null;
	private float rentPrice;
	Long id;
	
	public ShelfDTO(){};
	
	public ShelfDTO(Long id, float capacity,float rentPrice) {
		super();
		this.capacity = capacity;
		this.rentPrice = rentPrice;
		this.id = id;
	}
	


	public float getCapacity() {
		return capacity;
	}

	public void setCapacity(float capacity) {
		this.capacity = capacity;
	}

	public ProductDTO getProductdto() {
		return productdto;
	}

	public void setProductdto(ProductDTO productdto) {
		this.productdto = productdto;
	}

	public float getRentPrice() {
		return rentPrice;
	}

	public void setRentPrice(float rentPrice) {
		this.rentPrice = rentPrice;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ShelfDTO [capacity=" + capacity + ", product=" + productdto + ", rentPrice=" + rentPrice + "]";
	}

}
