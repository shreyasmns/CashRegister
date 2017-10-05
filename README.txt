
README FILE

Cash Regitser Implementation:

Thursday, October 5th, 2017.
Author: Shreyas MN
e-mail: shreyasmnagaraj@gmail.com

PURPOSE: To implement Cash Register System in Java

FILES:
		------driver:
				  --CashRegister.java [Base Class]
		------Implementation:
				  --CashRegisterImplementation.java
	        ------Logger:
				  --Logger.java (Not used, since printing only output to console)
		------util:
				  --Constants.java
				  --InputCommands.java[Enum]
				  
				  
SAMPLE OUTPUT:
=================================================

 Please Enter the input arguments
show
$152 4 2 4 8 16
 Please Enter the input arguments
put 0 0 0 4 0
$160 4 2 4 12 16
 Please Enter the input arguments
take 0 0 0 4 0
$152 4 2 4 8 16
 Please Enter the input arguments
change 52
 2 1 4 7 16
 Please Enter the input arguments
show
$100 2 1 4 7 16
 Please Enter the input arguments
quit
Bye

==================================================

			
Note : Logger has not been used since only output is expected and being printed to console.
	   Otherwise, logger level can be set and can be plugged in easily.
		
Assumptions: Have assumed the initial set of coins available and the initial sum(amount) available.


=====================================================================================================
