/* ********************************************************************/
/*  Name: Tran La (Teryl)											  */
/*  SID: 150353175													  */
/*  Course: JAC444NBB 											      */
/*  Professor Reza Khojasteh										  */
/*	Fall 2020														  */
/* ********************************************************************/

								//**** WORKSHOP 1 ****//


public class Stack {

	private char [] stack;
	private int topChar;
	private int stackSize; // not neccesaary

	//Constructor
	public Stack(int size) {
		stackSize = size; // not neccessary for java
		stack = new char[stackSize]; // just do stack = new char[stackSize] instead
		topChar = -1; // better to make topChar = -1 to make it more readable
	}

	//push function
	public void push(char str) {
		stack[++topChar] = str;
	}
	
	//pop function
	public char pop() {
		return stack[topChar--];
	}

	//check if empty
	public boolean isEmpty() {
		if (topChar == -1) { // if == 0 then when topChar is 0, it will not pop last char
			return true; // or just do return topChar == -1
		}
		else {
			return false;
		}
		
	}
	
}

