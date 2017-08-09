package com.program.recursion;

public class Permutations {
	
	/*
	 * Base case : If input is completely copied into output
	 * 
	 * Recursion Case :
	 * 	Print combination of first character, the next...
	 *
	 */
	public static void permute(String combtn, String input) {
		if (input.equals("")){
			System.out.println("--"+combtn+"--");
		}else{
			for (int i=0; i<input.length(); i++){
				String nextCombtn = combtn + input.charAt(i);
				String remainInput = input.substring(0, i)+input.substring(i+1);
				permute(nextCombtn, remainInput);
			}
		}
	}
	
	public static void recPermute(String input){
		permute("", input);
	}
	
	public static void main(String[] args) {
		recPermute("abcd");
	}

}
