package implementation;

import static util.Constants.DOLLAR;
import static util.Constants.SPACE;
import static util.Constants.NUM_COINS;
import static util.Constants.denominations;

/**
 * @author ${Shreyas MN}
 * 
 */
public class CashRegImplementation {
	
	int[] coins = new int[NUM_COINS];
	String inputCase;
	int charge, currentSumTotal, change;
	
	public CashRegImplementation(int[] currentRegIn, int chargeIn, int amountIn){
		
		charge = chargeIn;
		currentSumTotal = amountIn;
		
		for(int i=0; i<coins.length; i++){
			coins[i] = currentRegIn[i];
		}
	}
	
	
	/**
	 * This method calls corresponding action according to the
	 * command line input using swicth case(Can use String since Java 7).
	 * 
	 * @param input args
	 * @return nothing
	 */
	public void CalculateDisplay(String[] args) {
		
		inputCase = args[0];
		
		switch(inputCase){
		   
		   case "show": show();
		   break;
		   
		   case "quit": quit();
		   break;
		   
		   case "put": put(args);
		   break;
		   
		   case "change": change(args[1]);
		   break;
		   
		   case "take": take(args);
		   break;
		   
		   default : 
			   System.out.println("Invalid Input. switch case");
		}
	}

	
	/**
	 * This method updates the current set of denominations and sumTotal
	 * 
	 * @param args
	 * @return nothing
	 */
	private void take(String[] args) {
		
		for(int i=0; i<coins.length; i++){
			coins[i] -= parse(args[i+1]);
		}
		
		currentSumTotal = 0;
		calculateSumTotal();
		print();
	}

	
	/**
	 * This method checks for the particular change in the existing
	 * set of denominations(coins) and updates the sumTotal accordingly
	 *  
	 * @param String
	 * @return nothing
	 */
	private void change(String strIn) {
	
	 int origChange = parse(strIn);
	 change = origChange;
	 int num;
		 
	     for(int i=0; i< coins.length; i++){
			 if(denominations[i] <= change){
				 num = change/denominations[i];
				 if(coins[i] >= num){
					 change = change - (num * denominations[i]);
					 coins[i] = coins[i] - num;
				}
			 }
		 }
	   
	     if(change == 0){
	    	 currentSumTotal -= origChange;
	    	 printDenominations();
	     }
	     else{
	    	 System.out.println("Sorry");
	     }
	}

	
	/**
	 * This method adds the denominations to the existing
	 * one's (More change being added)
	 * 
	 * @param args
	 * @return nothing
	 */
	private void put(String[] args) {
		
		for(int i=0; i<coins.length; i++){
			coins[i] += parse(args[i+1]);
		}	
		
		currentSumTotal = 0;
		calculateSumTotal();
		print();
	}

		
	/**
	 * This method Displays the current sumTotal of Denominations
	 * available and the each denominations count in the order of
	 * [20, 10, 5, 2, 1]
	 * 
	 * @return nothing
	 */
	private void show() {
		print();
	}
	
	
	/**
	 * Prints 'Bye' and makes an exit from the program
	 */
	private void quit() {
		System.out.println("Bye");
		System.exit(1);
	}
	

	/**
	 * @param string
	 * @return int
	 */
	private int parse(String stringInput) {
		return Integer.parseInt(stringInput);
	}
	
	
	/**
	 * Calculates the sumTotal according to the input and
	 * new Denominations
	 * @return nothing
	 */
	public void calculateSumTotal(){
	     for(int i=0; i< denominations.length; i++){
	    	 currentSumTotal += denominations[i] * coins[i];
	     }
	}
	
	
	/**
	 * Prints SumTotal and current set of Denominations
	 * @return nothing
	 */
	public void print(){
		printSumTotal();
		printDenominations();
	}

	
	/**
	 * Utility method prints only sumTotal
	 * @return nothing
	 */
	private void printSumTotal() {
		System.out.print(DOLLAR + currentSumTotal);
	}
	
	
	/**
	 * Utility method prints current set of Denominations
	 * @return nothing
	 */
	private void printDenominations() {
		for(int i=0; i< coins.length; i++){
			System.out.print(SPACE + coins[i]);
		}
	}
}
