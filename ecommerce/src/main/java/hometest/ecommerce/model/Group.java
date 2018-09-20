package hometest.ecommerce.model;

/**
 * The Enum Group.
 */
public enum Group {
	
	/** The unregister. */
	UNREGISTER(1, "UnRegister"),
	
	/** The register. */
	REGISTER(2, "Register"),
	
	/** The silver. */
	SILVER(3, "Silver"),
	
	/** The gold. */
	GOLD(4, "Gold");
	
	/**
	 * Instantiates a new group.
	 *
	 * @param value the value
	 * @param description the description
	 */
	Group(int value, String description) {
		this.value = value;
		this.description = description;
	}
	
	/** The value. */
	private int value;
	
	/** The description. */
	private String description;

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * Sets the value.
	 *
	 * @param value the new value
	 */
	public void setValue(int value) {
		this.value = value;
	}

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description.
	 *
	 * @param description the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * Find group.
	 *
	 * @param groupVal the group val
	 * @return the group
	 */
	public static Group findGroup(int groupVal) {
		Group[] groups = values();
		for (int i= 0; i < groups.length; i++) {
			if (groups[i].value == groupVal) {
				return groups[i];
			}
		}
		return Group.UNREGISTER;
	}
}
