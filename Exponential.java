package com.program.recursion;

/*
 * FUNCTIONAL RECURSION :
 * 	BASE CASE : STOP/ EXIT
 * 	RECURSIVE CASE : Results will be combined, make calls to itself, must advance towards base case otherwise it will be infinite
 */

public class Exponential {
	
	/*
	 * 10^5 = 10 * 10^4;
	 * 10^n = 10 * 10^n-1;
	 * 
	 */
	public static int raise(int base, int exp){
		
		if (exp < 0){
			System.out.println("Exp should be positive");
			return -1;
		}
		
		if (exp == 0) {// BASE CASE
			return 1;
		}else {
			return (base * raise(base, exp-1)); //RECURSIVE CASE
		}
	}
	
	/*
	 * More Efficient (for even base and for odd base multiply half by base)
	 * 10^6 = 10^6/2 * 10^6/2;
	 * 10^6 = 10^3 * 10*3 ;
	 * 10^n = 10^n/2 * 10^n/2;
	 * 
	 * It saves time by half;
	 */
	public static int raiseEfficient(int base, int exp){
		
		if (exp == 0){
			return 1;
		}else{
			int half = raiseEfficient(base, exp/2);
			if (exp % 2 == 0){
				return half * half;
			}else{
				return base * half * half;
			}
		}
	}
	
	public static void main(String[] args) {
		//System.out.println("--"+raise(2,-6)+"--");
		System.out.println("-- Effi--"+raiseEfficient(2, 6));
	}

}
