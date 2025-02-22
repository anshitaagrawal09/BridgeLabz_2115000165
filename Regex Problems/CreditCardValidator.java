import java.util.regex.*;

public class CreditCardValidator {
    public static boolean isValidCreditCard(String cardNumber) {
        // Visa: Starts with 4 and has 16 digits
        String visaRegex = "^4\\d{15}$";
        // MasterCard: Starts with 5 and has 16 digits
        String masterCardRegex = "^5\\d{15}$";
        
        return cardNumber.matches(visaRegex) || cardNumber.matches(masterCardRegex);
    }

    public static void main(String[] args) {
        // Test cases
        String[] testCards = { "4111111111111111", "5105105105105100", "1234567812345678", "411111111111", "5999999999999999" };

        for (String card : testCards) {
            System.out.println(card + " -> " + (isValidCreditCard(card) ? "Valid" : "Invalid"));
        }
    }
}
