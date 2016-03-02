import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.HashSet;

import org.junit.Test;

public class TestStringinPrintedBill {

	@Test
	public void test() {
		Dish dish=new Dish("Soup",20,"Dessert");
		Dish dish2 = new Dish("Wine",25,"Drinks");
		Order order1= new Order(1,"Soup",1);
		Order order2= new Order(1,"Wine",3);
		
		
		
		HashSet<Dish> hd = new HashSet<Dish>();
		HashSet<Order> ho = new HashSet<Order>();
		hd.add(dish);
		hd.add(dish2);
		ho.add(order1);
		ho.add(order2);
		
		HashMap hm = new HashMap<Integer, HashSet<Order>>();
		hm.put(order1.getTableID(), ho);
		hm.put(order2.getTableID(), ho);
		
		Bill test = new Bill(hd,hm);
		String testEmptyBoll ="";
			
		
		//this assertion checks for value of the string within the method 
		//StringOPrintedBill(1)
		
		assertFalse( testEmptyBoll.equals(test.StringOPrintedBill(1)));
	}

}
