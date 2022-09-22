package lab.day;
import java.util.Scanner;
import com.mysql.*;
import static java.lang.System.*;
public class hrmsMain {

	public static void main(String[] args) throws Exception {
		
		Scanner SC=new Scanner(System.in);
		hrmsDao dao=new hrmsDao();
		dao.connect();
		hrmsEmployee e1=new hrmsEmployee();
		out.println("\t\t ************ WELCOME ************ ");
		out.println("PRESS : 1 for Add New Employee \nPRESS : 2 for Delete an Employee \nPRESS : 3 For Salary Increment of an Employee \nPRESS : 4 For Adding 5% Bonus To All Employee: ");
		int ep=SC.nextInt();
		
		switch(ep) {
		case 1 ->  {
				
				out.println(" ---- Please enter your details to create NEW Employee---- ");
				out.print  ("Enter Employee Name :");
				e1.eName=SC.next();
				out.print("Enter Domain of The Employee");
				e1.eDomain=SC.next();
				out.print("Enter Desgnation of The Employee");
				e1.eDesignation=SC.next();
				out.print("Enter Location of The Employee");
				e1.eLocation=SC.next();
				out.print("Enter Salary of The Employee");
				e1.eSal=SC.nextInt();
				out.print("Enter Contact Number of The Employee");
				e1.ePhoneNo=SC.next();
				dao.connect();                                    // Here we connect our program from database
				int res=dao.addEmployee(e1);
				if(res!=0) {
				out.println("\t\t\t ********Employee Added successfully********");
				}
				else {
					out.println("\t\t\t-----OOPS !!----- \nSomething  wrong, please try again");
				}
				
				
		}
		case 2 -> {
						
			
			out.print("Enter Employee ID to Remove From DataBase:");
			int eId=SC.nextInt();
			                                 // Here we connect our program from database
			int res=dao.revEmployee(eId);
			if(res==1){
				out.println(" Employee Succesfully Deleted!!!!");
			}
			}
		
		case 3 -> {
			
			out.println("Enter Employee ID to Hike Salary");
			int eId=SC.nextInt();
			out.print  ("Enter Percentage to Hike :");
			int per=SC.nextInt();
			int reg=dao.empHike(eId,per);
			if(reg==1){
				out.println(" Employee Salery Updated Succesfully ");
			}
			else {
				out.println("\t\t\t-----OOPS !!----- \nSomething  wrong, please try again");
			}
				
			
		}
		case 4 -> {
			int reg=dao.empHikeper();
			out.println(" All Employee Bonus Updated Succesfully ");
		}
	}

	}
}

