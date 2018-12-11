package repositories;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import model.Entity;


public class EntityRepository < V extends Entity> {
	private Map<Long, V> map = new HashMap<Long, V>();
	private long actualId = 0;

	public V save(V entity) {
		entity.setId(actualId);
		map.put(entity.getId(), entity);
		actualId++;
		return entity;
	}

	public V findById(Long id) {
		return map.get(id);
	}

	public void removeById(long id) {
		map.remove(id);

	}

	public V update( V entity) {
		map.replace(entity.getId(), entity);
		return entity;
	}

	public Collection<V> getAll() {
		return map.values();
	}

	public Map<Long, V> getMap() {
		return map;
	}
}

