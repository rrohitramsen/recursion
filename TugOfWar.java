package com.program.recursion;
/*
 * Given a set of n integers, divide the set in two subsets of n/2 sizes each such that the difference of the sum of two subsets is as minimum as possible.
 * If n is even, then sizes of two subsets must be strictly n/2 and if n is odd, 
 * then size of one subset must be (n-1)/2 and size of other subset must be (n+1)/2.
 *	For example, let given set be {3, 4, 5, -3, 100, 1, 89, 54, 23, 20}, the size of set is 10. 
 *	Output for this set should be {4, 100, 1, 23, 20} and {3, 5, -3, 89, 54}. 
 *	Both output subsets are of size 5 and sum of elements in both subsets is same (148 and 148).
 *	Let us consider another example where n is odd. Let given set be {23, 45, -34, 12, 0, 98, -99, 4, 189, -1, 4}.
 * 	The output subsets should be {45, -34, 12, 98, -1} and {23, 0, -99, 4, 189, 4}. The sums of elements in two subsets are 120 and 121 respectively.
 * 	The following solution tries every possible subset of half size. If one subset of half size is formed, the remaining elements form the other subset. 
 * 	We initialize current set as empty and one by one build it. There are two possibilities for every element, either it is part of current set, 
 * 	or it is part of the remaining elements (other subset). We consider both possibilities for every element. 
 * 	When the size of current set becomes n/2, we check whether this solutions is better than the best solution available so far. 
 * 	If it is, then we update the best solution.
 */

public class TugOfWar {
	
	private static int length;
	
	public static void subSetSum(int []subSet, int []input) {
		if (isEmpty(input) || isHalf(subSet, input)) {
			printSubSet(subSet, input);
		}else {
			
			//add to subset, remove from input, recur
			subSetSum(addToSubSet(subSet, input[0]), removeFromInput(input));
			//donot add to subset, remove from input, recur
			subSetSum(subSet, removeFromInput(input));
			
		}
	}

	// remove first num from input and return new array
	private static int[] removeFromInput(int[] input) {
		int [] temp = new int[input.length-1];
		for(int i=1; i<input.length; i++){
			temp[i-1]=input[i];
		}
		return temp;
	}

	// append num at the end of new subset array and return
	private static int[] addToSubSet(int[] subSet, int num) {
		int temp[] = new int[subSet.length+1];
		int i;
		for (i=0; i< subSet.length; i++){
			temp[i] = subSet[i];
		}
		temp[i] = num;
		return temp;
	}


	private static void printSubSet(int[] subSet, int [] input) {
		
		if (subSet.length == length/2){
			System.out.print("SubSet ::");
			for(int i=0; i<subSet.length; i++){
				System.out.print("["+subSet[i]+"]");
			}
			System.out.println();
			System.out.print("Input ::");
			for(int i=0; i<input.length; i++){
				System.out.print("["+input[i]+"]");
			}
			System.out.println();
		}
		
	}
	
	private static boolean isEmpty(int[] input) {
		return input.length ==0;
	}

	private static boolean isHalf(int []subset , int[] input) {
		if ( (subset.length == length/2) && (input.length == length/2)) {// || (subset.length == input.length-1) ){
			return true;
		}
		return false;
		/*System.out.println("Subset Length = "+subset.length);
		System.out.println("Input Length = "+input.length);
		int inputSum=0;
		for(int i=0; i<input.length; i++){
			inputSum += input[i];
			//System.out.print("-"+subSet[i]);
		}
		
		int subSetSum=0;
		for(int i=0; i<subset.length; i++){
			subSetSum += subset[i];
			//System.out.print("-"+subSet[i]);
		}
		
		System.out.println("InputSum = "+inputSum+"-- Subset Sum ="+subSetSum);
		if (inputSum == subSetSum)
			return true;
		else
			return false;*/
	}
	
	public static void main(String[] args) {
		int input[] = {3, 4, 5, -3, 100, 1, 89, 54, 23, 20};
		length = input.length;
		int subSet[] = {};
		subSetSum(subSet, input);
	}
	
}
