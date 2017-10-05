package driver;

import java.util.Scanner;

import implementation.CashRegImplementation;
import util.InputCommands;

/**
 * @author ${Shreyas MN}
 * 
 */
public class CashRegister {

	static String inputCase = null;
	static boolean checkforInput = false;
	
	public static void main(String[] argumnets) {
		Scanner sc;
		int charge = 14;
		int amount_received = 152;
		int[] currentRegister = {4, 2, 4, 8, 16};
		String[] args = null;
		
		CashRegister cashreg = new CashRegister();
		CashRegImplementation cashImpl=new CashRegImplementation(currentRegister, charge, amount_received);
		checkforInput = true;
		
		while(checkforInput){
		   checkforInput = false;
		   System.out.println("\n Please Enter the input arguments");
		   sc = new Scanner(System.in);
		   if(sc.hasNext()){
			   args = sc.nextLine().split(" ");
		   
		   if(args.length > 0){
			if(!cashreg.validateArguments(args)){
				System.err.println("INVALID INPUT(S). Exiting");
				System.exit(1);
			}			
		   
			inputCase = args[0];
			cashImpl.CalculateDisplay(args);
			args = null;
			checkforInput = true;
		   }
		 }
	   }
	}
	
	
	/**
	 * Validates the input arguments considering all input scenario's
	 * @param args
	 * @return boolean
	 */
	private boolean validateArguments(String[] args) {

		if(args.length < 1){
			System.err.println("Invalid Number of input Arguments");
		}
		
		else if(args.length == 1){
			if(args[0].equals(InputCommands.SHOW.getValue()) || args[0].equals(InputCommands.QUIT.getValue())){
				if(args[0].equals(InputCommands.SHOW.getValue())) inputCase = "SHOW";
				else if(args[0].equals(InputCommands.QUIT.getValue())) inputCase = "QUIT";
				return true;
			}
			return false;
		}
		
		else if(args.length == 2){
			if(args[0].equals(InputCommands.CHANGE.getValue()) && checkIfInteger(args[1])){
				inputCase = "CHANGE";
				return true;
			}
			return false;
		}
		
		else if(args.length == 6){
			boolean  result = true;
			if((args[0].equals(InputCommands.PUT.getValue()) || args[0].equals(InputCommands.TAKE.getValue()))){
				
				if(args[0].equals(InputCommands.PUT.getValue())) inputCase = "PUT";
				else if(args[0].equals(InputCommands.TAKE.getValue())) inputCase = "TAKE";
				
				for(int i=1; i< args.length; i++){
					result = result && checkIfInteger(args[i]); 
				}
			}
			return result;
		}
		
		else{
			System.err.println("Invalid Number of Input Arguments");
			return false;
		}
		return false;
	}

	/**
	 * Checks if the given String is valid Integer
	 * @param string
	 * @return boolean
	 */
	private boolean checkIfInteger(String string) {	
		try{
	        Integer.parseInt(string);
	        return true;
	    }catch (NumberFormatException ex)
	    {
	       System.err.println("INVALID INPUT. PLEASE ENTER VALID INPUT");
	       return false;
	    }
	}
}
