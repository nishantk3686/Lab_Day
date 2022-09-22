package lab.day;
import java.sql.*;
import java.util.Scanner;
import static java.lang.System.*;
public class bankMain {

	public static void main(String[] args) throws Exception {
		
		Scanner PS=new Scanner(System.in);                    // Here we create Scanner object as PS
		bankDao dao=new bankDao();
		bankCustomer b1=new bankCustomer();
		out.println("\t\t\t\t------WELCOME TO SBI BANK--------");
		out.println("**Please Select Operation : \nPRESS :1 for New Opening New Account \nPRESS :2 for Login into Existing Account");
		int op=PS.nextInt();
		
		switch(op) {
		case 1->{
		                                                      // Here we perform operations related to create account
			out.println(" ---- Please enter your details to create NEW ACCOUNT---- ");
			out.print("Enter New Customer's Name : ");
			String cName=PS.next();                           // Here we read user's name from user 
			out.print("Create your  Password for Account : ");
			String cPwd=PS.next();                            // Here we read user's Password from user 
			out.print("Enter Cutstomer's PhoneNumber : ");
			String cPhone=PS.next();                          // Here we read user's Phone number  from user 
			out.print("Enter Account balance : ");
			int cAccbal=PS.nextInt();                         // Here we read user's Account balance from user 
			b1.cName=cName;
			b1.cPassword=cPwd;
			b1.cPhone=cPhone;
			b1.cAccBal=cAccbal;
			
			dao.connect();                                    // Here we connect our program from database
			int res=dao.registerCustomer(b1);
			if(res!=0) {
				out.println("\t\t\t-----Account Created successfully-----");
				out.println("\t\t\t-----PLEASE REMEMBER YOUR PASSWORD -----");
			}
			else {
				out.println("\t\t\t-----OOPS !!----- \nSomething  wrong, please tryagain");
			}
		}
		
		case 2->{
			                                                  // Here we perform operations related to Login 
			out.println("Please Enter Customer Details to Login");
			out.print("Enter Customer's Name : ");            // Here we read user's name from user for login
			String cName=PS.next();
			out.print("Enter Customer's Password : ");        // Here we read user's Password from user for login
			String cPwd=PS.next();
			
			dao.connect();                                    // Here we connect our program from database
			int res=dao.login(cName, cPwd);
			if(res==0) {                                      // Here we check user's entered details is correct or not related to login
				out.println("\t\t\t-----Wrong Username Or Password, PLEASE TRY AGAIN-----");
			}
			else if(res==-1) {
				out.println("\t\t\t----Account Not Found!! Please Create Your New Account-----");
			}
			else {                                           // Here we grant permission to the user for perform other transactions
				out.println("\t\t\t------Login Successfully------");
			                                                 // Here we are giving access to the user for withdraw or deposit
				int op2=0;
				while(op2<5) {
				out.println("**Please Select Operation : \nPRESS :1 To Withdraw Amount \nPRESS :2 For deposit Amount \nPRESS :3 for Check Your Balance \nPRESS :4 For change your Password \nPRESS :5 for Exit ");
				op2=PS.nextInt();
				switch(op2) {
				
				case 1->{
					                                         // Here we Perform withdraw operation 
					out.println("Enter Amount To Withdraw : ");
					int amt=PS.nextInt();
				    int res2=dao.withdraw(res, amt);
					if(res2<=0) {
						out.println("OOPSS...!! Something Went Wrong");
					}
					else {
						out.println("*Withdraw Done Successfully, Your Updated Balance is :"+res2);
						
					}
				}
				case 2->{
					                                         // Here we perform deposit operation
					System.out.println("Enter amount to deposit :");
					int amount=PS.nextInt();
					int res2=dao.deposit(res, amount);
					if(res2==-1) {
						System.out.println("\t\t\t------Something went wrong------");
					}
					else {
						System.out.println("*Deposit done, updated balance is : "+res2);
					}
				}
				
				case 3->{
					                                        // Here we check users balance 
					System.out.println("*Your Current Balance is : "+dao.checkBalance(res));
				}
				case 4->{
					                                       // Here we change user's Password 
					System.out.println("Enter your Old Password : ");
					String pwd=PS.next();
					System.out.println("Enter new password : ");
					String newpin=PS.next();
					int count=dao.passwordChange(res, pwd,newpin);

				if(count<=0)
				{
					System.out.println("\t\t\t------Password not matched------");
				}
				else {
					System.out.println("\t\t\t------password updated successfully------");
				}
				}
				
				}
				
			}
		}

	}

	} PS.close();     // Here we close Scanner object
	 
		}}
