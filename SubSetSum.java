package com.program.recursion;

/*
 * Subset sum problem is to find subset of elements that are selected from a given set whose sum adds up to a given number K. 
 * We are considering the set contains non-negative values. 
 * It is assumed that the input set is unique (no duplicates are presented).
 */
public class SubSetSum {
	
	public static void subSetSum(int []subSet, int []input, int k){
		if (isEmpty(input)) {
			printSubSet(subSet, k);
		}else{
			//add to subset, remove from input, recur
			subSetSum(addToSubSet(subSet, input[0]), removeFromInput(input), k);
			//donot add to subset, remove from input, recur
			subSetSum(subSet, removeFromInput(input), k);
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


	private static void printSubSet(int[] subSet, int k) {
		int sum=0;
		for(int i=0; i<subSet.length; i++){
			sum += subSet[i];
			//System.out.print("-"+subSet[i]);
		}
		if (sum == k) {// print the subset
			for(int i=0; i<subSet.length; i++){
				System.out.print("-"+subSet[i]);
			}
			System.out.println();
		}
		
	}

	private static boolean isEmpty(int[] input) {
		return input.length ==0;
	}
	
	public static void main(String[] args) {
		int input[]={3,4,2,5,1};
		int subSet[]={};
		subSetSum(subSet, input, 7);
	}
	
}
