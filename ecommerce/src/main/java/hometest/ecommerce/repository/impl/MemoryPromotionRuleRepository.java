package hometest.ecommerce.repository.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import hometest.ecommerce.model.PromotionRule;
import hometest.ecommerce.repository.PromotionRuleRepository;

/**
 * The Class PromotionRuleRepository.
 */
public class MemoryPromotionRuleRepository implements PromotionRuleRepository {

	/** The promotions. */
	private Set<PromotionRule> promotions = new HashSet<PromotionRule>();

	/**
	 * Adds the promotion.
	 *
	 * @param promotion
	 *            the promotion
	 */
	public void addPromotion(PromotionRule promotion) {
		promotions.add(promotion);
	}

	/**
	 * Find by date.
	 *
	 * @return the optional
	 */
	public Optional<PromotionRule> findByDate() {
		Date currentDate = new Date();
		return promotions.stream().filter(promotion -> {
			return promotion.getFrom().before(currentDate) && promotion.getTo().after(currentDate);
		}).findFirst();
	}
}
