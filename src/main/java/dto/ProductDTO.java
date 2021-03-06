package dto;

import model.EntityModel;

public class ProductDTO extends EntityModel{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private float price;
		private float discountValue;
		private float iva;
		private float pvp;

		
		public ProductDTO(){};
		
		public ProductDTO(Long id,float price, float discountValue, float iva, float pvp) {
			super();
			this.price = price;
			this.discountValue = discountValue;
			this.iva = iva;
			this.pvp = pvp;
			setId(id);
		}

		public float getPrice() {
			return price;
		}

		public void setPrice(float price) {
			this.price = price;
		}

		public float getDiscountValue() {
			return discountValue;
		}

		public void setDiscountValue(float discountValue) {
			this.discountValue = discountValue;
		}

		public float getIva() {
			return iva;
		}

		public void setIva(float iva) {
			this.iva = iva;
		}

		public float getPvp() {
			return pvp;
		}

		public void setPvp(float pvp) {
			this.pvp = pvp;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}
		@Override
		public String toString() {
			return "ProductDTO [price=" + price + ", discountValue=" + discountValue + ", iva=" + iva + ", pvp=" + pvp
					+ "]";
		}

}
