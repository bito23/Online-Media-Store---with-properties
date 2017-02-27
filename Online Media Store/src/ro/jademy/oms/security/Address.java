package ro.jademy.oms.security;

public class Address {
	private String address;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Address: " + address;
	}

}
