
import java.util.Scanner;
public class EmployeeBonusCalculator {
    public static void main(String[] args) {
        final int NUM_EMPLOYEES = 10;
        double[] salaries = new double[NUM_EMPLOYEES];
        double[] yearsOfService = new double[NUM_EMPLOYEES];
        double[] bonuses = new double[NUM_EMPLOYEES];
        double[] newSalaries = new double[NUM_EMPLOYEES];
        double totalOldSalary = 0, totalBonus = 0, totalNewSalary = 0;
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < NUM_EMPLOYEES; i++) {
            while (true) {
                try {
                    System.out.print("Enter salary for employee " + (i + 1) + ": ");
                    double salary = Double.parseDouble(scanner.nextLine());
                    System.out.print("Enter years of service for employee " + (i + 1) + ": ");
                    double years = Double.parseDouble(scanner.nextLine());
                    if (salary <= 0 || years < 0) {
                        System.out.println("Invalid input. Please enter positive numbers.");
                        continue;
                    }
                    salaries[i] = salary;
                    yearsOfService[i] = years;
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter numeric values.");
                }
            }
        }
        for (int i = 0; i < NUM_EMPLOYEES; i++) {
            double bonusRate = yearsOfService[i] > 5 ? 0.05 : 0.02;
            bonuses[i] = salaries[i] * bonusRate;
            newSalaries[i] = salaries[i] + bonuses[i];
            totalOldSalary += salaries[i];
            totalBonus += bonuses[i];
            totalNewSalary += newSalaries[i];
        }
        System.out.println("\n--- Employee Bonus Details ---");
        for (int i = 0; i < NUM_EMPLOYEES; i++) {
            System.out.printf("Employee %d: Old Salary = %.2f, Bonus = %.2f, New Salary = %.2f%n", (i + 1), salaries[i], bonuses[i], newSalaries[i]);
        }
        System.out.println("\n--- Total Summary ---");
        System.out.printf("Total Old Salary: %.2f%n", totalOldSalary);
        System.out.printf("Total Bonus Payout: %.2f%n", totalBonus);
        System.out.printf("Total New Salary: %.2f%n", totalNewSalary);
        scanner.close();
    }

}
