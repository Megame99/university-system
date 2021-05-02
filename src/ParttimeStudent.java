/*
 * Assessment: Lab 06
 * Student Name: Megan Machkouri
 * Due Date: March 12th 2021
 * Description: A sublass class of our program, inherits all student methods and fields, as well as Person methods. It contains 2 additional fields;
 * double courseFeesTotal and double credits. It inherits two void methods, and invokes the
 * super class method for both methods. It also provides added functionality unique to PartTimeStudent Objects for both inherited methods.
 * 
 * Professor Name: James Mwangi
 */
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The purpose of this class is to represent a Fulltime object. This class extends 
 * Student, and inherits all methods and fields. It invokes superclass methods, but
 * also provides additional unique functionality. It contains two unqiue field; credits and courseFeesTotal. 
 * @author megan
 * @version 1.0
 * @since 1.8
 * 
 */

public class ParttimeStudent extends Student{
	/** Total cost of courses**/
	protected double courseFeesTotal;
	/** Total credit hours**/
	protected double credits;
	
	public ParttimeStudent() {
		
	}
	
	/**
	 *This is an overriden method inherited from the Student Class. It invokes the superclass method and also reads and initializes 
	 *Part Time Student fields based of user input. This method also checks and handles exceptions.
	 *@param Nothing.
	 *@return Nothing. 
	 */
	//Inherited Method; invokes the super method and contains method body for reading user input for class fields
	@Override
	public void readInfo() {
		super.readInfo();
		boolean bTrue =true;//Control Variable
		do {// Initialize Loop
			try {//Try Block
		Scanner input = new Scanner(System.in); //creating an instance for Scanner class
		System.out.print("Enter total course fees: ");
		if(!input.hasNextDouble()) {// Error Check
			throw new InputMismatchException("Must be double");//Output Descriptive Error Message
		}else {
		courseFeesTotal = input.nextDouble();
		System.out.print("Enter credit hours: ");
		if(!input.hasNextDouble()) {// Error Check
			throw new InputMismatchException("Must be double");//Output Descriptive Error Message
		}else {
		credits = input.nextDouble();
		bTrue = false;// Break Loop
		}
		}
			}
		catch(InputMismatchException im) {// Catch Block
			System.err.println("Input Mismatch Exception. " + im.getMessage());//Error Message
			//input.reset();// Reset Scanner
		}
			} while (bTrue);
		
	}
	
	/**
	 *This is an overriden method inherited from the Student Class. It invokes the superclass method and also prints a formatteed ouput
	 *of all adittional class fields.
	 *@param Nothing.
	 *@return Nothing. 
	 */
	//Inherited Method; invokes the super method and contains method body for displaying user input for class fields
	@Override
	public void printInfo() {
		super.printInfo();
		String str7 = String.format("%15.2f|",courseFeesTotal);
		String str8 = String.format("%15.2f|", credits);
		System.out.printf(str7 + str8);
	}
}
