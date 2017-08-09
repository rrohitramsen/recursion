package com.program.recursion;

public class Subsets {
	
	public static void subset(String subset, String input){
		
		if (input.equals("")) { //Base case
			System.out.println("--"+subset);
		}else{
			//add to subset, remove from input, recur
			subset(subset+input.charAt(0), input.substring(1));
			//Don't add to subset, remove from input, recur
			subset(subset, input.substring(1));
		}
	}
	
	public static void subset(String input) {
		if (input == null){
			System.out.println("Input cant be null");
		}else{
			subset("", input);
		}
	}
	
	public static void main(String[] args) {
		subset("abcd");
	}
}
