
import java.util.Random;
public class ZaraBonusCalculator {
    public static double[][] determineSalaryAndService(int numEmployees) {
        Random random = new Random();
        double[][] salaryAndService = new double[numEmployees][2];
        for (int i = 0; i < numEmployees; i++) {
            salaryAndService[i][0] = 10000 + random.nextInt(90000);
            salaryAndService[i][1] = 1 + random.nextInt(20);
        }
        return salaryAndService;
    }
    public static double[][] calculateBonusAndNewSalary(double[][] salaryAndService) {
        double[][] newSalaryAndBonus = new double[salaryAndService.length][3];
        for (int i = 0; i < salaryAndService.length; i++) {
            double oldSalary = salaryAndService[i][0];
            double yearsOfService = salaryAndService[i][1];
            double bonus = 0;
            if (yearsOfService > 5) {
                bonus = oldSalary * 0.05;
            } else {
                bonus = oldSalary * 0.02;
            }
            double newSalary = oldSalary + bonus;
            newSalaryAndBonus[i][0] = oldSalary;
            newSalaryAndBonus[i][1] = bonus;
            newSalaryAndBonus[i][2] = newSalary;
        }
        return newSalaryAndBonus;
    }
    public static void displayResults(double[][] salaryAndService, double[][] newSalaryAndBonus) {
        double totalOldSalary = 0;
        double totalNewSalary = 0;
        double totalBonus = 0;
        System.out.println("Employee No | Old Salary | Years of Service | Bonus | New Salary");
        System.out.println("---------------------------------------------------------------");
        for (int i = 0; i < salaryAndService.length; i++) {
            double oldSalary = newSalaryAndBonus[i][0];
            double bonus = newSalaryAndBonus[i][1];
            double newSalary = newSalaryAndBonus[i][2];
            totalOldSalary += oldSalary;
            totalBonus += bonus;
            totalNewSalary += newSalary;
            System.out.printf("%d | %.2f | %.0f | %.2f | %.2f\n", (i + 1), oldSalary, salaryAndService[i][1], bonus, newSalary);
        }
        System.out.println("---------------------------------------------------------------");
        System.out.printf("Total Old Salary: %.2f\n", totalOldSalary);
        System.out.printf("Total New Salary: %.2f\n", totalNewSalary);
        System.out.printf("Total Bonus: %.2f\n", totalBonus);
    }
    public static void main(String[] args) {
        int numEmployees = 10;
        double[][] salaryAndService = determineSalaryAndService(numEmployees);
        double[][] newSalaryAndBonus = calculateBonusAndNewSalary(salaryAndService);
        displayResults(salaryAndService, newSalaryAndBonus);
    }
}

