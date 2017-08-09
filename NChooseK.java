package com.program.recursion;

/*
 *  Given N things, how many different ways can you choose K of them?
 *	� e.g. given a dorm of 60 people, how many different groups of 4 
 *		people can go together to Flicks?
 *	� N-choose-K, written as C(n, k)
 *	n - total no of available persons, K - no of to be choose
 * 	For example out of n person Bob is one person, Now
 *	
 *	Recursion Case :
 *		Number of subsets that include Bob =  C(n-1, k-1)
 *  	Number of subsets that don't include Bob = C(n-1, k)
 *  
 *  Base Case :
 *  	No choices remain at all
 */

public class NChooseK {
	
	public int C(int n , int k){
		
		if (k==1 || k==n) { //base Case
			return 1;
		}else{
			return C(n-1, k) + C(n-1, k-1); //recursion case;
		}
	}
}
