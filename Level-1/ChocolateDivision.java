import java.util.Scanner;
public class ChocolateDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of chocolates: ");
        int numberOfChocolates = scanner.nextInt();
        System.out.print("Enter the number of children: ");
        int numberOfChildren = scanner.nextInt();
        int[] result = findChocolatesForChildren(numberOfChocolates, numberOfChildren);
        System.out.println("Each child will get " + result[0] + " chocolates.");
        System.out.println("The remaining chocolates are " + result[1] + ".");
    }
    public static int[] findChocolatesForChildren(int numberOfChocolates, int numberOfChildren) {
        int chocolatesPerChild = numberOfChocolates / numberOfChildren;
        int remainingChocolates = numberOfChocolates % numberOfChildren;
        return new int[]{chocolatesPerChild, remainingChocolates};
    }
}

