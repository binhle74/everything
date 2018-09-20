package hometest.ecommerce.model;

import java.util.Date;

/**
 * The Class PromotionRule.
 */
public class PromotionRule {

	/** The from. */
	private Date from;

	/** The to. */
	private Date to;

	/** The group. */
	private int group;

	/** The sub total. */
	private double subTotal;

	/** The discount. */
	private double discount;

	/**
	 * Gets the from.
	 *
	 * @return the from
	 */
	public Date getFrom() {
		return from;
	}

	/**
	 * Sets the from.
	 *
	 * @param from
	 *            the new from
	 */
	public void setFrom(Date from) {
		this.from = from;
	}

	/**
	 * Gets the to.
	 *
	 * @return the to
	 */
	public Date getTo() {
		return to;
	}

	/**
	 * Sets the to.
	 *
	 * @param to
	 *            the new to
	 */
	public void setTo(Date to) {
		this.to = to;
	}

	/**
	 * Gets the group.
	 *
	 * @return the group
	 */
	public int getGroup() {
		return group;
	}

	/**
	 * Sets the group.
	 *
	 * @param group
	 *            the new group
	 */
	public void setGroup(int group) {
		this.group = group;
	}

	/**
	 * Gets the sub total.
	 *
	 * @return the sub total
	 */
	public double getSubTotal() {
		return subTotal;
	}

	/**
	 * Sets the sub total.
	 *
	 * @param subTotal
	 *            the new sub total
	 */
	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}

	/**
	 * Gets the discount.
	 *
	 * @return the discount
	 */
	public double getDiscount() {
		return discount;
	}

	/**
	 * Sets the discount.
	 *
	 * @param discount
	 *            the new discount
	 */
	public void setDiscount(double discount) {
		this.discount = discount;
	}
}
