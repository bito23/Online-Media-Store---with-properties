package ro.jademy.oms.ui;

import java.util.Scanner;

import ro.jademy.oms.repository.DataFromProperties;
import ro.jademy.oms.security.Account;
import ro.jademy.oms.security.Login;
import ro.jademy.oms.security.Orders;
import ro.jademy.oms.security.Register;
import ro.jademy.oms.service.Cart;
import ro.jademy.oms.service.Order;
import ro.jademy.oms.service.Service;
import ro.jademy.oms.service.ShowProducts;

public class Console {

	Scanner keyboard = new Scanner(System.in);

	ShowProducts showProducts = new ShowProducts();
	Register register = new Register();
	Login login = new Login();

	int indexUser;

	// authentication menu

	public void showWelcome() {

		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("[1] Log in");
		System.out.println("[2] Register");

		int userInput = keyboard.nextInt();

		switch (userInput) {
		case 1:
			indexUser = login.loginOp();
			if (Account.allAccounts.get(indexUser).getUser().isEnable() == false) {
				System.err.println("\nYour account is blocked. Please visit our website!\n");
			} else {
				showHomeMenu();
			}
			break;
		case 2:
			register.register();
			showWelcome();
			break;
		default:
			System.err.println("Please insert a valid command!");

		}
	}

	// home menu of myStore console application

	public void showHomeMenu() {
		Cart myCart = new Cart();
		int userInput;

		do {
			System.out.println("[1] All products");
			System.out.println("[2] Shopping cart");
			System.out.println("[3] myAccount");
			System.out.println("[4] Logout");

			userInput = keyboard.nextInt();

			switch (userInput) {
			case 1:
				showProducts.showAllProducts();
				secondMenu();
				break;
			case 2:
				myCart.myCart();
				break;
			case 3:
				accountSettings(indexUser);
				break;
			case 4:
				System.out.println("\nHave a nice day!\n");
				showWelcome();
				return;
			default:
				System.err.println("Please insert a valid command!");
			}
		} while (userInput != 4);

	}

	public void secondMenu() {

		int userInput;
		do {
			System.out.println("[1] Fast purchase");
			System.out.println("[2] All DVDs");
			System.out.println("[3] All CDs");
			System.out.println("[4] All Books");
			System.out.println("[5] Home");

			userInput = keyboard.nextInt();

			switch (userInput) {
			case 1:
				shoppingMenu();
				break;
			case 2:
				dvdsMenu();
				break;
			case 3:
				cdsMenu();
				break;
			case 4:
				booksMenu();
				break;
			case 5:
				showHomeMenu();
				break;
			default:
				System.err.println("Please insert a valid command!");
			}
		} while (true);

	}

	public void booksMenu() {

		// show all the books
		showProducts.showAllBooks(DataFromProperties.books);

		Order order = new Order();

		do {
			System.out.println("[1] Buy book");
			System.out.println("[2] Order now");
			System.out.println("[3] Back");

			int userInput = keyboard.nextInt();

			switch (userInput) {
			case 1:
				System.out.println("Please insert the book's id: ");
				int idBook = keyboard.nextInt() - 1;
				order.orderNewBook(idBook);
				System.out.println("\nThe book >> " + order.allBooks.get(idBook).getTitle().trim()
						+ " << was successfully added to your shopping cart.\n");
				order.currentOrder();
				break;
			case 2:
				sendOrder();
				break;
			case 3:
				secondMenu();
				break;
			default:
				System.err.println("Please insert a valid command!");

			}

		} while (true);
	}

	public void cdsMenu() {

		// show all CDs
		showProducts.showAllCds(DataFromProperties.cds);

		Order order = new Order();

		do {
			System.out.println("[1] Buy CD");
			System.out.println("[2] Order now");
			System.out.println("[3] Back");

			int userInput = keyboard.nextInt();

			switch (userInput) {
			case 1:
				System.out.println("Please insert the CD's id: ");
				int idCd = keyboard.nextInt() - 1;
				order.orderNewCd(idCd);
				System.out.println("\nThe CD >> " + order.allCds.get(idCd).getTitle().trim()
						+ " << was successfully added to your shopping cart.\n");
				order.currentOrder();
				break;
			case 2:
				sendOrder();
				break;
			case 3:
				secondMenu();
				break;
			default:
				System.err.println("Please insert a valid command!");

			}

		} while (true);
	}

