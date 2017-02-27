package ro.jademy.oms.products;

public class Dvd extends Product {
	private String director;
	private String length;
	
	public Dvd(){
		
	}

	public Dvd(String title, String cost, String releaseDate, String category, String director, String length) {
		super(title, cost, releaseDate, category);
		this.director = director;
		this.length = length;
	}


	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	@Override
	public String toString() {
		return director + " " + length + " " + getTitle() + " " + getCost() + " " + getReleaseDate() + " "
				+ getCategory();
	}
}
