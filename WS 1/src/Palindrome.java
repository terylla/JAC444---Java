/* ********************************************************************/
/*  Name: Tran La (Teryl)											  */
/*  SID: 150353175													  */
/*  Course: JAC444NBB 											      */
/*  Professor Reza Khojasteh										  */
/*	Fall 2020														  */
/* ********************************************************************/

								//**** WORKSHOP 1 ****//


import java.util.Scanner;

public class Palindrome {

		// maybe break up into main vs isPalindrome
	public static void main(String[] args) {
		
		//Prompt user for input
		String inp;
		System.out.print("Enter something: ");
		Scanner input = new Scanner(System.in); //Scanner class allows input from console
		inp = input.nextLine(); 
		input.close(); //avoid recursive
		
		if (inp.length() > 0) {
			
			//This is to hold the input
			Stack stack = new Stack(inp.length());
			
			//push until no string left in inp into stack
			for (int i = 0; i < inp.length(); i++) {
				stack.push(inp.charAt(i)); //charAT returns char at the specified index of string	
			}
			
			//pop string from stack (holding strings pushed from inp) into reverseInp
			String reverseInp = ""; // null means variable points to nothing
			while (!stack.isEmpty()) { 
				reverseInp += stack.pop();
			}
			/* Another method */
			// pop 1 at a time, if match then keep going, or not go back
			// check if it goes all the way to the end, then it's palindrome and vice versa

			//Output
			if (reverseInp.equals(inp)) {
				System.out.print("It is a palindrome.");
			} else {
				System.out.print("It is not a palindrome.");
			}
		}
	}
}
