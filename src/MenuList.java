import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

public class MenuList {

	private  HashSet<Dish> menu;

	// Constructor
	public MenuList(HashSet<Dish> menu) {
		super();
		this.menu = menu;
	}
	
	// Get all the Names of the Dishes of the Menu in Strings
	public HashSet<String> getAllMenuNames(){
		HashSet<String> menuNames = new HashSet<String>();
		for(Dish dish: menu)
			menuNames.add(dish.getName());
		return menuNames;
	}
	
	//Get HashMap<DishNames,Prices>
	public  HashMap<String,Double> getHashMapDishesAnsPrices(){
		HashMap<String,Double> hashMapDishesAnsPrices = new HashMap<String,Double>();
		for(Dish dish: menu)
			hashMapDishesAnsPrices.put(dish.getName(), dish.getPrice());	
		return hashMapDishesAnsPrices;	
	}

	// Print the Menu
	public void printTheMenu() {

		TreeSet<Dish> starterDishes = new TreeSet<Dish>();
		TreeSet<Dish> mainDishes = new TreeSet<Dish>();
		TreeSet<Dish> dessertDishes = new TreeSet<Dish>();
		TreeSet<Dish> drinkDishes = new TreeSet<Dish>();
		
		//Convert ArrayList to TreeSets
		
		for(Dish dish: menu){
			
			if(dish.getCategory().equals("STARTER"))
				starterDishes.add(dish);
			else if(dish.getCategory().equals("MAIN"))
				mainDishes.add(dish);
			else if(dish.getCategory().equals("DESSERT"))
				dessertDishes.add(dish);
			else if(dish.getCategory().equals("DRINKS"))
				drinkDishes.add(dish);	
		}
		
		//Printing the Menu
		
		System.out.println(String.format("%40s","MENU")+"\n");
		System.out.println(String.format("%43s","===========")+"\n"+"\n");
		System.out.println(String.format("%42s","STARTERS")+"\n"+"\n");
		for(Dish dish: starterDishes)
			System.out.println(String.format("%25s%25s%2s",dish.getName(),dish.getPrice(),"$")+"\n");
		System.out.println( "\n"+String.format("%40s","MAIN")+"\n"+"\n");
		for(Dish dish: mainDishes)
			System.out.println( String.format("%25s%25s%2s",dish.getName(),dish.getPrice(),"$")+"\n");
		System.out.println("\n"+String.format("%42s","DESSERTS")+"\n"+"\n"); 
		for(Dish dish: dessertDishes)
			System.out.println(String.format("%25s%25s%2s",dish.getName(),dish.getPrice(),"$")+"\n") ;
		System.out.println("\n"+String.format("%40s","DRINKS")+"\n"+"\n");
		for(Dish dish: drinkDishes)
			System.out.println(String.format("%25s%25s%2s",dish.getName(),dish.getPrice(),"$")+"\n");

	}

}
