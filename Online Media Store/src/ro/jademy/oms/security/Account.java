package ro.jademy.oms.security;

import java.util.ArrayList;

public class Account {

	private User user;
	private Address address;
	private Orders orders;
	
	public static ArrayList<Orders> orderHistory = new ArrayList<Orders>();
	public static ArrayList<Account> allAccounts = new ArrayList<Account>();

	public Account() {

	}
	
	public ArrayList<Orders> orderHistory(){
		orderHistory.add(getOrders());
		return orderHistory;
	}

	

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Username: " + user.getFullName() + "\n Address:" + address.getAddress();
	}

}
