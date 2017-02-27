package ro.jademy.oms.products;

public class Book extends Product {

	private String pageNo;
	private String author;

	public Book() {
	}

	public Book(String title, String cost, String releaseDate, String category, String pageNo, String author) {
		super(title, cost, releaseDate, category);
		this.pageNo = pageNo;
		this.author = author;
	}

	public String getPageNo() {
		return pageNo;
	}

	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return author + " " + pageNo + " " + getTitle() + " " + getCost() + " " + getReleaseDate() + " "
				+ getCategory();
	}

}
