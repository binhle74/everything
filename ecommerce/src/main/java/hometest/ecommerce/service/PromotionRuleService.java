package hometest.ecommerce.service;

import java.util.Optional;

import hometest.ecommerce.model.PromotionRule;
import hometest.ecommerce.repository.PromotionRuleRepository;
import hometest.ecommerce.repository.impl.MemoryPromotionRuleRepository;

/**
 * The Class PromotionRuleService.
 */
public class PromotionRuleService {
	
	/** The promotion repository. */
	private PromotionRuleRepository promotionRepository;
	
	/**
	 * Instantiates a new promotion rule service.
	 */
	public PromotionRuleService() {
		this.promotionRepository = new MemoryPromotionRuleRepository();
	}
	
	/**
	 * Adds the promotion.
	 *
	 * @param promotion the promotion
	 */
	public void addPromotion(PromotionRule promotion) {
		this.promotionRepository.addPromotion(promotion);
	}
	
	/**
	 * Find by date.
	 *
	 * @return the optional
	 */
	public Optional<PromotionRule> findByDate() {
		return this.promotionRepository.findByDate();
	}
	
}
