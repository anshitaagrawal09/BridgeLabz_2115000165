import java.util.regex.*;

public class LicensePlateValidator {
    public static boolean isValidLicensePlate(String plate) {
        String regex = "^[A-Z]{2}\\d{4}$";
        return plate.matches(regex);
    }

    public static void main(String[] args) {
        String[] testPlates = {"AB1234", "A12345", "XY5678", "abc1234", "AB12", "ZZ9999"};

        for (String plate : testPlates) {
            System.out.println(plate + " → " + (isValidLicensePlate(plate) ? "Valid" : "Invalid"));
        }
    }
}
