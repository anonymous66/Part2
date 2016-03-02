import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class OrderList {

	private static HashMap<Integer, HashSet<Order>> orders;

	//Constructor
	public OrderList(HashMap<Integer, HashSet<Order>> orders) {
		super();
		this.orders = orders;
	}
	
	// Take HashSet of Dish Names in Strings
	public HashSet<String> getHashSetOfStringsOfDishes(){
		HashSet<String> hashSetOfStringsOfDishes = new HashSet<String>();
		for(Integer tableId: orders.keySet()){
			for(Order order: orders.get(tableId))
				hashSetOfStringsOfDishes.add(order.getDishName());
		}
		return hashSetOfStringsOfDishes;
	}

	// Take HashMap<DishName,Quantity> per Table
	public HashMap<String, Integer> getHashMapOfDishNameAndQuantityPerTable(int tableId) {
		HashMap<String, Integer> hashMapOfDishNameAndQuantityPerTable = new HashMap<String, Integer>();
		for (Order order: orders.get(tableId))
			hashMapOfDishNameAndQuantityPerTable.put(order.getDishName(), order.getQuantity());
		return hashMapOfDishNameAndQuantityPerTable;

	}

}
