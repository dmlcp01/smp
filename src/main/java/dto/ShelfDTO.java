package dto;

import model.EntityModel;

public class ShelfDTO extends EntityModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private float capacity;
	private ProductDTO productdto = null;
	private float rentPrice;
	
	
	public ShelfDTO(){};
	
	public ShelfDTO(Long id, float capacity,float rentPrice,ProductDTO productdto) {
		super();
		this.capacity = capacity;
		this.rentPrice = rentPrice;
		setId(id);
		this.productdto=productdto;
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
