import java.util.*;
public class AreaOfCircle{
    	public static void main(String[] args){
        	Scanner sc=new Scanner(System.in);
        	System.out.print("Enter the radius of the circle: ");
        	double radius=sc.nextDouble();
        	double area=Math.PI * Math.pow(radius, 2);
       		System.out.println("The area of the circle is: "+area);
       	}
}
