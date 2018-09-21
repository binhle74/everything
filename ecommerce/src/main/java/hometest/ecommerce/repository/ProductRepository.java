package hometest.ecommerce.repository;

import java.util.List;

import hometest.ecommerce.model.Product;

/**
 * The Interface IProductRepository.
 */
public interface ProductRepository {
	
	/**
	 * Adds the product.
	 *
	 * @param product the product
	 * @param quantity the quantity
	 */
	public void addProduct(Product product);
	
	/**
	 * Find by name.
	 *
	 * @param productName the product name
	 * @param quantity the quantity
	 */
//	public Optional<Product> findByName(String productName, long quantity);
	
	/**
	 * Fetch all.
	 *
	 * @return the list
	 */
	public List<Product> fetchAll();
	
}
