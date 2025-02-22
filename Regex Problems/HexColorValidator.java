import java.util.regex.*;

public class HexColorValidator {
    public static boolean isValidHexColor(String color) {
        String pattern = "^#([A-Fa-f0-9]{6})$";
        return color.matches(pattern);
    }

    public static void main(String[] args) {
        // Test cases
        String[] testCases = { "#FFA500", "#ff4500", "#123", "#GHIJKL", "#abcDEF", "#123456" };

        for (String color : testCases) {
            System.out.println(color + " → " + (isValidHexColor(color) ? "Valid" : "Invalid"));
        }
    }
}
