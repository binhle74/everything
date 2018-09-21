package hometest.ecommerce.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import hometest.ecommerce.model.Product;
import hometest.ecommerce.model.PromotionRule;
import hometest.ecommerce.model.User;

/**
 * The Class DiscountService.
 */
public class DiscountService {
	/**
	 * Apply promotion.
	 *
	 * @param promotion
	 *            the promotion
	 * @return the double
	 */
	public double applyPromotion(PromotionRule promotion, User user) {
		Map<Product, Long> selectedProducts = user.getCart().getSelectedProducts();
		double total = user.getCart().getTotal();
		// Filter all products which has color met promotion's color.
		List<Product> productsByColor = selectedProducts.keySet().stream()
				.filter(product -> product.getColor().equalsIgnoreCase(promotion.getColor()))
				.collect(Collectors.toList());
		// Check shopping cart can be apply promotion or not
		if (!productsByColor.isEmpty()) {
			if (user.getGroup() == promotion.getGroup() && total >= promotion.getSubTotal()) {
				return total - promotion.getDiscount();
			}
		}
		return total;
	}
}
