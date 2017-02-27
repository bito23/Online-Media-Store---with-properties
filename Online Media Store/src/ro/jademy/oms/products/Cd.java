package ro.jademy.oms.products;

public class Cd extends Product {
	private String tracks;
	private String artist;

	public Cd() {

	}

	public Cd(String title, String cost, String releaseDate, String category, String tracks, String artist) {
		super(title, cost, releaseDate, category);
		this.tracks = tracks;
		this.artist = artist;
	}

	public String getTracks() {
		return tracks;
	}

	public void setTracks(String tracks) {
		this.tracks = tracks;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	@Override
	public String toString() {
		return artist + " " + tracks + " " + getTitle() + " " + getCost() + " " + getReleaseDate() + " "
				+ getCategory();
	}
}
