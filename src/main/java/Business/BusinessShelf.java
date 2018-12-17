package Business;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import dto.ProductDTO;
import dto.ShelfDTO;
import model.Product;
import model.Shelf;
import repositories.ShelfRepository;

public class BusinessShelf {
	@Inject
	ShelfRepository shelfRepository;

	@Transactional
	public ShelfDTO createShelf(Shelf input) {
		Shelf temp = shelfRepository.save(input);
		Product prod = temp.getProduct();
		if (prod != null) {
		ProductDTO pd = new ProductDTO(prod.getId(), prod.getPrice(), prod.getDiscountValue(), prod.getIva(),
				prod.getPvp());
		ShelfDTO shelfdto = new ShelfDTO(temp.getId(), temp.getCapacity(), temp.getRentPrice(), pd);
		return shelfdto;
	}else {
		ShelfDTO shelfdto = new ShelfDTO(temp.getId(), temp.getCapacity(), temp.getRentPrice(), null);
		return shelfdto;
		}
	}

	public ShelfDTO getShelf(long id) {
		Shelf temp = shelfRepository.findById(id);
		Product prod = temp.getProduct();
		if (prod != null) {
		ProductDTO pd = new ProductDTO(prod.getId(), prod.getPrice(), prod.getDiscountValue(), prod.getIva(),
				prod.getPvp());
		ShelfDTO shelfdto = new ShelfDTO(temp.getId(), temp.getCapacity(), temp.getRentPrice(), pd);
		return shelfdto;
		}else {
			ShelfDTO shelfdto = new ShelfDTO(temp.getId(), temp.getCapacity(), temp.getRentPrice(), null);
			return shelfdto;
			}
	}

	@Transactional
	public void deleteShelf(long id) {
		Shelf temp = shelfRepository.findById(id);
		if (temp != null) {
			shelfRepository.removeById(id);
		}
	}

	@Transactional
	public ShelfDTO updateShelf(Shelf input) {
		Shelf temp = shelfRepository.update(input);
		Product prod = temp.getProduct();
		if (prod != null) {
			ProductDTO pd = new ProductDTO(prod.getId(), prod.getPrice(), prod.getDiscountValue(), prod.getIva(),
				prod.getPvp());
		ShelfDTO shelfdto = new ShelfDTO(temp.getId(), temp.getCapacity(), temp.getRentPrice(), pd);
		return shelfdto;
		}else {
			ShelfDTO shelfdto = new ShelfDTO(temp.getId(), temp.getCapacity(), temp.getRentPrice(), null);
			return shelfdto;
			}
		}

	public List<ShelfDTO> getAll() {
		List<Shelf> cs = shelfRepository.getAll();
		List<ShelfDTO> listToBeReturned = new ArrayList<ShelfDTO>();
		for (Shelf s : cs) {
			Product prod = s.getProduct();
			if (prod != null) {
				ProductDTO pd = new ProductDTO(prod.getId(), prod.getPrice(), prod.getDiscountValue(), prod.getIva(),
						prod.getPvp());
				ShelfDTO shelfdto = new ShelfDTO(s.getId(), s.getCapacity(), s.getRentPrice(), pd);
				listToBeReturned.add(shelfdto);
			}else {
				ShelfDTO shelfdto = new ShelfDTO(s.getId(), s.getCapacity(), s.getRentPrice(), null);
				listToBeReturned.add(shelfdto);
				}
		}
		return listToBeReturned;
	}

	public List<Shelf> getAllShelvesWithProductID(long id) {
		List<Shelf> list = shelfRepository.getAll();
		for (Shelf s : list) {
			if (s.getProduct() != null)
				return shelfRepository.findByProductId(id);
		}
		return null;
	}
}
