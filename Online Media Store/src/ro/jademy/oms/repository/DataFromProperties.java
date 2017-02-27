package ro.jademy.oms.repository;

import java.util.ArrayList;
import java.util.Properties;
import ro.jademy.oms.products.Book;
import ro.jademy.oms.products.Cd;
import ro.jademy.oms.products.Dvd;

public class DataFromProperties {

	private Properties prop;
	public static ArrayList<Dvd> dvds;
	public static ArrayList<Cd> cds;
	public static ArrayList<Book> books;

	public DataFromProperties() {
	}

	public DataFromProperties(Properties prop) {
		this.prop = prop;
	}

	public ArrayList<Dvd> loadAllDvds() {

		dvds = new ArrayList<Dvd>();
		int indexDvd = 1;

		// load all dvds from media.properties

		while (prop.getProperty("dvd" + indexDvd + ".denumire") != null) {
			Dvd dvd = new Dvd();

			String dvdTitle = "dvd" + indexDvd + ".denumire";
			dvd.setTitle(prop.getProperty(dvdTitle));

			String dvdCost = "dvd" + indexDvd + ".pret";
			dvd.setCost(prop.getProperty(dvdCost));

			String dvdReleaseDate = "dvd" + indexDvd + ".anAparitie";
			dvd.setReleaseDate(prop.getProperty(dvdReleaseDate));

			String dvdCategory = "dvd" + indexDvd + ".categorie";
			dvd.setCategory(prop.getProperty(dvdCategory));

			String dvdLength = "dvd" + indexDvd + ".lungime";
			dvd.setLength(prop.getProperty(dvdLength));

			String dvdDirector = "dvd" + indexDvd + ".regizor";
			dvd.setDirector(prop.getProperty(dvdDirector));

			// add this dvd in the ArrayList

			dvds.add(dvd);
			indexDvd++;

		}
		return dvds;
	}

	public ArrayList<Book> loadAllBooks() {

		books = new ArrayList<Book>();
		int indexBook = 1;

		// load all the books from media.properties

		while (prop.getProperty("carte" + indexBook + ".denumire") != null) {
			Book book = new Book();

			String bookTitle = "carte" + indexBook + ".denumire";
			book.setTitle(prop.getProperty(bookTitle));

			String bookCost = "carte" + indexBook + ".pret";
			book.setCost(prop.getProperty(bookCost));

			String bookReleaseDate = "carte" + indexBook + ".anAparitie";
			book.setReleaseDate(prop.getProperty(bookReleaseDate));

			String bookCategory = "carte" + indexBook + ".categorie";
			book.setCategory(prop.getProperty(bookCategory));

			String pageNo = "carte" + indexBook + ".nrPagini";
			book.setPageNo(prop.getProperty(pageNo));

			String bookAuthor = "carte" + indexBook + ".autor";
			book.setAuthor(prop.getProperty(bookAuthor));

			// add this book in the ArrayList
			books.add(book);
			indexBook++;
		}
		return books;
	}

	public ArrayList<Cd> loadAllCds() {

		cds = new ArrayList<Cd>();
		int indexCd = 1;

		// load all cds from media.properties
		
		while (prop.getProperty("cd" + indexCd + ".denumire") != null) {
			Cd cd = new Cd();

			String cdTitle = "cd" + indexCd + ".denumire";
			cd.setTitle(prop.getProperty(cdTitle));

			String cdCost = "cd" + indexCd + ".pret";
			cd.setCost(prop.getProperty(cdCost));

			String cdReleaseDate = "cd" + indexCd + ".anAparitie";
			cd.setReleaseDate(prop.getProperty(cdReleaseDate));

			String cdCategory = "cd" + indexCd + ".categorie";
			cd.setCategory(prop.getProperty(cdCategory));

			String tracks = "cd" + indexCd + ".nrPiese";
			cd.setTracks(prop.getProperty(tracks));

			String cdArtist = "cd" + indexCd + ".artist";
			cd.setArtist(prop.getProperty(cdArtist));

			//add this cd in the ArrayList
			cds.add(cd);
			indexCd++;
		}
		return cds;
	}

}
