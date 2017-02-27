package ro.jademy.oms.security;

import java.util.Scanner;

public class Register {

	User currentUser;
	Account currentAccount;
	Address currentAddress;

	Scanner keyboard = new Scanner(System.in);

	public void register() {

		accountAdmin();

		currentAccount = new Account();
		currentUser = new User();
		currentAddress = new Address();

		boolean flag = true;

		System.out.println("Please choose an username: ");
		String newUsername = keyboard.nextLine();

		if (newUsername.matches("\\w*\\s+\\w*")) {
			System.err.println("Username cannot contain spaces.");
		} else {
			for (int counter = 0; counter < Account.allAccounts.size(); counter++) {
				if (Account.allAccounts.get(counter).getUser().getUser().equals(newUsername)) {
					flag = true;
				} else {
					flag = false;
				}
			}

			if (flag == true) {
				System.err.println("The username you specified is already in use. Please choose a different username!");
			} else {
				currentUser.setUser(newUsername);
				System.out.println("Please choose a password:");
				currentUser.setPassword(keyboard.next());
				System.out.println("Please type your full name:");
				keyboard.nextLine();
				currentUser.setFullName(keyboard.nextLine());

				currentAccount.setUser(currentUser);

				System.out.println("Please insert your address:");

				currentAddress.setAddress(keyboard.nextLine());

				currentAccount.setAddress(currentAddress);

				Account.allAccounts.add(currentAccount);
			}

		}
	}

	public void accountAdmin() {
		User adminOMS = new User();
		Address adminAddress = new Address();

		adminOMS.setUser("admin");
		adminOMS.setFullName("Admin myStore");
		adminOMS.setPassword("1234");
		adminOMS.setEnable(true);

		adminAddress.setAddress("-myStore-");
		Account adminAccount = new Account();

		adminAccount.setUser(adminOMS);
		adminAccount.setAddress(adminAddress);

		Account.allAccounts.add(adminAccount);
	}
}
