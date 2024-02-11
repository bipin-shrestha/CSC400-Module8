import java.util.LinkedList;
import java.util.Queue;

public class DisplayClass {
	private Queue<OrderClass> orderQueue = new LinkedList<>();
	private OrderClass[] sortedByName = new OrderClass[0];
	private OrderClass[] sortedByOrderNumber = new OrderClass[0];
	//Method to add order; 
	public void addOrder(OrderClass order) {
		orderQueue.add(order);
		updateOrderDisplay();
	}
	// Method to remove order
	public void removeOrder() {
		if(!orderQueue.isEmpty()) {
			orderQueue.remove();
			updateOrderDisplay();
		}else {
			System.out.println("No orders to remove.");
		}
	}
	//Method to update order display
	public void updateOrderDisplay() {
		// To convert queue to arrays
		sortedByName = orderQueue.toArray(new OrderClass[0]);
		sortedByOrderNumber = orderQueue.toArray(new OrderClass[0]);
		//Sorting the arrays
		quickSortByName(sortedByName, 0, sortedByName.length - 1);
		quickSortByOrderNumber(sortedByOrderNumber, 0, sortedByOrderNumber.length - 1 );
		displayOrder(sortedByOrderNumber);
	}
	//Implementation of quicksort by name
	private void quickSortByName(OrderClass[] array, int low, int high) {
		if(low < high) {
			int pi = partitionByName(array, low, high);
			quickSortByName(array, low, pi - 1);
			quickSortByName(array, pi + 1, high);
		}
	}
	//Implementation of quicksort by order number
	private void quickSortByOrderNumber(OrderClass[] array, int low, int high) {
		if(low < high) {
			int pi = partitionByOrderNumber(array, low, high);
			quickSortByOrderNumber(array, low, pi - 1);
			quickSortByOrderNumber(array, pi + 1, high);
		}
	}
	//Method to partition the array by name
	private int partitionByName(OrderClass[] array,int low, int high) {
		OrderClass pivot = array[high];
		int a = low - 1;
		for(int i = low; i < high; i++) {
			if(array[i].getLastName().compareTo(pivot.getLastName())>0) {
				a++;			
				array[a] = array[i];				
			}
		}
		OrderClass temp = array[a + 1];
		array[a + 1] = array[high];
		array[high] = temp;
		return a + 1;
	}
	//Method to partition the array by order number
	private int partitionByOrderNumber(OrderClass[] array, int low, int high) {
		OrderClass pivot = array[high];
		int a = low - 1;
		for(int i = low; i < high; i++) {
			if(array[i].getOrderNumber() > pivot.getOrderNumber()) {
				a++;
				OrderClass temp = array[a];
				array[a] = array[i];
				array[i] = temp;
			}
		}
		OrderClass temp = array[a + 1];
		array[a + 1] = array[high];
		array[high] = temp;
		return a + 1;
	}
	//Method to display the order list
	public void displayOrder(OrderClass[] order) {
	    for (int i = 0; i < order.length; i++) {
	        OrderClass Order = order[i];
	        System.out.println("Lastname : " + Order.getLastName() + ", Order Number : " + Order.getOrderNumber() 
	        + ", Total Cost : " + Order.getOrderTotalCost());
	    }
	}
}










