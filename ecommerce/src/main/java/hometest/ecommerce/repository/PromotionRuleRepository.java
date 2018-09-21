package hometest.ecommerce.repository;

import java.util.Optional;

import hometest.ecommerce.model.PromotionRule;

/**
 * The Interface PromotionRuleRepository.
 */
public interface PromotionRuleRepository {

	/**
	 * Adds the promotion.
	 *
	 * @param promotion
	 *            the promotion
	 */
	public void addPromotion(PromotionRule promotion);

	/**
	 * Find by date.
	 *
	 * @return the optional
	 */
	public Optional<PromotionRule> findByDate();
}
