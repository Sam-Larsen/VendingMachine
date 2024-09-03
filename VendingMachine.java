import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.NumberFormatException;
import java.util.ArrayList;
import java.util.InputMismatchException;

/* Sam Larsen
 * Assignment 2 Vending Machine
 * 9/26/2022
 * Written/Online Sources: None
 * Help Obtained: None
 * I confirm that the above list of sources is complete AND that I
 * have not talked to anyone else (e.g., CSC 207 students) about 
 * the solution to this problem.
 * 
 * Vending Machine Class
 * This class sets up the vending machine object and the classes
 * used in it't implementation.
 */
public class VendingMachine {

	// this could also be an array and assume i < 10
	// this array or ArrayList stores the information for all of the
	// brands of soda for sale in the vending machine.  
	// TODO: create other private data fields you need
	private ArrayList<BrandInventory> inventory;
	private CoinBox changeBox;
	private CoinBox depositCoins;
	private BillBox dollars;
	// TODO: create the constructor.
	// It will need to read the config file "config.dat" and create the inventory
	// In eclipse, the file needs to be at the same level as the bin and src folders
	// so you do not need the full path
	
	// Make sure you handle possible errors and close the file before
	// you end the constructor!
	
	//Constructor for the Vending Machine
	public VendingMachine() {
		// Read the file and create the ArrayList with
		// the information about the sodas in stock
		try {
			File file = new File("config.dat");
			Scanner s = new Scanner(file);
			inventory = new ArrayList<BrandInventory>();
			String str;
			Float f;
			int i;
			BrandInventory b;
			while (s.hasNextLine()) {
				str = s.next();
				f = s.nextFloat();
				i = s.nextInt();
				b = new BrandInventory(str, f, i);
				inventory.add(b);
			}
			s.close();
			
		} catch(FileNotFoundException e) {
			Display display = new Display();
			display.error("File Not Found");
		} catch(NumberFormatException e) {
			Display display = new Display();
			display.error("File Not Configured Correctly");
		} catch(InputMismatchException e) {
			Display display = new Display();
			display.error("File Not Configured Correctly");
		}
		// load up initial change in the change box so that you can make change
		// for early transactions ... 10 coins each as a starting point
		changeBox = new CoinBox();
		changeBox.setQuarters(10);
		changeBox.setDimes(10);
		changeBox.setNickles(10);
		depositCoins = new CoinBox();
		dollars = new BillBox();
		
	} // end constructor
	
	/* TODO: check that the selected ID is valid and is not sold out
	 * May be split into two methods		 
	*/
	//IsAvailable
	//Takes a String and checks if it is in the
	//inventory array list and if the stock is
	//greater than 0. 
	//Returns a boolean
	public boolean isAvailable(String purchaseID) {
		for(int i = 0; i < inventory.size(); i ++) {
			if(inventory.get(i).getID().equals(purchaseID)) {
				if(inventory.get(i).getCount() > 0) {
					return true;
				}
			}
		}
		return false;
	}
	// TODO: you will need several methods to handle the purchase
	// I have a few below that you might consider.   Remember that this
	// class must handle the workings of the Vending Machine and not share
	// private information with the user interface of VendingMachineSim
	

	
	// this would be displayed for the user to see in many machines so that they know
	// how much more to deposit
	
	//getAmtDeposited
	//returns the amount of money in deposit box and bill box
	public double getAmtDeposited() {
		return depositCoins.currentAmt() + dollars.getCurrentBills();
	
	}
	
	// TODO:  methods that accept bills and coins
	//acceptBill
	//increments bill count
	public void acceptBill() {
		dollars.depositBill();
 	}
	//acceptQuarter
	//increments Quarter count
	public void acceptQuarter() {
	 	depositCoins.depositQuarter();
    }
	//acceptDime
	//increments dime count
    public void acceptDime() {
    	depositCoins.depositDime();
    }
    //acceptNickle
    //increments nickle count
    public void acceptNickle() {
	   depositCoins.depositNickle();
    }
   
   // you may use a naive algorithm rather than trying to find an elegant algorithm
   // this assumes that you know the amount that needs to be returned to the user
   // after the purchase
   // returns true if it can make exact change and false otherwise
    //makeChange
    //Takes a dollar ammount and tries to decrease the
    //Coins in the coinbox to represent giving change
    //Returns a boolean value based on if it was able
    //to return exact change.
    public boolean makeChange(double dollar_amount) {
	   int dollarInt = (int)Math.round(dollar_amount*100);
	   if(dollar_amount > changeBox.currentAmt()) {
		   return false;
	   }
	   if(dollar_amount == 0) {
		   return true;
	   }
	   int q = 0;
	   int d = 0;
	   int n = 0;
	   while(dollarInt >= 25 && changeBox.getQuarterCount() > 0) {
		   dollarInt -= 25;
		   q++;
		   changeBox.withdrawQuarter();
	   }
	   while(dollarInt >= 10 && changeBox.getDimeCount() > 0) {
		   dollarInt -= 10;
		   d++;
		   changeBox.withdrawDime();
	   }
	   while(dollarInt >= 5 && changeBox.getNickleCount() > 0) {
		   dollarInt -= 5;
		   n++;
		   changeBox.withdrawNickle();
	   }
	   Display display = new Display();
	   display.takeChange(q, d, n);
	   if(dollarInt == 0) {
		   return true;
	   }
	   display.notExactChange();
	   return false;
    }
    
    //getPrice
    //Takes a string representing the Id of a BrandInvbbentory 
    //object and returns the price if it exists
	public double getPrice(String s) {
		for(int i = 0; i < inventory.size(); i ++) {
			if(inventory.get(i).getID().equals(s)) {
				return inventory.get(i).getPrice();
			}
		}
		return 0.00;
	}
	
	//calcChange
	//Takes a string to find the price and uses the depositbox
	//to find out how much they have paid to calculate change
	//returns change due
	public double calcChange(String s) {
		return getAmtDeposited() - getPrice(s); 
	}
	
	// this is mostly a diagnostic method to check the stock \
	//printInventory
	//Prints the contents of inventory
	public void printInventory() {
		Display display = new Display();
		for(int i = 0; i < inventory.size(); i ++) {
			display.show(inventory.get(i).toString() + ", " + inventory.get(i).getCount() + " remaining");
		}
	}
	
	// this is used to let the user what their valid choices are
	//printChoices
	//prints out the options that the user can choose
	public void printChoices() {
		Display display = new Display();
		for(int i = 0; i < inventory.size(); i ++) {
			if(inventory.get(i).getCount() > 0) {
				display.list(inventory.get(i));
			}
		}
	}
	
	// use a method to handle clean up and transfer coins from the deposited coin box
	// to the change box and reset the bill counter	
	//completeSale
	//transfers the coins deposited to the coinbox and emptys the dollars
	public void completeSale() {
		changeBox.transferCoinsFrom(depositCoins);
		dollars.resetBills();
	}
	
	//sold
	//reduces the count of a BrandInventory when sold
	public void sold(String s) {
		for(int i = 0; i < inventory.size(); i ++) {
			if(inventory.get(i).getID().equals(s)) {
				inventory.get(i).reduceOnHand();
			}
		}
	}
} // end of class