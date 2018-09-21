package hometest.ecommerce;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.Objects;
import java.util.Optional;
import java.util.Scanner;

import hometest.ecommerce.model.Product;
import hometest.ecommerce.model.PromotionRule;
import hometest.ecommerce.model.User;
import hometest.ecommerce.service.DiscountService;
import hometest.ecommerce.service.ProductService;
import hometest.ecommerce.service.PromotionRuleService;

/**
 * The Class App.
 */
public class App {

	/** The product service. */
	private static ProductService productService;

	/** The promotion service. */
	private static PromotionRuleService promotionService;

	/** The discount service. */
	private static DiscountService discountService;

	/**
	 * Inits the.
	 */
	private static void init() {
		productService = new ProductService();
		promotionService = new PromotionRuleService();
		discountService = new DiscountService();
		
		// Notes
		System.out.println("Notes: ");
		System.out.println("- The 'TOTAL NET' is total of cart after applying Promotion.");
	}

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		init();
		Scanner scanner = new Scanner(System.in);
		User user = null;
		int selection;
		do {
			printMenu();
			selection = selectMenu(scanner);
			switch (selection) {
			case 1:
				user = enterUser(scanner);
				break;
			case 2:
				addProduct(scanner);
				break;
			case 3:
				buy(scanner, user);
				break;
			case 4:
				addPromotion(scanner);
				break;
			case 5:
				showCart(user, scanner);
				break;
			case 6:
				break;
			}
		} while (selection != 6);
		scanner.close();
	}

	/**
	 * Show cart.
	 *
	 * @param user
	 *            the user
	 * @param scanner
	 *            the scanner
	 */
	private static void showCart(User user, Scanner scanner) {
		Map<Product, Long> selectedProducts = showCartDetail(user);
		int prodNo;
		do {
			System.out.println("Select product No. (Press 0 to exit.)");
			prodNo = scanner.nextInt();
			scanner.nextLine();
			List<Product> products = selectedProducts.keySet().stream().collect(Collectors.toList());
			if (prodNo != 0) {
				if (prodNo > 0 && prodNo <= products.size()) {
					user.getCart().removeProduct(products.get(prodNo - 1));
					showCartDetail(user);
				}
			}
		} while (prodNo != 0);
	}

	/**
	 * Show cart detail.
	 *
	 * @param user the user
	 * @return the map
	 */
	private static Map<Product, Long> showCartDetail(User user) {
		System.out.println("------------- CART -----------------");
		// Show all selected products
		Map<Product, Long> selectedProducts = user.getCart().getSelectedProducts();
		System.out.printf("%-6s%-22s%-14s%-13s%-13s\n", "+-NO.--", "+------PRODUCT NAME------", "+---COLOR----+",
				"----PRICE----+", "----QUANTITY----+");
		int i = 0;
		if (selectedProducts.isEmpty()) {
			System.out.println("Your cart is empty.");
		} else {
			for (Entry<Product, Long> entry : selectedProducts.entrySet()) {
				Product product = entry.getKey();
				Long quantity = entry.getValue();
				System.out.printf("|%-1s%-5s|%-6s%-18s|%-3s%-9s|%-3s%-10s|%-5s%-11s|\n", " ", i + 1, " ", product.getName(),
						" ", product.getColor(), " ", product.getPrice(), " ", quantity);
				i++;
			}
			System.out.printf("%-68s\n", "+------+------------------------+------------+-------------+----------------+");
			
			System.out.println("+---------------+---------------------+");
			System.out.println("|     TOTAL     |       " + user.getCart().getTotal() + "        |");
			System.out.println("+---------------+---------------------+");
			
			// Apply promotion
			Optional<PromotionRule> promotionOpt = promotionService.findByDate();
			if (promotionOpt.isPresent()) {
				double totalNet = discountService.applyPromotion(promotionOpt.get(), user);
				user.getCart().setTotalNet(totalNet);
				if (totalNet != user.getCart().getTotal()) {
					System.out.println("+---------------+---------------------+");
					System.out.println("|     TOTAL NET |       " + user.getCart().getTotalNet() + "        |");
					System.out.println("+---------------+---------------------+");
				}
			}
		}
		return selectedProducts;
	}

	/**
	 * Buy.
	 *
	 * @param scanner
	 *            the scanner
	 * @param user
	 *            the user
	 */
	private static void buy(Scanner scanner, User user) {
		System.out.println("------------- SHOPPING -----------------");
		// Show list of product
		List<Product> availableProducts = productService.fetchAll();
		System.out.printf("%-6s%-22s%-14s%-13s\n", "+-NO.--", "+------PRODUCT NAME------", "+---COLOR----+",
				"----PRICE----+");
		for (int i = 0; i < availableProducts.size(); i++) {
			Product product = availableProducts.get(i);
			System.out.printf("|%-1s%-5s|%-6s%-18s|%-3s%-9s|%-3s%-10s|\n", " ", i + 1, " ", product.getName(), " ",
					product.getColor(), " ", product.getPrice());
		}
		System.out.printf("%-68s\n", "+------+------------------------+------------+-------------+--------------+");
		int prodNo;
		do {
			System.out.println("Select product No. (Press 0 to exit.)");
			prodNo = scanner.nextInt();
			if (prodNo != 0) {
				System.out.println("Enter quantity: ");
				int quantity = scanner.nextInt();
				scanner.nextLine();
				if (prodNo > 0 && prodNo <= availableProducts.size()) {
					if (Objects.nonNull(user)) {
						user.getCart().addProduct(availableProducts.get(prodNo - 1), quantity);
						System.out.println(user.getCart());
					}
				}
			}
		} while (prodNo != 0);
	}

	/**
	 * Select menu.
	 *
	 * @param scanner
	 *            the scanner
	 * @return the int
	 */
	private static int selectMenu(Scanner scanner) {
		int selection;
		do {
			selection = scanner.nextInt();
			scanner.nextLine();
		} while (selection < 1 || selection > 6);
		return selection;
	}

	/**
	 * Prints the menu.
	 */
	private static void printMenu() {
		System.out.println("+------------- SHOPPING CART -----------------+");
		System.out.println("|   1. Enter user information                 |");
		System.out.println("|   2. Add product                            |");
		System.out.println("|   3. Shopping                               |");
		System.out.println("|   4. Add promotion                          |");
		System.out.println("|   5. View shopping cart                     |");
		System.out.println("|   6. Exit                                   |");
		System.out.println("+---------------------------------------------+");
		System.out.println("Select menu (1 ~ 6): ");
	}

	/**
	 * Enter user.
	 *
	 * @param scanner
	 *            the scanner
	 * @return the user
	 */
	private static User enterUser(Scanner scanner) {
		System.out.println("------------- USER -----------------");
		System.out.println("User name:");
		String username = scanner.nextLine();
		System.out.println("Email: ");
		String email = scanner.nextLine();
		System.out.println("Group: ");
		int group = enterUserGroup(scanner);
		return new User(username, email, group);
	}

	/**
	 * Adds the product.
	 *
	 * @param scanner
	 *            the scanner
	 */
	private static void addProduct(Scanner scanner) {
		System.out.println("------------- PRODUCT -----------------");
		int selection;
		do {
			System.out.println("Product name: ");
			String name = scanner.nextLine();
			System.out.println("Product color: ");
			String color = scanner.nextLine();
			System.out.println("Price: ");
			double price = scanner.nextDouble();
			scanner.nextLine();
			Product product = new Product(name, color, price);
			productService.addProduct(product);
			System.out.println("1. Continue to add product.");
			System.out.println("0. Exit");
			selection = scanner.nextInt();
			scanner.nextLine();
		} while (selection == 1);
	}

	/**
	 * Adds the promotion.
	 *
	 * @param scanner
	 *            the scanner
	 * @return the promotion rule
	 */
	private static void addPromotion(Scanner scanner) {
		System.out.println("------------- PROMOTION ----------------");
		System.out.println("Enter FROM date: ");
		Date fromDate = enterDate(scanner);
		System.out.println("Enter TO date: ");
		Date toDate = enterDate(scanner);
		int group = enterUserGroup(scanner);
		scanner.nextLine();
		System.out.println("Enter color: ");
		String color = scanner.nextLine();
		System.out.println("Enter subtotal: ");
		double subtotal = scanner.nextDouble();
		System.out.println("Enter discount: ");
		double discount = scanner.nextDouble();
		PromotionRule promotion = new PromotionRule(fromDate, toDate, group, color, subtotal, discount);
		promotionService.addPromotion(promotion);
	}

	/**
	 * Enter date.
	 *
	 * @param scanner
	 *            the scanner
	 * @return the date
	 */
	private static Date enterDate(Scanner scanner) {
		Date date = null;
		do {
			System.out.println("Enter date with format 'dd/MM/yyyy HH:mm:ss': ");
			String dateStr = scanner.nextLine();
			date = parseStringToDate(dateStr);
		} while (Objects.isNull(date));
		return date;
	}

	/**
	 * Parses the string to date.
	 *
	 * @param dateStr
	 *            the date str
	 * @return the date
	 */
	private static Date parseStringToDate(String dateStr) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		try {
			return sdf.parse(dateStr);
		} catch (ParseException e) {
			System.out.println("Parse Exception");
		}
		return null;
	}

	/**
	 * Enter user group.
	 *
	 * @param scanner
	 *            the scanner
	 * @return the int
	 */
	private static int enterUserGroup(Scanner scanner) {
		int group;
		do {
			System.out.println("Enter the user group: 1. Unregister, 2. Register, 3. Silver, 4. Gold");
			group = scanner.nextInt();
		} while (group < 1 || group > 4);
		scanner.nextLine();
		return group;
	}
}
