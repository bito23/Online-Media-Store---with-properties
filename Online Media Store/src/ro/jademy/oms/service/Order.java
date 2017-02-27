package ro.jademy.oms.service;

import java.util.ArrayList;

import ro.jademy.oms.products.Book;
import ro.jademy.oms.products.Cd;
import ro.jademy.oms.products.Dvd;
import ro.jademy.oms.products.Product;
import ro.jademy.oms.repository.DataFromProperties;

public class Order {

	DataFromProperties data = new DataFromProperties();

	// all the products by category
	public ArrayList<Dvd> allDvds = new ArrayList<Dvd>();
	public ArrayList<Cd> allCds = new ArrayList<Cd>();
	public ArrayList<Book> allBooks = new ArrayList<Book>();

	// all the products
	ArrayList<Product> allProducts = new ArrayList<Product>();


	public ArrayList<Dvd> orderedDvd;
	public ArrayList<Cd> orderedCd;
	public ArrayList<Book> orderedBook;
	public static ArrayList<Product> orderedProducts = new ArrayList<Product>();

	public ArrayList<Product> currentOrder() {

		// this is the current order
		// after this method is over, all the products will be saved in myCart

		if (orderedDvd != null) {
			orderedProducts.addAll(orderedDvd);
		}
		if (orderedCd != null) {
			orderedProducts.addAll(orderedCd);
		}
		if (orderedBook != null) {
			orderedProducts.addAll(orderedBook);
		}
		return orderedProducts;

	}


	// with these methods the user can buy dvds, cds or books by index

	public ArrayList<Dvd> orderNewDvd(int index) {

		allDvds.addAll(data.dvds);
		orderedDvd = new ArrayList<Dvd>();

		if (index < allDvds.size()) {
			orderedDvd.add(allDvds.get(index));

		} else {
			System.out.println("Product not found!");
		}
		return orderedDvd;

	}

	public ArrayList<Book> orderNewBook(int index) {

		allBooks.addAll(data.books);
		orderedBook = new ArrayList<Book>();

		if (index < allBooks.size()) {
			orderedBook.add(allBooks.get(index));
		} else {
			System.out.println("Product not found!");
		}

		return orderedBook;
	}

	public ArrayList<Cd> orderNewCd(int index) {

		allCds.addAll(data.cds);
		orderedCd = new ArrayList<Cd>();

		if (index < allCds.size()) {
			orderedCd.add(allCds.get(index));
		} else {
			System.out.println("Product not found!");
		}

		return orderedCd;

	}

}
