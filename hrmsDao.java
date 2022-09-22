package lab.day;

import java.sql.*;

public class hrmsDao {

		Connection con=null;										// Here we connect our program with database
		public void connect()throws Exception{
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/HRMS","root","Nishant@87");
		}
		
		public int addEmployee(hrmsEmployee e1) throws Exception{
			String quary="insert into employee(eName,eDomain,eDesignation,eLocation,eSal,ePhone) values(?,?,?,?,?,?)";
			PreparedStatement pst=con.prepareStatement(quary);
			pst.setString(1,e1.eName);        			      	// Here we enter name of the employee at 1st column in database
			pst.setString(2, e1.eDomain);         				// Here we enter Domain of the employee at 2st column in database
			pst.setString(3, e1.eDesignation);          	  // Here we enter Designation of the employee at 3rd column in database
			pst.setString(4, e1.eLocation);             	 // Here we enter location of the employee at 4th column in database
			pst.setInt(5, e1.eSal);								// Here we enter Salary of the employee at 4th column in database
			pst.setString(6,e1.ePhoneNo);						// Here we enter Phone Number of the employee at 4th column in database
			
			int count=pst.executeUpdate();
			return count;
			
		}
		
		public int revEmployee(int eId) throws Exception{
			Statement stm = con.createStatement();
			ResultSet set = stm.executeQuery("select * from employee where eId="+eId);
			if(set.next()) {
			set.close();	
			Statement Deletestm = con.createStatement();
			Deletestm.executeUpdate("DELETE FROM employee WHERE eId="+eId);
			return 1;
				}
				else {
					return 0;
				}
		
		}

		public int empHike(int eId, int hike) throws Exception{
			
			Statement stm = con.createStatement();					// GETTING USER DETAIL THROUGH EMPLOYEE ID
			
			ResultSet set = stm.executeQuery("select * from employee where eId ="+eId);		// IF EMPLOYEE ID EXIST
			
			if(set.next()) {
				Statement hikeStm = con.createStatement();
				int salary = set.getInt(6);
				salary = salary+((salary*hike)/100);					// UPDATING USER ACCOUNT BALANCE
			
				hikeStm.executeUpdate("update employes set eSal = "+salary+" where eId ="+eId);
				return salary;
			}
			else 
				return 0;
			
		}	
		
		
		public int empHikeper() throws Exception{
			
			Statement stm = con.createStatement();
			
			// GETTING USER DETAIL THROUGH EMPLOYEE ID
			ResultSet set = stm.executeQuery("Select * from employee");
			// IF EMPLOYEE ID EXIST
			if(set.next()) {
				Statement hikeStm = con.createStatement();
				int salary = set.getInt(6);
				salary = salary+((salary*5)/100);
				// UPDATING USER ACCOUNT BALANCE
				hikeStm.executeUpdate("update employee set eSal=eSal+(eSal*5)/100");
				return salary;

			}
			else
				return -1;
		}








}
