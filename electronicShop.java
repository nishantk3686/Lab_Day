/* Program to list out laptop under 30,000
 *  @Author Nishant Kumar
 */



package lab.day;

import java.util.ArrayList;						//Importing array list package

public class electronicShop {					//class

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		product p1=new product (1001,"Lenavo","Ideapad 5",72998,2021);  //products
		product p2=new product (1002,"HP","Spectre x360",179990,2022);
		product p3=new product (1003,"Apple","Mac Book Air",73890,2020);
		product p4=new product (1004,"Lenavo","Ideapad 3",24850,2021);
		product p5=new product (1005,"Dell","Inspiron",24890,2022);
		product p6=new product (1006,"Asus","VivoBook 15",23990,2022);
		product p7=new product (1007,"Acer","Aspire 7",28990,2022);
		product p8=new product (1008,"Realme","Book",29998,2021);
		
		ArrayList<product> p=new ArrayList<product>();						//arraylist
		
		p.add(p8);
		p.add(p7);
		p.add(p6);
		p.add(p5);
		p.add(p4);
		p.add(p3);
		p.add(p2);
		p.add(p1);
		
		p.stream().filter(pro->pro.pPrice<30000).					//Stream API filtering
		forEach(pro->{												//ForEach Loop
		System.out.println(pro.pBrand+" "+pro.pName+" For Rs. "+pro.pPrice+" Built in "+pro.pBuiltYear);});  //Printing the values
		
	
	}   
	

}
