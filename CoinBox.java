
/* Sam Larsen
 * Assignment 2 Vending Machine
 * 9/26/2022
 * Written/Online Sources: None
 * Help Obtained: None
 * I confirm that the above list of sources is complete AND that I
 * have not talked to anyone else (e.g., CSC 207 students) about 
 * the solution to this problem.
 */

public class CoinBox {
	 /*
	  * TODO: Define private fields that track the number of each coin.	
  	*/
	private int quarters;
	private int dimes;
	private int nickles;
	// no pennies or dollar coins in this implementation
  

  /*
   * TODO: Define a zero-parameter constructor 
   * that initializes the deposited coins.
   */    
	//0 argument constructor
	public CoinBox() {
		quarters = 0;
		dimes = 0;
		nickles = 0;
	}
	
	// TODO:
	// Define a method to get the current value of the deposited coins in dollar format
	// You may work with an integer if you prefer
	//currentAmt
	//returns the value of the box
	public double currentAmt() {
		return (.25*quarters + .10*dimes + .05*nickles);
	}
  
  /*
   * TODO: Define methods for depositing coins.
   * Define a separate method for each coin type. 
   */
	//depositQuarter
	//increments the quarter count
	public void depositQuarter() {
		quarters++;
	}
	//withdrawQuarter
	//decrements the quarter count
	public void withdrawQuarter() {
		quarters--;
	}
	//depositDime
	//increments the dime count
	public void depositDime() {
		dimes++;
	}
	//withdrawDime
	//decrements the dime count
	public void withdrawDime() {
		dimes--;
	}
	//depositNickle
	//increments the nickle count
	public void depositNickle() {
		nickles++;
	}
	//withdrawNickle
	//decrements the nickle count
	public void withdrawNickle() {
		nickles--;
	}
    
  /*
   * TODO: Define methods for returning the deposited
   * coins. Define a separate method for each coin type.
   * @return deposited coins of a particular type
   */ 
	//getQuarterCount
	//returns quarter count
	public int getQuarterCount() {
		return quarters;
	}
	//getDimeCount
	//returns dime count
	public int getDimeCount() {
		return dimes;
	}
	//getNickleCount
	//returns nickle count
	public int getNickleCount() {
		return nickles;
	}

	/*
   	* TODO: Define, for each coin type, a method that 
   	* sets a new value for that coin type.
   	* Useful when initializing the program or transferring coins between coin boxes
   	* @param The new number of coins for a given coin type
   	*/  
	//setQuarters
	//takes an int and sets the number of quarters to it.
	public void setQuarters(int num_coins) {
	  	quarters = num_coins;
  	}
	//setDimes
	//takes an int and sets the number of dimes to it.
  	public void setDimes(int num_coins) {
	  	dimes = num_coins;
  	}
  	//setNickles
  	//takes an int and sets the number of nickles to it.
  	public void setNickles(int num_coins) {
	  	nickles = num_coins;
  	}
  
  	/*
   	* TODO: Define a method for transferring coins from a
   	* coin box to another coin box.
   	* Note that one of the coin boxes receives the deposited coins 
   	* from users. The other coin box provides change to users.
   	* @param the CoinBox that accepts coins from user. 
   	*/ 
  	//transferCoinsFrom
  	//takes a CoinBox and moves the coins from it into this box
  	public void transferCoinsFrom(CoinBox other) {
  		// take from the other box and deposit in this box
  		quarters += other.quarters;
  		dimes += other.dimes;
  		nickles += other.nickles;
  		other.resetBox();
  	}
  
  	// Optional.  Reset the number of coins in the coin box to be all zeros
  	//resetBox
  	//resets the contensts of the box to 0
  	public void resetBox() {
  		quarters = 0;
  		dimes = 0;
  		nickles = 0;
  	}
 } // end class