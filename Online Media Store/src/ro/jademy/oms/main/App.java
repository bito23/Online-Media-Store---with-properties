package ro.jademy.oms.main;

import ro.jademy.oms.security.Register;
import ro.jademy.oms.ui.Console;

public class App {


	public static void run() {

		Console console = new Console();
		Register register = new Register();
		

		System.err.println("Welcome to myStore");

		register.accountAdmin();

		console.showWelcome();


	}

}
