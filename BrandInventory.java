
/* Sam Larsen
 * Assignment 2 Vending Machine
 * 9/26/2022
 * Written/Online Sources: None
 * Help Obtained: None
 * I confirm that the above list of sources is complete AND that I
 * have not talked to anyone else (e.g., CSC 207 students) about 
 * the solution to this problem.
 */

public class BrandInventory {
// this class keeps track of the information for each separate brand stocked
// in the vending machine.  The machine will keep an ArrayList of these objects
	
	//  private data fields
	private String id;
	private float price;
	private int numItems;
	
	//3 argument constuctor
	public BrandInventory(String i, float p, int n) {
		id = i;
		price = p;
		numItems = n;
	}
	
	// TODO: create accessors for each of the private fields
	//getId
	//returns id
	public String getID() {
		return id;
	}
	//getPrice
	//returns price
	public float getPrice() {
		return price;
	}
	//getCount
	//returns numItems
	public int getCount() {
		return numItems;
	}
	
	/*
	 *  TODO: Define a method that updates the available 
	 *  number of sodas after a successful purchase.
	 */
	//reduceOnHand
	//reduces the count of the item
	public void reduceOnHand() {
		 numItems --;
	 }
	
	/* TODO: Define a method that returns true if 
	 * the number on hand for this brand has dropped to 0
	 */
	//isSoldOut
	//returns true if the numItems is 0 or less
	//false otherwise
	public boolean isSoldOut() {
		if(numItems < 1) {
			return true;
		}
		return false;
	}
	
	/* TODO: Define a method that returns a string containing
	 * the ID of the brand, the formatted price of each soda
	*/
	//toString
	//returns a string stating the Id and price.
	public String toString() {
		return "Brand ID:" + id + " price: $" + price;
	}


}
