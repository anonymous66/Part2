
public class DoubleDishPerTableException extends Exception {
	
	private String name;
	private int tableId;
	
	public DoubleDishPerTableException(String name, int tableId) {
		
		System.out.println("Sorry the Table "+tableId+" is not allowed to order the dish: "+name+" again.");
		//The quantity of the Dish remains the same. Will not be counted
		
	}
	
	
	
	
	
	

}
