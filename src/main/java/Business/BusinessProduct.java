package Business;

import dto.ProductDTO;
import model.Product;
import repositories.ProductRepository;

public class BusinessProduct {
	private static ProductRepository productRepository = ProductRepository.getInstance();
	
	public ProductDTO createProduct (Product input){
		Product temp = productRepository.save(input);
		ProductDTO productDTO = new ProductDTO(temp.getId(), temp.getPrice(),temp.getDiscountValue(), temp.getIva(), temp.getPvp());
		 return productDTO;
	}
	
	public ProductDTO getProduct (long id){
		Product temp = productRepository.findById(id);
		ProductDTO productDTO = new ProductDTO(temp.getId(), temp.getPrice(),temp.getDiscountValue(), temp.getIva(), temp.getPvp());
		 return productDTO;
	}
	
	public void deleteProduct (long id){
		productRepository.removeById(id);
	}
	public ProductDTO updateproduct (Product input){
		Product temp = productRepository.update(input);
		ProductDTO productDTO = new ProductDTO(temp.getId(), temp.getPrice(),temp.getDiscountValue(), temp.getIva(), temp.getPvp());
		return productDTO;
	}
}


