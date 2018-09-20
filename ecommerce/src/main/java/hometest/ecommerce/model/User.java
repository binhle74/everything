package hometest.ecommerce.model;

import java.util.ArrayList;
import java.util.List;

/**
 * The Class User.
 */
public class User {

	/** The name. */
	private String name;

	/** The email. */
	private String email;

	/** The group. */
	private int group;

	/** The carts. */
	private List<ShoppingCart> carts = new ArrayList<ShoppingCart>();

	/**
	 * Instantiates a new user.
	 *
	 * @param name
	 *            the name
	 * @param email
	 *            the email
	 * @param group
	 *            the group
	 */
	public User(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name
	 *            the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email
	 *            the new email
	 */
	public void setEmail(String email) {
		this.email = email;
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
	 * Gets the carts.
	 *
	 * @return the carts
	 */
	public List<ShoppingCart> getCarts() {
		return carts;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + group;
		System.out.println("--------Hash Code: " + result);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (group != other.group)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
