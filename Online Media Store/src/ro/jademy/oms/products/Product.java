package ro.jademy.oms.products;

public class Product {
	private String title;
	private String cost;
	private String releaseDate;
	private String category;
	
	public Product(){
		
	}
	
	public Product(String title, String cost, String releaseDate, String category){
		this.title = title;
		this.cost = cost;
		this.releaseDate = releaseDate;
		this.category = category;
	}
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}

public String toString(){
	return "Generic product";
}



}
