import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Bill {

	//attributes
	private HashSet<Dish> menu;
	private HashMap<Integer, HashSet<Order>> orders;
	private double total = 0;

	//Constructor
	public Bill(HashSet<Dish> menu, HashMap<Integer, HashSet<Order>> orders) {
		super();
		this.menu = menu;
		this.orders = orders;
	}

	//Custom Method. Counts the whole Earnings of the Restaurant
	public double SumAllmenuOrders(int aTableID) {

		MenuList allMenu = new MenuList(menu);
		OrderList tableOrders = new OrderList(orders);

		double sumOfDish = 0;
		double sumOfAllDishes = 0;

		try {
			for (Order order : orders.get(aTableID)) {
				sumOfDish = order.getQuantity() * allMenu.getHashMapDishesAnsPrices().get(order.getDishName());
				sumOfAllDishes += sumOfDish;
		

			}
		} catch (Exception e) {
			System.out.println("This Table was not used today");
		}

		return total += sumOfAllDishes;

	}

	// Count and Print the Bill
	public String StringOPrintedBill(int aTableID) {

		String printedBill = "";

		MenuList allMenu = new MenuList(menu);
		OrderList tableOrders = new OrderList(orders);

		double sumOfDish = 0;
		double sumOfAllDishes = 0;
		printedBill += String.format("%38s", "BILL")  + String.format("%41s", "==========="+"\n");
		printedBill += String.format("\n"+"%40s", "\n"+"Table " + aTableID) + "\n";
		try {
			for (Order order : orders.get(aTableID)) {
				sumOfDish = order.getQuantity() * allMenu.getHashMapDishesAnsPrices().get(order.getDishName());
				sumOfAllDishes += sumOfDish;
				sumOfDish = Math.round(sumOfDish * 1e2) / 1e2;

				printedBill += String.format("\n" + "%25s%10s%10s%2s", order.getDishName(),
						order.getQuantity() + "     *", allMenu.getHashMapDishesAnsPrices().get(order.getDishName()),
						" $  =  " + sumOfDish + " $");

			}
		} catch (Exception e) {
			printedBill = "This Table was not used today";

		}

		printedBill += "\n";
		printedBill += String.format("\n" + "%58s",
				"Total without Tax " + Math.round(sumOfAllDishes * 1e2) / 1e2 + " $");
		printedBill += String.format("\n" + "%58s", "Tax  " + Math.round(sumOfAllDishes * 0.23 * 1e2) / 1e2 + " $");
		printedBill += String.format("\n" + "%58s",
				"Total Bill " + Math.round(sumOfAllDishes * 1.23 * 1e2) / 1e2 + " $");
		double sum = 0;
		for (int i = 1; i <= 10; i++) {
			sum += SumAllmenuOrders(i);
			sum = Math.round(sum * 1e2) / 1e2;

		}
		System.out.println("Total Restaurant " + sum + " $");
		return printedBill;
	}

}
