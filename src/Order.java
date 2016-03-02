import java.util.ArrayList;

public class Order {
	
	//attributes
	private int id;
	private int tableID;
	private String dishName;
	private int quantity;
	private int idCounter = 1;


	// Constructor
	public Order(int tableID, String dishName, int quantity) {
		
		this.tableID = tableID;
		this.dishName = dishName;
		this.quantity = quantity;
		id = idCounter++;
		
	}

	// Get Methods
	public int getId() {
		return id;
	}

	public int getTableID() {
		return tableID;
	}

	public String getDishName() {
		return dishName;
	}

	public int getQuantity() {
		return quantity;
	}
	
	
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	//For HashSet Method
	public boolean equals(Object other){
		Order otherOrder = (Order)other;
		
		if (this.getDishName().equals(otherOrder.getDishName()) && this.getTableID() == otherOrder.getTableID()) {
			
			DoubleDishPerTableException error = new DoubleDishPerTableException(this.getDishName(),this.getTableID());
			//The quantity of the Dish remains the same. Will not be counted
			otherOrder.setQuantity(quantity);
			return otherOrder.getDishName().equals(this.getDishName());
			
		}
		else{
			//Ads the quantity of the Dish
			otherOrder.setQuantity(quantity+otherOrder.getQuantity());
			return otherOrder.getDishName().equals(this.getDishName());
		}
		
		
	}
	public int hashCode() {
		return dishName.hashCode();
	}

}
