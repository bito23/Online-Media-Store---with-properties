package ro.jademy.oms.service;

import java.util.Scanner;

import ro.jademy.oms.security.Account;

public class Service {

	Scanner keyboard = new Scanner(System.in);

	public boolean changePassword(int index) {

		boolean flag = false;

		System.out.println("Current Password: ");
		String currentPassword = keyboard.nextLine();

		if (Account.allAccounts.get(index).getUser().getPassword().equals(currentPassword)) {
			System.out.println("New Password: ");
			String newPassword1 = keyboard.nextLine();

			System.out.println("Confirm Password: ");
			String newPassword2 = keyboard.nextLine();

			if (newPassword1.equals(newPassword2)) {
				Account.allAccounts.get(index).getUser().setPassword(newPassword1);
				flag = true;
				return flag;

			} else {
				System.err.println("These passwords do not match!");
			}

		} else {
			System.err.println("Wrong password!");
			flag = false;
		}

		return flag;
	}

	public boolean changeAddress(int index) {

		boolean flag = false;

		System.out.println("Current Password: ");
		String currentPassword = keyboard.nextLine();

		if (Account.allAccounts.get(index).getUser().getPassword().equals(currentPassword)) {
			System.out.println("Please enter the new address: ");
			String newAddress = keyboard.nextLine();

			Account.allAccounts.get(index).getAddress().setAddress(newAddress);
			flag = true;
			return flag;

		} else {
			System.err.println("Wrong password!");
			flag = false;
		}

		return flag;
	}

}
