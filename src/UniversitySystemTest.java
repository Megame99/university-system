/*
 * Assessment: Lab 06
 * Student Name: Megan Machkouri
 * Due Date: March 12th 2021
 * Description:  A driver class for our Java Program used to test for testing and implementing program.
 * Professor Name: James Mwangi
 */
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * The purpose of this class is to allow for testing and implementation of our project's classes and methods. It employs a do while loop 
 * to output a menu and read user input.
 * @author megan
 * @version 1.0
 * @since 1.8
 * 
 */
public class UniversitySystemTest {

	public static void main(String[] args) {
		String name = null;
		int size = 0;
		boolean yes = true; // Control Variable
		
	do {
	
		try {//Try Block
		//creating an instance for Scanner class
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the name of University: ");
		if(input.hasNextDouble()||input.hasNextInt()) {// Input Mismatch Check
			throw new InputMismatchException("Must be string");// Descriptive Error Message
		} else {//User prompt
		name = input.nextLine();//initializing name parameter to input
		System.out.print("Enter number of students: ");//User prompt
		if(input.hasNextInt()) {
			size = input.nextInt();
			if(size <= 0)
				throw new NegativeArraySizeException("Must be greater than 0");// Descriptive Error Message
			else
				yes = false;
		} else
			throw new InputMismatchException("Must be integer.");
			
			}
		}
		catch(InputMismatchException im) {// Catch Block
			System.err.println("Input Mismatch Exception. " + im.getMessage());
			
		} 
		catch(NegativeArraySizeException ae) {// Catch Block
			System.err.println("Negative Array Size Exception. " + ae.getMessage());
			
		} 
		
	} while (yes);// Control Variable
		//creating University object for University class with name/n parameter 
		University c1 = new University(name,size);
		
		//invoking readStudentDetails method(for reading user input)
		c1.ReadStudentDetails();
		//invoking printTitle method
		//c1.printTitle();
		//invoking PrintStudentDetails method(for displaying user input)
		//c1.PrintStudentDetails();
		
		
	}

}
