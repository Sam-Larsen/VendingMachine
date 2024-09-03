
/* Sam Larsen
 * Assignment 2 Vending Machine
 * 9/26/2022
 * Written/Online Sources: None
 * Help Obtained: None
 * I confirm that the above list of sources is complete AND that I
 * have not talked to anyone else (e.g., CSC 207 students) about 
 * the solution to this problem.
 */
public class BillBox {

    /* private data fields  */
	private int bills;
	
	//0 argument constructor
    public BillBox() {
    	bills = 0;
    }
    
    //depositBill
    //increments bill count
    public void depositBill() {
    	bills ++;
    }

    /* 
     * TODO: Define a method that resets the deposited bill in the current transaction
     */
    //resetBills
    //sets bill count to 0
    public void resetBills() {
    	bills = 0;
    }

    /*
     * TODO: Define a method that returns the deposited bills
     * @return the number of recently deposited bills 
     */
    //getCurrentBills
    //returns the count of bills
    public int getCurrentBills() {
    	return bills;
    }


}