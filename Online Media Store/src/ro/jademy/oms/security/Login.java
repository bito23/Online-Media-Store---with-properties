package ro.jademy.oms.security;

import java.util.Scanner;

public class Login {

	Scanner keyboard = new Scanner(System.in);

	public int loginOp() {

		boolean flag = false;
		int userTry = 0;
		int counter;

		System.out.println("\nPlease type your username: ");
		String username = keyboard.next();

		for (counter = 0; counter < Account.allAccounts.size(); counter++) {
			if (Account.allAccounts.get(counter).getUser().getUser().equals(username)) {
				flag = true;
				break;
			
			}
		}

		while (userTry < 3) {
			if (flag == false) {

				System.err.println("User not found!");
				System.out.println(" ");
				System.out.println("Please type your username: ");

				username = keyboard.next();

				for (counter = 0; counter < Account.allAccounts.size(); counter++) {
					if (Account.allAccounts.get(counter).getUser().getUser().equals(username)) {
						flag = true;
						break;
					}
				}
			}
			if (flag == true) {
				System.out.println("Please type your password: ");
				String password = keyboard.next();

				if (Account.allAccounts.get(counter).getUser().getPassword().equals(password)) {
					System.err.println("\nWelcome " + Account.allAccounts.get(counter).getUser().getFullName() + "!");
					break;
				} else {
					try {
						System.err.println("Wrong password!");
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					userTry++;
					continue;
				}
			}
		}


		if (userTry == 3) {
			Account.allAccounts.get(counter).getUser().setEnable(false);

		}

		return counter;
	}

}
