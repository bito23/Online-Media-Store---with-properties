package ro.jademy.oms.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import ro.jademy.oms.products.Book;
import ro.jademy.oms.products.Cd;
import ro.jademy.oms.products.Dvd;
import ro.jademy.oms.repository.DataFromProperties;

public class ShowProducts {

	public void showAllProducts() {

		// media properties file contains all the products in our store
		
		Properties prop = new Properties();
		FileInputStream fis;
		try {
			fis = new FileInputStream("src//ro//jademy//oms//main//media.properties");
			prop.load(fis);
		} catch (FileNotFoundException e1) {
			System.err.println("The file does not exist on disk!");
			e1.printStackTrace();
			System.exit(0);
		} catch (IOException e) {
			System.err.println("Error reported when uploading data");
			e.printStackTrace();
			System.exit(0);
		}

		DataFromProperties dfp = new DataFromProperties(prop);
		
		showAllDvds(dfp.loadAllDvds());
		showAllBooks(dfp.loadAllBooks());
		showAllCds(dfp.loadAllCds());
	}

	public void showAllDvds(ArrayList<Dvd> listDvd) { 
		System.err.println("Id|\t  Title\t\t| Length | Category  |   Year   |     Director       | Price");

		try {
			Thread.sleep(150);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("-----------------------------------------------------------------------------------");
		for (int i = 0; i < listDvd.size(); i++) {
			System.out.print(i + 1 + " | ");
			System.out.println(listDvd.get(i).getTitle() + " | " + listDvd.get(i).getLength() + " | "
					+ listDvd.get(i).getCategory() + " | " + listDvd.get(i).getReleaseDate() + " | "
					+ listDvd.get(i).getDirector() + " | " + listDvd.get(i).getCost());

		}
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println();
	}

	public void showAllBooks(ArrayList<Book> listBooks) {
		System.err.println("Id|\t  Title    | Pages  |  Category |   Year   |     Author    | Price");

		try {
			Thread.sleep(150);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("-----------------------------------------------------------------------------------");
		for (int i = 0; i < listBooks.size(); i++) {
			System.out.print(i + 1 + " | ");
			System.out.println(listBooks.get(i).getTitle() + " | " + listBooks.get(i).getPageNo() + " | "
					+ listBooks.get(i).getCategory() + " | " + listBooks.get(i).getReleaseDate() + " | "
					+ listBooks.get(i).getAuthor() + " | " + listBooks.get(i).getCost());

		}
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println();
	}

	public void showAllCds(ArrayList<Cd> listCd) {
		System.err.println("Id|\t    Title       | Tracks| Category  |   Year   |    Artist    | Price");

		try {
			Thread.sleep(150);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("-----------------------------------------------------------------------------------");
		for (int i = 0; i < listCd.size(); i++) {
			System.out.print(i + 1 + " | ");
			System.out.println(listCd.get(i).getTitle() + " | " + listCd.get(i).getTracks() + " | "
					+ listCd.get(i).getCategory() + " | " + listCd.get(i).getReleaseDate() + " | "
					+ listCd.get(i).getArtist() + " | " + listCd.get(i).getCost());
		}
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println();
	}
}
