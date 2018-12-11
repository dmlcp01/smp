package Business;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import dto.ShelfDTO;
import model.Shelf;
import repositories.ShelfRepository;

public class BusinessShelf {
	private static ShelfRepository shelfRepository = ShelfRepository.getInstance();

	public ShelfDTO createShelf(Shelf input) {
		Shelf temp = shelfRepository.save(input);
		ShelfDTO shelfdto = new ShelfDTO(temp.getId(), temp.getCapacity(), temp.getRentPrice());
		return shelfdto;
	}

	public ShelfDTO getShelf(long id) {
		Shelf temp = shelfRepository.findById(id);
		ShelfDTO shelfdto = new ShelfDTO(temp.getId(), temp.getCapacity(), temp.getRentPrice());
		return shelfdto;
	}

	public void deleteShelf(long id) {
		shelfRepository.removeById(id);
	}

	public ShelfDTO updateShelf(Shelf input) {
		Shelf temp = shelfRepository.update(input);
		ShelfDTO shelfdto = new ShelfDTO(temp.getId(), temp.getCapacity(), temp.getRentPrice());
		return shelfdto;
	}

	public Collection<ShelfDTO> getAll() {
		Collection<Shelf> cs =shelfRepository.getAll();
		List<ShelfDTO> listToBeReturned = new ArrayList<ShelfDTO>();
		for(Shelf s : cs){
			ShelfDTO shelfdto = new ShelfDTO(s.getId(), s.getCapacity(), s.getRentPrice());
			listToBeReturned.add(shelfdto);
		}
		return listToBeReturned;
	}

	public Collection<ShelfDTO> getAllShelvesWithProductID(long id) {
		Collection<Shelf> list = shelfRepository.getAll();
		List<ShelfDTO> listToBeReturned = new ArrayList<ShelfDTO>();
		for (Shelf s : list) {
			ShelfDTO shelfdto = new ShelfDTO(s.getId(), s.getCapacity(), s.getRentPrice());
			if (s.getProduct() != null && id == s.getProduct().getId())
				listToBeReturned.add(shelfdto);
		}
		return listToBeReturned;
	}
}
