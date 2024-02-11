import java.util.Scanner;
import java.util.InputMismatchException;

public class Main{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		DisplayClass display = new DisplayClass();		
		while(true) {
			// Display the menu
			System.out.println("1. Add a new Order ");
			System.out.println("2. Remove order");
			System.out.println("3. Display Order");
			System.out.println("4. Exit");
			System.out.println("Enter you choice of option: ");
			try{
				 int choice = scanner.nextInt();
				 scanner.nextLine();		
				 switch (choice) {
	             case 1: // Add order
	                 System.out.print("\nEnter customer last name: ");
	                 String lastName = scanner.nextLine();
	                 System.out.print("Enter order number: ");
	                 int orderNumber = scanner.nextInt();
	                 System.out.print("Enter total cost: ");
	                 double totalCost = scanner.nextDouble();
	                 OrderClass order = new OrderClass(lastName, orderNumber, totalCost);
	                 System.out.println("\nDisplay the Order information :");
	                 display.addOrder(order);	          
	                 break;
	             case 2: // Remove order
	                 display.removeOrder();
	                 System.out.print("Item removed from order list.\n");
	                 break;
	             case 3: // Update the order display
	                 display.updateOrderDisplay();
	                 break;
	             case 4:  // Exit 
	                 System.out.println("Exiting.");
	                 System.exit(0);
	                 break;
	             default:
	                 System.out.println("Invalid choice. Please enter a number between 1 and 4.\n");
				 }
			}
			catch(InputMismatchException ex) {
				System.out.println("Invalid Input.\n");
				break;
			}		
         }
	}
}
