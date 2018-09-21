package hometest.ecommerce.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * The Class ShoppingCart.
 */
public class ShoppingCart {

	/** The user. */
	private User user;

	/** The selected products. */
	private Map<Product, Long> selectedProducts = new HashMap<Product, Long>();

	/** The total. */
	private double total;

	/** The total net. */
	private double totalNet;

	/**
	 * Gets the user.
	 *
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * Sets the user.
	 *
	 * @param user
	 *            the new user
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * Adds the product.
	 *
	 * @param product
	 *            the product
	 */
	public void addProduct(Product product, long quantity) {
		long newQuantity = quantity;
		if (selectedProducts.containsKey(product)) {
			newQuantity += selectedProducts.get(product);
		}
		selectedProducts.put(product, newQuantity);
	}

	/**
	 * Removes the product.
	 *
	 * @param product
	 *            the product
	 */
	public void removeProduct(Product product) {
		if (selectedProducts.containsKey(product)) {
			selectedProducts.remove(product);
		}
	}

	/**
	 * Gets the selected products.
	 *
	 * @return the selected products
	 */
	public Map<Product, Long> getSelectedProducts() {
		return selectedProducts;
	}

	/**
	 * Gets the total.
	 *
	 * @return the total
	 */
	public double getTotal() {
		this.total = 0;
		for (Entry<Product, Long> entry : this.selectedProducts.entrySet()) {
			this.total += entry.getKey().getPrice() * entry.getValue();
		}
		return total;
	}

	/**
	 * Gets the total net.
	 *
	 * @return the total net
	 */
	public double getTotalNet() {
		return totalNet;
	}

	/**
	 * Sets the total net.
	 *
	 * @param totalNet
	 *            the new total net
	 */
	public void setTotalNet(double totalNet) {
		this.totalNet = totalNet;
	}

	@Override
	public String toString() {
		return "ShoppingCart [user=" + user.getName() + ", selectedProducts=" + selectedProducts + ", total=" + total
				+ ", totalNet=" + totalNet + "]";
	}

}
