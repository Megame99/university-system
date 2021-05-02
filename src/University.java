/*
 * Assessment: Lab 06
 * Student Name: Megan Machkouri
 * Due Date: March 13th 2021
 * Description:  A Java class that is used to initialize and instantiate an array of Students. Constructor is parameterized
 * and is employed to set the size of the Students array and the name of the Univeristy. 
 * This class contains 3 public void methods, one for reading User Input and the others for printing input in table format.
 * Professor Name: James Mwangi
 */
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * The purpose of this class is to represent a University Object. This class contains three private fields; an ArrayList of Student Objects and
 * name. This class serves to initialize an ArrayList of Student Object and intializes fields according to user input. This class is also capable 
 * of reading, testing and printing user input. 
 * @author megan
 * @version 1.0
 * @since 1.8
 * 
 */

public class University {
	/** The Name of The Store**/
	private String name;
	//private Student[] students;// Array of Student Objects
	/** Store's List of Employees **/
	private ArrayList<Student> students2 = new ArrayList<Student>();
	/** Loop Counter Variable **/
	private int i = 0;//loop counter variable (tracks array size)
	//Parameterized Constructor, initializes array size and name
	
	/**
	 * @param name
	 * @param size
	 */
	public University(String name, int size) {
		this.students2.ensureCapacity(size);
		this.name = name;
	}
	/**
	 *This is a method that prints a menu options list to the user. It takes user input and utilizes a selection structure, to invoke
	 *the selected option. It makes calls to various methods within the class, and it also initializes Fulltime or Parttime Objects and
	 *adds them to the Student ArrayList.
	 *@param Nothing.
	 *@return Nothing. 
	 */
	//Method for reading user input and initializing student object(s)
	public void ReadStudentDetails() {
		boolean shouldContinue = true; //loop control variable

		while(shouldContinue) {
			try {// Control Loop
				//creating an instance for Scanner class
				Scanner input = new Scanner(System.in);
				// Print MEnu Options
				System.out.println("1. Register Students" );
				System.out.println("2. Display Students");
				System.out.println("3. Exit");
				System.out.println("Enter your choice: ");
				if(!input.hasNextInt()) {
					throw new InputMismatchException("Must be integer.");
				} else {
					var choice = input.nextInt();
					if (choice == 1) {
						System.out.println("1. Read from File");
						System.out.println("2. Read from the User");
						if(!input.hasNextInt()) {
							throw new InputMismatchException("Must be integer.");
						} else {
							var option = input.nextInt();
							if (option == 1) {
								String fulltime = "f";
								try { //Try Block
									input = new Scanner(Paths.get("C:\\students.txt")); 
								}
								catch(FileNotFoundException fe) { //Catch Block
									System.err.println("Error Opening File");
								}
								catch(IOException ioe) { //Catch Block
									System.err.println("IOE");
								}
								while (input.hasNext() && i <= students2.size()){
									if(input.next().equalsIgnoreCase(fulltime)) { //selection structure in order to select type of employee
										FulltimeStudent full = new FulltimeStudent();
										full.studentNumber = input.nextInt();
										full.firstName = input.next();
										full.lastName = input.next();
										full.emailID = input.next();
										full.phoneNumber = input.nextLong();
										full.programName = input.next();
										full.gpa = input.nextDouble();
										full.tuitionfees = input.nextDouble();
										students2.add(full);
										i++;
									}
									else {
										ParttimeStudent part = new ParttimeStudent();	
										part.studentNumber = input.nextInt();
										part.firstName = input.next();
										part.lastName = input.next();
										part.emailID = input.next();
										part.phoneNumber = input.nextLong();
										part.programName = input.next();
										part.gpa = input.nextDouble();
										part.courseFeesTotal = input.nextDouble();
										part.credits = input.nextDouble();
										students2.add(part);
										i++;
									}
								}
							}
							else if (option == 2) {
								System.out.println("Enter Details of Student  :" );
								System.out.println("===============================");
								System.out.println("1. Full Time");
								System.out.println("2. Part Time");
								System.out.print("Enter Student Type: ");
								var choice2 = input.nextInt();
								if(choice2 == 1) { //selection structure in order to select type of student
									FulltimeStudent full2 = new FulltimeStudent();
									full2.readInfo();
									students2.add(full2);
									i++;
								} else if(choice2 ==2) {
									ParttimeStudent part2 = new ParttimeStudent();
									part2.readInfo();
									students2.add(part2);
									i++;
								}else { // Resets loop and displays error message if value is out of acceptable range
									System.out.println("Wrong Student Type. Try again!");
									
									//continue;
								}
							}
							else {
								System.out.println("Invalid Option. Please Try Again!");
								continue;
							}
						}
					}
					else if (choice == 2) {
						if(i > 0) {
							printTitle();
							PrintStudentDetails();
						
						}else {
							System.err.println("No elements in the array!");
							continue;
						}
					}
					else if (choice == 3) {
						shouldContinue = false;
						System.out.println("Goodbye...");
						input.close();
					}
					else { // Resets loop and displays error message if value is out of acceptable range
						System.out.println("Invalid Choice. Try again");
						continue;//Continue Loop
					}

				}
			}
			catch(InputMismatchException im) { // Catch Block
				System.err.println("Input Mismatch Exception. " + im.getMessage()); //Error Message

			}
	}
	}
	/**
	 *This is a method that prints a formatted string of a table header. 
	 *@param Nothing.
	 *@return Nothing. 
	 */
	public void printTitle() {
		System.out.println(this.name + " - List Of Students");
		System.out.println("**********************************************");
		String str1 = String.format("%10s|", "Program");
		String str2 = String.format("%15s|", "Student#");
		String str3 = String.format("%20s|", "Name");
		String str4 = String.format("%20s|", "Email");
		String str5 = String.format("%15s|", "Phone");
		String str6 = String.format("%10s|", "GPA");
		String str7 = String.format("%15s|", "Fees");
		String str8 = String.format("%15s|", "Credits");
		
		System.out.printf(str1 + str2 + str3 + str4 + str5 + str6 + str7 + str8);
		System.out.println();
	}
	/**
	 *This is a method that iterates over an Student Array and prints a formatted string 
	 *of the instance variables of each Student Object within the ArrayList.
	 *@param Nothing.
	 *@return Nothing. 
	 */
	// Method for printing student report
	public void PrintStudentDetails() {//Iterating Student array
		for(int j = 0; j < students2.size(); j++) {//Iterating Employee array
			students2.get(j).printInfo();// Invoking print method on Employee object(s)
			System.out.println();
		}
	}

	
}
