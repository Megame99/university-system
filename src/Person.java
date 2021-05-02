/*
 * Assessment: Lab 06
 * Student Name: Megan Machkouri
 * Due Date: March 13th 2021
 * Description: The interface of  our program, it contains the foundation of our program, all classes implement Person interface. It does not contain any
 * instance variables since they would have to be declared as public static final, making them constants. This would not work for our program since class fields
 * need to be manipulated by user input. It also does not contain any constructors(illegal).It contains two public methods,
 * inherited by Student  classes; one for reading user input and one for displaying user input. 
 * Professor Name: James Mwangi
 */
/**
 * The purpose of this interface is to represent a Person object, it is the backbone of our program. Since it is an interface 
 * this class contains no fields, just two abstract void methods. Both methods will be implemented and overridden 
 * by mulitiple classes within this program. 
 * @author megan
 * @version 1.0
 * @since 1.8
 * 
 */
public interface Person {
	void readInfo(); // No method body
	void printInfo();// No method body
	
}
