package hometest.ecommerce.service;

import java.util.List;

import hometest.ecommerce.model.Product;
import hometest.ecommerce.repository.ProductRepository;
import hometest.ecommerce.repository.impl.MemoryProductRepository;

/**
 * The Class ProductService.
 */
public class ProductService {
	
	/** The product repository. */
	private ProductRepository productRepository;
	
	/**
	 * Instantiates a new product service.
	 */
	public ProductService() {
		this.productRepository = new MemoryProductRepository();
	}
	
	/**
	 * Adds the product.
	 *
	 * @param newProduct the new product
	 * @param quantity the quantity
	 */
	public void addProduct(Product newProduct) {
		this.productRepository.addProduct(newProduct);
	}

	/**
	 * Fetch all.
	 *
	 * @return the list
	 */
	public List<Product> fetchAll() {
		return this.productRepository.fetchAll();
	}
}
