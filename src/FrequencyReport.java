import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class FrequencyReport {

	public HashSet<Dish> menu = new HashSet<Dish>();
	public HashMap<Integer, HashSet<Order>> orders = new HashMap<Integer, HashSet<Order>>();

	// Constructor
	public FrequencyReport(HashSet<Dish> menu, HashMap<Integer, HashSet<Order>> orders) {
		super();
		this.menu = menu;
		this.orders = orders;
	}
	
	public FrequencyReport(HashMap<Integer, HashSet<Order>> orders) {
		super();
		this.orders = orders;
	}

	// Print Frequency Report
	public void printFrequencyReport() {

		HashSet<Order> setOrders = new HashSet<Order>();
		for (Integer tableId : orders.keySet()) {
			setOrders.addAll(orders.get(tableId));
		}
		System.out.println("FREQUENCY REPORT" + "\n" + "=================" + "\n");
		for(Order order: setOrders)
			System.out.println(String.format("%25s%10s", order.getDishName(), order.getQuantity()));
	}
	
	// Print Dishes Not Ordered
	public void printDishesNotOrdered(){
		MenuList theMenu = new MenuList(menu);
		OrderList someOrders = new OrderList(orders);
		HashSet<String> aMenu = theMenu.getAllMenuNames();
		HashSet<String> allOrders = someOrders.getHashSetOfStringsOfDishes();
		
	
		
		System.out.println("DISHES NOT ORDERED"+"\n"+"==================="+"\n");
	
			for(String dishName:allOrders )
			System.out.println(dishName);
		
		
		
	}
	

}
