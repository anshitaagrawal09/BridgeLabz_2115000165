
import java.util.Scanner;
public class FriendsComparison {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Amar's age: ");
        int amarAge = scanner.nextInt();
        System.out.print("Enter Amar's height (in cm): ");
        int amarHeight = scanner.nextInt();
        System.out.print("Enter Akbar's age: ");
        int akbarAge = scanner.nextInt();
        System.out.print("Enter Akbar's height (in cm): ");
        int akbarHeight = scanner.nextInt();
        System.out.print("Enter Anthony's age: ");
        int anthonyAge = scanner.nextInt();
        System.out.print("Enter Anthony's height (in cm): ");
        int anthonyHeight = scanner.nextInt();
        String youngest;
        if (amarAge <= akbarAge && amarAge <= anthonyAge) {
            youngest = "Amar";
        } else if (akbarAge <= amarAge && akbarAge <= anthonyAge) {
            youngest = "Akbar";
        } else {
            youngest = "Anthony";
        }
        String tallest;
        if (amarHeight >= akbarHeight && amarHeight >= anthonyHeight) {
            tallest = "Amar";
        } else if (akbarHeight >= amarHeight && akbarHeight >= anthonyHeight) {
            tallest = "Akbar";
        } else {
            tallest = "Anthony";
        }
        System.out.println("\n--- Results ---");
        System.out.println("The youngest friend is: " + youngest);
        System.out.println("The tallest friend is: " + tallest);
    }
}

