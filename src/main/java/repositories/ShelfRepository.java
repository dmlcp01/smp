package repositories;

import java.util.List;

import javax.persistence.TypedQuery;

import model.Shelf;

public class ShelfRepository extends EntityRepository <Shelf>{
	private static final ShelfRepository INSTANCE=new ShelfRepository();

	private ShelfRepository() {
	}

	public static ShelfRepository getInstance() {
		return INSTANCE;
	}
	
	public List<Shelf> findByProductId(Long id){
		TypedQuery<Shelf> query = em.createNamedQuery("findAllShelfsWithProductID", Shelf.class);
		query.setParameter("productId", id);
		return query.getResultList();
	}

	@Override
	protected Class<Shelf> getEntityClass() {
		return Shelf.class;
	}

	@Override
	protected String getAllEntityQueryName() {
		return "getAllShelves";
	}
	
	
}
