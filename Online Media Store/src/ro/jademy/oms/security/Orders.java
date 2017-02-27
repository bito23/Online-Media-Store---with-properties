package ro.jademy.oms.security;

public class Orders {
	private double cost;
	private String title;
	private static int idOrder;

	public double getCost() {
		return cost;
	}

	public Orders() {
		setIdOrder(idOrder);
		idOrder++;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public static void setIdOrder(int idOrder) {
		Orders.idOrder = idOrder;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getIdOrder() {
		return idOrder;
	}

	@Override
	public String toString() {
		return "Orders [cost=" + cost + ", title=" + title + ", idOrder=" + idOrder + "]";
	}

}
