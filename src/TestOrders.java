import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.Test;

public class TestOrders {

	@Test
	public void test() {
		
		
		Order expected1 = new Order(1,"Scallop",1) ;
	
		//checking for orders format
		Order order1= new Order(1,"Scallop",1);
	    Order actual1 = new Order(order1.getTableID(), order1.getDishName(),order1.getQuantity());
		assertEquals(expected1,actual1);
		
		//checking for dishes format
		
		Dish expected2=new Dish("Scallop",20,"Starter");
		
		Dish dish1= new Dish("Scallop",20,"Starter");
	    Dish actual2 = new Dish(dish1.getName(), dish1.getPrice(),dish1.getCategory());
		assertEquals(expected2,actual2);

	}

}
