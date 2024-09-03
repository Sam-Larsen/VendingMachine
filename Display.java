
/* Sam Larsen
 * Assignment 2 Vending Machine
 * 9/26/2022
 * Written/Online Sources: None
 * Help Obtained: None
 * I confirm that the above list of sources is complete AND that I
 * have not talked to anyone else (e.g., CSC 207 students) about 
 * the solution to this problem.
 */

public class Display {
	
	// possible private data fields	
	
	public Display() {

	
	}
	
	// TODO:
	// displays the message passed in from calling method
	// currently only prints to the screen, but it could be used with a GUI 
	// or with a PrintWriter or medium
	//show
	//prints out the string passed
	public void show(String message) {
		System.out.println(message);
	}
	
	// TODO: message that informs user of an error 
	//error
	//prints out the message in an error format
	public void error(String message) {
		System.out.println("Error: " + message);
	}
	
	// TODO:  inform the user of change returned
	//takeChange
	//tells the user to take their change and their change ammount
	public void takeChange(int q, int d, int n) {
		System.out.println("Please take your change:");
		System.out.println(q + " quarters " + d + " dimes " + n + " nickels.");
	}
	
	// TODO: create messages for events that happen in multiple parts of the program
	// so that you avoid retyping.  
	// These are examples - create what you need
	//change
	//prints out the ammount of change due to the user
	public void change(double d) {
		System.out.format("Change due: $%.2f\n", d);
	}
	//list
	//prints out the BrandInventory oject passed in a clear format
	public void list(BrandInventory b) {
		System.out.format("Brand ID: %s price: $%.2f\n", b.getID(), b.getPrice());
	}
	//sale
	//Prints out the ammount the user has deposited and the
	// price that the user needs to pay
	public void sale(double s, double f) {
		System.out.format("Price: $%.2f Deposited: $%.2f\n", s, f);
	}
	//pay
	//Tells the user to pay and what the possible inputs are
	public void pay() {
		System.out.println("Insert bill, quarter, dime, or nickel:");
	}
	//soldOut
	//Tells the user that an item is sold out
	public void soldOut() {
		System.out.println("Sorry, that brand is sold out.");
	}
	//allSoldOut
	//tells the user that the machine is sold out
	public void allSoldOut() {
		System.out.println("Sorry, everything is sold out.");
	}
	//badID
	//tells the user that the id entered is out of stock or not real
	public void badID() {
		System.out.println("Incorrect ID or out of stock, please try again.");
	}
	//sold
	//reports a successful sale to the user
	public void sold() {
		System.out.println("Sale successful. Please take your beverage.");
	}
	//notExactChange
	//tells the user that the machine cannot output exact change.
	public void notExactChange() {
		System.out.println("Sorry, cannot make exact change!");
	}
	


}