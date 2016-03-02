import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Manager {

	// Main Data Structures of the Program
	private HashSet<Dish> menu = new HashSet<Dish>();
	private HashMap<Integer, HashSet<Order>> orders = new HashMap<Integer, HashSet<Order>>();

	public void run() throws FileNotFoundException {

		// Finding Files and Creating the Data Structures
		File menuFile = new File("C:\\menu.txt");
		File ordersFile = new File("C:\\orders.txt");

		ReadMenu aMenu = new ReadMenu(menuFile);
		menu = aMenu.getMenu();

		ReadOrders allOrders = new ReadOrders(ordersFile, menu);
		orders = allOrders.getOrders();
		
		Kitchen kitchen = new Kitchen();
		kitchen.run();

		// Create and start the GUI
		Bill_GUI billgui = new Bill_GUI(menu, orders);

		// Print the Menu in the File The_Menu
		MenuList printedMenu = new MenuList(menu);
		File file1 = new File("C:\\Users\\bill\\Desktop\\the_Menu.txt");
		FileOutputStream fos1 = new FileOutputStream(file1);
		PrintStream ps1 = new PrintStream(fos1);
		System.setOut(ps1);
		printedMenu.printTheMenu();

		// Print the FrequencyReport
		FrequencyReport freqReport = new FrequencyReport(orders);
		File file2 = new File("C:\\Users\\bill\\Desktop\\Frequency_Report.txt");
		FileOutputStream fos2 = new FileOutputStream(file2);
		PrintStream ps2 = new PrintStream(fos2);
		System.setOut(ps2);
		freqReport.printFrequencyReport();

		// Dishes not Ordered
		FrequencyReport dishesNotOrdered = new FrequencyReport(orders);
		File file3 = new File("C:\\Users\\bill\\Desktop\\Dishes_Not_Ordered.txt");
		FileOutputStream fos3 = new FileOutputStream(file3);
		PrintStream ps3 = new PrintStream(fos3);
		System.setOut(ps3);
		dishesNotOrdered.printDishesNotOrdered();
	}

}
