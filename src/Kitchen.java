import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;

public class Kitchen implements Runnable {

	private HashSet<Dish> menu = new HashSet<Dish>();
	private HashMap<Integer, HashSet<Order>> orders = new HashMap<Integer, HashSet<Order>>();
	Thread t = new Thread();

	@SuppressWarnings("deprecation")
	@Override
	public void run() {
		t.start();
		// TODO Auto-generated method stub
		File menuFile = new File("C:\\menu.txt");
		File ordersFile = new File("C:\\orders.txt");

		ReadMenu aMenu = null;
		try {
			aMenu = new ReadMenu(menuFile);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		menu = aMenu.getMenu();

		ReadOrders allOrders = null;
		try {
			allOrders = new ReadOrders(ordersFile, menu);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		orders = allOrders.getOrders();
		try {

			for (Integer orderkey : orders.keySet()) {
				Thread.sleep(2000);		
				HashSet<Order> value = orders.get(orderkey);
				for(Order order : value)
				System.out.println("The table number : "+order.getTableID() + order.getDishName() + order.getQuantity() );

			}
//t.stop();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
