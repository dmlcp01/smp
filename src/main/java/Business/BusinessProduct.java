package Business;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import dto.ProductDTO;
import model.Product;
import model.Shelf;
import repositories.ProductRepository;
import repositories.ShelfRepository;

public class BusinessProduct {
	@Inject
	ProductRepository productRepository;
	@Inject
	ShelfRepository shelfRepository;
	@Transactional
	public ProductDTO createProduct(Product input) {
		Product temp = productRepository.save(input);
		ProductDTO productDTO = new ProductDTO(temp.getId(), temp.getPrice(), temp.getDiscountValue(), temp.getIva(),
				temp.getPvp());
		return productDTO;
	}

	public ProductDTO getProduct(long id) {
		Product temp = productRepository.findById(id);
		if (temp != null) {
			ProductDTO productDTO = new ProductDTO(temp.getId(), temp.getPrice(), temp.getDiscountValue(),
					temp.getIva(), temp.getPvp());
			return productDTO;
		} else {
			return null;
		}
	}

	@Transactional
	public void deleteProduct(long id) {
		Product temp = productRepository.findById(id);
		if (temp != null) {
			List<Shelf> list =shelfRepository.findByProductId(temp.getId());
			for(Shelf s : list ){
				s.removeProduct();
				
			}
			productRepository.removeById(id);
		}
	}

	@Transactional
	public ProductDTO updateproduct(Product input) {
		Product temp = productRepository.update(input);
		ProductDTO productDTO = new ProductDTO(temp.getId(), temp.getPrice(), temp.getDiscountValue(), temp.getIva(),
				temp.getPvp());
		return productDTO;
	}

	public List<ProductDTO> getAll() {
		List<Product> cp = productRepository.getAll();
		List<ProductDTO> listToBeReturned = new ArrayList<ProductDTO>();
		for (Product p : cp) {
			ProductDTO productDTO = new ProductDTO(p.getId(), p.getPrice(), p.getDiscountValue(), p.getIva(),
					p.getPvp());
			listToBeReturned.add(productDTO);
		}
		return listToBeReturned;
	}
}
