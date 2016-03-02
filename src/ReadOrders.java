import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class ReadOrders {

	// Attributes
	private HashMap<Integer, HashSet<Order>> orders = new HashMap<Integer, HashSet<Order>>();
	private HashSet<Dish> menu = new HashSet<Dish>();
	private int errorLineOther = 1;
	private int errorLineTableId = 1;
	private int errorLineDishName = 0;
	private int errorLineQuantity = 1;
	private int errorLineSameCouple = 0;

	// Create HashSets of Orders per Table
	private HashSet<Order> orderTable1 = new HashSet<Order>();
	private HashSet<Order> orderTable2 = new HashSet<Order>();
	private HashSet<Order> orderTable3 = new HashSet<Order>();
	private HashSet<Order> orderTable4 = new HashSet<Order>();
	private HashSet<Order> orderTable5 = new HashSet<Order>();
	private HashSet<Order> orderTable6 = new HashSet<Order>();
	private HashSet<Order> orderTable7 = new HashSet<Order>();
	private HashSet<Order> orderTable8 = new HashSet<Order>();
	private HashSet<Order> orderTable9 = new HashSet<Order>();
	private HashSet<Order> orderTable10 = new HashSet<Order>();

	// Constructor
	public ReadOrders(File order, HashSet<Dish> aMenu) throws FileNotFoundException {

		menu = aMenu;

		Scanner scannerOrders = null;

		// reads every single line from our file
		try {
			scannerOrders = new Scanner(order);
		} catch (Exception e) {
			System.out.println("Sorry, the Orders file is missing");
			System.exit(0);
		}

		while (scannerOrders.hasNextLine()) {

			String inputLine = scannerOrders.nextLine();
			String OrderParts[] = inputLine.split(",");

			// my variables before try and catch
			String ordTableId = "";
			int orderTableId = 0;
			String orderDishName = "";
			String ordQuantity = "";
			int orderQuantity = 0;

			// try out of bounds error which catches it in the end
			try {
				// variable which will count on which line our error is
				errorLineOther++;

				ordTableId = OrderParts[0];
				ordTableId = ordTableId.trim();
				try {
					orderTableId = Integer.parseInt(ordTableId);

					// counter for error line
					errorLineTableId++;
				} catch (Exception e) {
					System.out.println("Wrong Input in Line " + errorLineTableId + " in the Orders File !" + "\n"
							+ "Please Check that you have given a value Table Number");
					System.exit(0);
				}

				orderDishName = OrderParts[1];

				ordQuantity = OrderParts[2];
				ordQuantity = ordQuantity.trim();
				try {
					orderQuantity = Integer.parseInt(ordQuantity);
					// errorline for Quantity
					errorLineQuantity++;
				} catch (Exception e) {
					System.out.println("Wrong Input in Line " + errorLineQuantity + " in the Orders File !" + "\n"
							+ "Please Check that you have given an integer value for the qunatity");
					System.exit(0);
				}

			} catch (Exception e) {
				int errorLineOtherMinusOne = errorLineOther - 1;
				System.out.println("Problem in Line " + errorLineOtherMinusOne + " !" + "\n" + "Check your input again."
						+ "\n" + "Check if you haven’t forgotten any commas. ");
				System.exit(0);
			}

			//Check if there is an appropriate number of tables given
			if(orderTableId>10) {
			System.out.println("Sorry an order could not be achieved cause there is not a table with number: "+orderTableId+" in the Restaurant" );
			
		
			}
			//Check if the Order Dishes match the Menu dishes
			int f=0;
			
			MenuList taMenu = new MenuList(menu);
			if(( taMenu.getAllMenuNames().contains(orderDishName))&&f==0) {
				
			}else{
				f++;
				System.out.println("Sorry the dish: "+orderDishName+" is not contained in the Menu");
				System.exit(0);
			}
			
			Order eachOrder = new Order(orderTableId, orderDishName, orderQuantity);
			// Creating the HashMap of All Orders
			if (orderTableId == 1) {
				orderTable1.add(eachOrder);
				orders.put(1, orderTable1);
			} else if (orderTableId == 2) {
				orderTable2.add(eachOrder);
				orders.put(2, orderTable2);
			} else if (orderTableId == 3) {
				orderTable3.add(eachOrder);
				orders.put(3, orderTable3);
			} else if (orderTableId == 4) {
				orderTable4.add(eachOrder);
				orders.put(4, orderTable4);
			} else if (orderTableId == 5) {
				orderTable5.add(eachOrder);
				orders.put(5, orderTable5);
			} else if (orderTableId == 6) {
				orderTable6.add(eachOrder);
				orders.put(6, orderTable6);
			} else if (orderTableId == 7) {
				orderTable7.add(eachOrder);
				orders.put(7, orderTable7);
			} else if (orderTableId == 8) {
				orderTable8.add(eachOrder);
				orders.put(8, orderTable8);
			} else if (orderTableId == 9) {
				orderTable9.add(eachOrder);
				orders.put(9, orderTable9);
			} else if (orderTableId == 10) {
				orderTable10.add(eachOrder);
				orders.put(10, orderTable10);
			}

		}
		scannerOrders.close();
	}

	//Return the Main Data Structure 
	public HashMap<Integer, HashSet<Order>> getOrders() {
		return orders;
	}

}
