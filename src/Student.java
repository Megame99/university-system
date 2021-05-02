/*
 * Assessment: Lab 06
 * Student Name: Megan Machkouri
 * Due Date: March 13th 2021
 * Description: The parent class of our program, it contains the foundation of our program. It contains 9 fields; String firstName,
 * String lastName, String emailID, long phoneNumber, int studentNumber, String programName and double gpa. These fields are inherited by 
 * all Student Objects. The constructor is parameterized and initializes all fields. 
 * It contains two public methods, inherited by Person interface; one for reading user input and one for displaying user input. IT also contains 
 * two private void  methods which are invoked within the class in order to calculate GPA.
 * Professor Name: James Mwangi
 */
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * The superclass of our program, this class contains the foundation of our program. The purpose of this class is to represent a Student object.
 * This class will be inherited by other classes within our program.  It contains two public methods
 * which will be inherited and overridden by all classes that extend this program. It also contains two private methods which are invoked within 
 * the class for calculating GPA and reading marks.It contains 8 protected fields and a parametrized constructor.
 * @author megan
 * @version 1.0
 * @since 1.8
 * 
 */
public class Student implements Person{
	/** A student's first name. **/
	protected String firstName;
	/** A student's last name. **/
	protected String lastName;
	/** A student's email address. **/
	protected String emailID;
	/** A student's phone number. **/
	protected long phoneNumber;
	/** A student's student number. **/
	protected int studentNumber;
	/** A student's program name. **/
	protected String programName;
	/** A student's average GPA. **/
	protected double gpa;
	/** An array of a student's marks. **/
	protected double gpaA[];
	
	public Student() {
		
	}
	/**
	 *This method reads user inputs and initializes Student Fields according to input. This method also checks and handles 
	 *exceptions.
	 *@param nothing
	 *@return Nothing. 
	 */
	//Inherited Method; contains method body for reading user input 
	@Override
	public void readInfo() {
		boolean bTrue =true;//Control Variable
		do {// Initialize Loop
			try {//Try Block
				Scanner input = new Scanner(System.in);
				System.out.print("Enter program name: ");
				if(input.hasNextDouble()||input.hasNextInt()) {// Error Check
					throw new InputMismatchException("Must be string");//Output Descriptive Error Message
				} else {
					programName = input.nextLine();
					System.out.print("Enter student number: ");
					if(!input.hasNextInt()) {// Error Check
						throw new InputMismatchException("Must be integer");//Output Descriptive Error Message
					}else {
						studentNumber = input.nextInt();
						input.nextLine();
						System.out.print("Enter first name: ");
						if(input.hasNextDouble()||input.hasNextInt()) {// Error Check
							throw new InputMismatchException("Must be string");//Output Descriptive Error Message
						}else {
							firstName = input.nextLine();
							System.out.print("Enter last name: ");
							if(input.hasNextDouble()||input.hasNextInt()) {// Error Check
								throw new InputMismatchException("Must be string");//Output Descriptive Error Message
							}else {
								lastName = input.nextLine();
								System.out.print("Enter email: ");
								if(input.hasNextDouble()||input.hasNextInt()) {// Error Check
									throw new InputMismatchException("Must be string");//Output Descriptive Error Message
								}else {
									emailID = input.nextLine();
									System.out.print("Enter phone: ");
									if(!input.hasNextLong()) {// Error Check
										throw new InputMismatchException("Must be long");//Output Descriptive Error Message
									}else {
										phoneNumber = input.nextLong();
										bTrue = false;// Break Loop
									}
								}
							}
						}
					}
				}
			}
			catch(InputMismatchException im) {// Catch Block
				System.err.println("Input Mismatch Exception. " + im.getMessage());//Error Message
				//input.reset();// Reset Scanner
			}

		} while (bTrue);// Control Variable
		readMarks();
		calculateGPA(gpaA);
	}

