package com.program.recursion;

public class IsPalindrome {
	
	/*
	 * Recursion Case :
	 * 	First and Last letter match and interior is the palindrome.
	 * 
	 * Base Case :
	 * 	Empty String or single letter string is a palindrome.
	 */
	public static boolean isPalindrome(String s){
		
		if (s == null){
			return false;
		}
		
		if (s.length() <= 1) { //BASE CASE
			return true;
		}
		return (s.charAt(0) == s.charAt(s.length()-1)) && isPalindrome(s.substring(1, s.length()-1)); //Recursion Case
	}
	
	public static void main(String[] args) {
		String s = "madam";
		System.out.println("Result -- "+isPalindrome(s));
	}
}
