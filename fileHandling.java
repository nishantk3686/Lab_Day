/* Java Program to Create a new text file and read the input from the user
 *   and save the input in the text file.
  	@author Nishant Kumar */


package lab.day;
import java.io.*;
import java.io.IOException;
import java.util.Scanner;

public class fileHandling { 			//Creating class

	public static void main(String[] args) throws IOException{
	
		Scanner sc = new Scanner(System.in);			//Scanner function
		
		File f1= new File("E:\\javaLabDay.txt");		//Initializing Origin of the file
		System.out.println("Enter Data into the file");	
		String data=sc.nextLine();						//Scanning data from the user to input in the file
		FileWriter fi=new FileWriter(f1);				//File Creating
		fi.write(data);
		System.out.println(" Your File Is Created Sucessfully");	//Acknowledgement of file creation
		fi.close();										// File is closed
		sc.close();										// Scan is closed
		
	}

}
