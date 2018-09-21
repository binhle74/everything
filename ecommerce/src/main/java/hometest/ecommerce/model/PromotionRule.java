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

	/** The color. */
	private String color;

	/** The sub total. */
	private double subTotal;

	/** The discount. */
	private double discount;

	/**
	 * Instantiates a new promotion rule.
	 *
	 * @param from
	 *            the from
	 * @param to
	 *            the to
	 * @param group
	 *            the group
	 * @param color
	 *            the color
	 * @param subTotal
	 *            the sub total
	 * @param discount
	 *            the discount
	 */
	public PromotionRule(Date from, Date to, int group, String color, double subTotal, double discount) {
		super();
		this.from = from;
		this.to = to;
		this.group = group;
		this.color = color;
		this.subTotal = subTotal;
		this.discount = discount;
	}

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
	 * Gets the color.
	 *
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * Sets the color.
	 *
	 * @param color
	 *            the new color
	 */
	public void setColor(String color) {
		this.color = color;
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

	@Override
	public String toString() {
		return "PromotionRule [from=" + from + ", to=" + to + ", group=" + group + ", color=" + color + ", subTotal="
				+ subTotal + ", discount=" + discount + "]";
	}

}
