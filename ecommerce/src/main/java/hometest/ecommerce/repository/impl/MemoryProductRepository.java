package hometest.ecommerce.repository.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import hometest.ecommerce.model.Product;
import hometest.ecommerce.repository.ProductRepository;

/**
 * The Class ProductRepository.
 */
public class MemoryProductRepository implements ProductRepository {

	/** The products. */
	private Map<String, Product> products = new HashMap<String, Product>();

	/**
	 * Adds the product.
	 *
	 * @param newProduct
	 *            the new product
	 */
	public void addProduct(Product newProduct) {
		String key = newProduct.getKey();
		products.put(key, newProduct);
	}

	/**
	 * Fetch all.
	 *
	 * @return the list
	 */
	public List<Product> fetchAll() {
		return products.values().stream().collect(Collectors.toList());
	}
}
