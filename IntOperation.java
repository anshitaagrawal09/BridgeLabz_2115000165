import java.util.Scanner;
public class IntOperation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the value of a: ");
        int a = input.nextInt();
        System.out.print("Enter the value of b: ");
        int b = input.nextInt();
        System.out.print("Enter the value of c: ");
        int c = input.nextInt();
        int result1 = a + b * c;  
        int result2 = a * b + c; 
        int result3 = c + a / b;  
        int result4 = a % b + c;   
        System.out.println("The results of Int Operations are:");
        System.out.println("a + b * c = " + result1);
        System.out.println("a * b + c = " + result2);
        System.out.println("c + a / b = " + result3);
        System.out.println("a % b + c = " + result4);
        input.close();
    }
}