	public void dvdsMenu() {

		// show all the DVDs
		showProducts.showAllDvds(DataFromProperties.dvds);

		Order order = new Order();

		do {
			System.out.println("[1] Buy DVD");
			System.out.println("[2] Order now");
			System.out.println("[3] Back");

			int userInput = keyboard.nextInt();

			switch (userInput) {
			case 1:
				System.out.println("Please insert the DVD's id: ");
				int idDvd = keyboard.nextInt() - 1;
				order.orderNewDvd(idDvd);
				System.out.println("\nThe DVD >> " + order.allDvds.get(idDvd).getTitle().trim()
						+ " << was successfully added to your shopping cart.\n");
				order.currentOrder();
				break;
			case 2:
				sendOrder();
				break;

			case 3:
				secondMenu();
				break;
			default:
				System.err.println("Please insert a valid command!");

			}

		} while (true);
	}

	public void sendOrder() {

		Cart myCart = new Cart();
		Orders orderHistory = new Orders();
		Order order = new Order();

		myCart.myCart();

		double price = myCart.price;
		int shippingCost = 25;

		// show this only if the cart is not empty
		if (price > 0) {
			try {
				System.out.println("Shipping cost: " + shippingCost + " RON");
				Thread.sleep(100);
				System.err.println("TOTAL:\t     " + (price + shippingCost) + " RON\n");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println("[1] Send order");
		System.out.println("[2] Back");
		int userInput = keyboard.nextInt();

		if (userInput == 1 && price > 0) {
			
			System.out.println("\nThank you for your order!\n");

			for (int i = 0; i < myCart.myCart.size(); i++) {
				orderHistory.setTitle(myCart.myCart.get(i).getTitle());
				orderHistory.setCost(price + shippingCost);

			}

			//add current order to orderHistory ArrayList
			Account.allAccounts.get(indexUser).orderHistory.add(orderHistory);

			order.currentOrder().clear();
			
		} else if (userInput == 2) {
			secondMenu();
		} else {
			System.err.println("Please add at least one item to your cart before checking out!\n");
		}
	}

	public void accountSettings(int indexUser) {

		Service service = new Service();

		try {
			System.err.println("\nAccount details");
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//info : full name, username and address
		
		System.out.println("Full name: " + Account.allAccounts.get(indexUser).getUser().getFullName());
		System.out.println("Username: " + Account.allAccounts.get(indexUser).getUser().getUser());
		System.out.println("Address: " + Account.allAccounts.get(indexUser).getAddress().getAddress());

		System.out.println("\n[1] Change password");
		System.out.println("[2] Change address");
		System.out.println("[3] Order history");
		System.out.println("[4] Back");

		int userInput = keyboard.nextInt();

		switch (userInput) {
		case 1:
			service.changePassword(indexUser);
			showWelcome();
			break;
		case 2:
			service.changeAddress(indexUser);
			accountSettings(indexUser);
			break;
		case 3:
			System.out.println("\nOrder History:");
			System.out.println("--------------\n");
			if(Account.allAccounts.get(indexUser).orderHistory.isEmpty()){
				System.out.println("Your order history is empty!\n");
			}else{

			for (int i = 0; i < Account.allAccounts.get(indexUser).orderHistory.size(); i++) {
				System.out.println((i+1) + "."
						+ Account.allAccounts.get(indexUser).orderHistory.get(i).getTitle().trim()
						+  "\t >>" + Account.allAccounts.get(indexUser).orderHistory.get(i).getCost() + "<< RON\n");
			}
			}
			break;
		case 4:
			showHomeMenu();
			break;
		default:
			System.err.println("Please insert a valid command!");

		}

	}

	public void shoppingMenu() {

		Order order = new Order();
		Cart myCart = new Cart();

		System.out.println("Product category: ");
		String productCategory = keyboard.next().toLowerCase();

		System.out.println("Product id: ");
		int productId = keyboard.nextInt() - 1;

		switch (productCategory) {
		case "dvd":
			order.orderNewDvd(productId);
			System.out.println("\nThe DVD >> " + order.allDvds.get(productId).getTitle().trim()
					+ " << was successfully added to your shopping cart.\n");
			break;
		case "cd":
			order.orderNewCd(productId);
			System.out.println("\nThe CD >> " + order.allCds.get(productId).getTitle().trim()
					+ " << was successfully added to your shopping cart.\n");
			break;
		case "book":
			order.orderNewBook(productId);
			System.out.println("\nThe book >> " + order.allBooks.get(productId).getTitle().trim()
					+ " << was successfully added to your shopping cart.\n");
			break;
		default:
			try {
				System.err.println("\nPlease insert a valid category!!\n");
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			shoppingMenu();

		}
		order.currentOrder();

		System.out.println("[1] Continue shopping");
		System.out.println("[2] View cart");
		System.out.println("[3] Proceed to checkout\n");

		int userInput = keyboard.nextInt();

		switch (userInput) {
		case 1:
			showProducts.showAllProducts();
			break;
		case 2:
			myCart.myCart();
			break;
		case 3:
			sendOrder();
			break;
		default:
			System.err.println("Please insert a valid command!");

		}

	}

}
