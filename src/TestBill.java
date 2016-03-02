import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.HashSet;

import org.junit.Test;

public class TestBill {

	@Test
	public void test() {
		Dish dish=new Dish("Scallop",20,"Starter");
		Dish dish2 = new Dish("Oyster",25,"Main");
		Order order1= new Order(1,"Scallop",1);
		Order order2= new Order(1,"Oyster",3);
		
		
		
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
		double correct = 95; //double error = 0;
		//checks if total value is correct and not negative 
		assertTrue( correct == test.SumAllmenuOrders(1) );
		
		
		
		
		
	}
	
}
