
public class OrderClass {
	//Declaring variables
	private String lastName;
	private int orderNumber;
	private double orderTotalCost;
	//Defining getter methods
	public String getLastName() {
		return lastName;
	}
	public int getOrderNumber() {
		return orderNumber;
	}
	public double getOrderTotalCost() {
		return orderTotalCost;
	}
	//Defining a constructor
	public OrderClass(String lastName, int orderNumber, double orderTotalCost) {
		this.lastName = lastName;
		this.orderNumber = orderNumber;
		this.orderTotalCost = orderTotalCost;
	}
}