	/**
	 *This is an overriden method inherited from the Person Interface. It prints a formatted output 
	 *of all Student class fields.
	 *@param Nothing.
	 *@return Nothing. 
	 */
	//Inherited Method; contains method body for printing user input 
	@Override
	public void printInfo() {
		String str1 = String.format("%10s|", programName);
		String str2= String.format("%15d|", studentNumber);
		String str3 = String.format("%20s|", firstName+ " " + lastName);
		String str4 = String.format("%20s|", emailID);
		String str5 = String.format("%15d|", phoneNumber);
		String str6 = String.format("%10.1f|", gpa);
		//AlgoSystem.out.println("\n");
		System.out.printf(str1 + str2 + str3 + str4 + str5 + str6); //Formated String Output
	
	}
	/**
	 *This is an private method that will be invoked within the Student class. It receives an array of marks, and employs a selection
	 *structure in order to calculate average GPA.
	 *@param double array
	 *@return void 
	 */
	//Private Method; invoked in printStudentDetails method for calculating GPA
	private void calculateGPA(double[] arr) {
		double sum = 0;
		double mark = 0;
		for (int i = 0; i < arr.length; i++) { // Control Loop
			double mark1 = arr[i];
			sum = sum + mark1;
	}
		double average = sum/arr.length+1;
		//Decision structure, invokes if clause in order to correctly assign GPA based on average provided
		if (average >= 93 && average <= 100) {
			this.gpa = 4.0;
		}
		else if (average >= 90 && average < 93) {
			gpa = 3.7;
		}
		else if (average >= 87 && average < 90) {
			gpa = 3.3;
		}
		else if (average >= 83 && average < 87) {			
			gpa = 3.0;
		}
		else if (average >= 80 && average < 83) {			
			gpa = 2.7;
		}
		else if (average >= 77 && average < 80) {			
			gpa = 2.3;
		}
		else if (average >= 73 && average < 77) {			
			gpa = 2.0;
		}
		else if (average >= 70 && average < 73) {			
			gpa = 1.7;
		}
		else if (average >= 67 && average < 70) {			
			gpa = 1.3;
		}
		else if (average >= 65 && average < 67) {			
			gpa = 1.0;
		}
		else { // this else belongs to the if labeled with "last if"
			gpa = 0.0 ;
		}	
	}
	
	/**
	 *This is an private method that will be invoked within the Student class. This method reads user input and employs a for loop
	 *in order to iterate and assign user input into an array of marks. This method also checks and handles exceptions.
	 *
	 *@param Nothing.
	 *@return Nothing. 
	 */
	//Private Method; invoked in printStudentDetails method for reading marks
	private void readMarks() {
		boolean bTrue =true;//Control Variable
		do {// Initialize Loop
			try {//Try Block
				Scanner input = new Scanner(System.in);
				System.out.print("Enter number of courses: ");//User prompt
				if(!input.hasNextInt()) {// Error Check
					throw new InputMismatchException("Must be integer");//Output Descriptive Error Message
				}else {
					int courses = input.nextInt();
					if (courses <= 0)
						throw new NegativeArraySizeException("Must be greater than 0");// Descriptive Error Message
					else {
						this.gpaA = new double[courses];
						for (int i = 0; i < gpaA.length; i++) { // Control Loop
							System.out.print("Enter mark "+(i+1)+": ");//User prompt
							if(!input.hasNextInt()) {// Error Check
								i--;
								throw new InputMismatchException("Must be integer");//Output Descriptive Error Message	
							}else {
								double mark2 = input.nextInt();
								gpaA[i] = mark2; //Initializing array with value
								bTrue = false;// Break Loop
							}
						}
					}
				}
			}
			catch(InputMismatchException im) {// Catch Block
				System.err.println("Input Mismatch Exception. " + im.getMessage());//Error Message
				//input.reset();// Reset Scanner
			}
			catch(NegativeArraySizeException ae) {// Catch Block
				System.err.println("Negative Array Size Exception. " + ae.getMessage());

			} 
		} while (bTrue);
	}

}
