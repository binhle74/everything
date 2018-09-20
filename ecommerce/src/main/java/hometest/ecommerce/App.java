package hometest.ecommerce;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import hometest.ecommerce.model.User;

/**
 * The Class App.
 */
public class App {

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		User user1 = new User("Binh", "levanbinh1605@gmail.com");
		User user2 = new User("Binh", "binhvl@gcs-vn.com");
		User user3 = new User("Binh", "levanbinh1605@gmail.com");
		System.out.println(user1.equals(user3));

		Map<User, String> maps = new HashMap<User, String>();
		maps.put(user1, "A");
		maps.put(user3, "B");
		maps.put(user2, "C");
		System.out.println(maps.keySet().stream().map(user -> user.getEmail()).collect(Collectors.toList()));

		Map<String, String> maps2 = new HashMap<String, String>();
		maps2.put("a", "b");
		maps2.put("a", "c");
	}
}
