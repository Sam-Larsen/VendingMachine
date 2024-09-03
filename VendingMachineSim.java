import java.util.Scanner;

/* Sam Larsen
 * Assignment 2 Vending Machine
 * 9/26/2022
 * Written/Online Sources: None
 * Help Obtained: None
 * I confirm that the above list of sources is complete AND that I
 * have not talked to anyone else (e.g., CSC 207 students) about 
 * the solution to this problem.
 * 
 * VendingMachineSim
 * The main method to use the vending machine
 */

public class VendingMachineSim {

	public static void main (String [] args) {
		boolean runSim = true;
		Display display = new Display();
		// remember to give some introduction to the simulation
		display.show("Welcome to the Soda Shack!!");
		
		// create the Vending Machine object itself
		try {
			display.show("Hang on while I get set up.");
			VendingMachine v = new VendingMachine();
			Scanner sc = new Scanner(System.in);
			String response = "";
			String input = "";
			while(runSim) {
				display.show("Do you want to buy a beverage? (yes or no)");
			
				if (sc.hasNext())
					response = sc.nextLine();
				
				if (response.toLowerCase().equals("yes")) {
					v.printChoices();
					display.show("Enter the ID number of the beverage you want.");
					response = sc.nextLine();
					if(v.isAvailable(response)) {
						while(v.getAmtDeposited() < v.getPrice(response)) {
							display.sale(v.getPrice(response), v.getAmtDeposited());
							display.pay();
							input = sc.nextLine();
							if(input.toLowerCase().equals("quarter")){
								v.acceptQuarter();
							}
							else if(input.toLowerCase().equals("dime")){
								v.acceptDime();
							}
							else if(input.toLowerCase().equals("nickle")){
								v.acceptNickle();
							}
							else if(input.toLowerCase().equals("bill")){
								v.acceptBill();
							}
						}
						display.sold();
						display.change(v.calcChange(response));
						v.makeChange(v.calcChange(response));
						v.completeSale();
						v.sold(response);
					}
					else {
						display.badID();
					}
				}  // if "yes"
				else {
					runSim = false;
					display.show("Thank you for visiting the Soda Shack!");
				}
			}	// while
			sc.close();
		}catch(NullPointerException e) {
			display.error("Null Pointer");
		}

	} // main


} // class