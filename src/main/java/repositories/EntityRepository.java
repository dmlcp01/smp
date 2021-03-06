package repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.EntityModel;


public abstract class EntityRepository < V extends EntityModel> {
	
	@PersistenceContext
	protected EntityManager em;
	
	public void removeById(long id) {
		V entity = findById(id);
		if(entity != null) {
			em.remove(entity);
		}
	}

	public V update(V  entity) {
		return em.merge(entity);
	}
	
	public V save(V  entity) {
		return em.merge(entity);
	}
	
	
	public V findById(long id) {
		return em.find(getEntityClass(), id);
	}
	
	public List<V> getAll(){
		return em.createNamedQuery(getAllEntityQueryName(), getEntityClass()).getResultList();
	} 
	
	protected  abstract Class<V> getEntityClass();
	
	protected abstract String getAllEntityQueryName();
}


