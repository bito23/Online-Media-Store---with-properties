package ro.jademy.oms.service;

import java.util.ArrayList;

import ro.jademy.oms.products.Product;

public class Cart {

	public static ArrayList<Product> myCart;
	Order currentOrder = new Order();
	public double price;

	public ArrayList<Product> myCart() {

		myCart = new ArrayList<Product>();

		// myCart ArrayList contains all the products we added in the cart

		myCart.addAll(currentOrder.currentOrder());

		if (myCart.isEmpty()) {
			System.out.println("\nYour shopping cart is currently empty!\n");
		} else {

			System.out.println("\nShopping cart: ");
			System.out.println("--------------\n");

			price = 0;

			for (int i = 0; i < myCart.size(); i++) {
				System.out.println(i + 1 + ". " + myCart.get(i).getTitle());
				price += Double.valueOf(myCart.get(i).getCost());
			}

			System.out.println("\nCost: " + price + " RON\n");
		}

		return myCart;

	}
}
