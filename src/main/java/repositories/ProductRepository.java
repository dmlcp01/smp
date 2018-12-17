package repositories;

import model.Product;

public class ProductRepository extends EntityRepository<Product> {
	private static final ProductRepository INSTANCE=new ProductRepository();

	private ProductRepository() {
	}

	public static ProductRepository getInstance() {
		return INSTANCE;
	}

	@Override
	protected Class<Product> getEntityClass() {
		return Product.class;
	}

	@Override
	protected String getAllEntityQueryName() {

		return "getAllProducts";
	}

}
