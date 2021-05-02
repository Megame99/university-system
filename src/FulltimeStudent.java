/*
 * Assessment: Lab 06
 * Student Name: Megan Machkouri
 * Due Date: March 12th 2021
 * Description: A sublass class of our program, inherits all student methods and fields, as well as Person methods. It contains 1 additional fields;
 * double tuitionfees IT inherits two void methods, and invokes the
 * super class method for both methods. It also provides added functionality unique to FullTimeStudent Objects for both inherited methods.
 * It contains two abstract methods.
 * Professor Name: James Mwangi
 */
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The purpose of this class is to represent a Fulltime object. This class extends 
 * Student class, and inherits all methods and fields. It invokes superclass methods, but
 * also provides additional unique functionality. It contains one unique field; tuitionfees. 
 * @author megan
 * @version 1.0
 * @since 1.8
 * 
 */

public class FulltimeStudent extends Student{
	/** Total cost of tuition**/
	protected double tuitionfees;
	
	
	public FulltimeStudent() {
		// TODO Auto-generated constructor stub
	}
	/**
	 *This is an overriden method inherited from the Student Class. It invokes the superclass method and also reads and initializes 
	 *Full Time Student fields based of user input. This method also checks and handles exceptions.
	 *@param Nothing.
	 *@return Nothing. 
	 */
	//Inherited Method; invokes the super method and contains method body for reading user input for class fields
	@Override
	public void readInfo() {
		// TODO Auto-generated method stub
		super.readInfo();
		boolean bTrue =true;//Control Variable
		do {// Initialize Loop
			try {//Try Block
		Scanner input = new Scanner(System.in);
		System.out.print("Enter tuition fees: ");
		if(!input.hasNextDouble()) {// Error Check
			throw new InputMismatchException("Must be double");//Output Descriptive Error Message
		}else {
		tuitionfees = input.nextDouble();
		bTrue = false;// Break Loop
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
		String str7 = String.format("%15.2f|", tuitionfees);
		System.out.printf(str7);
		
		// TODO Auto-generated method stub
		
	}
	
	

}
