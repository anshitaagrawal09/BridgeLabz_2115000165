public class ToggleCase {
    public static String toggleCase(String str) {
        char[] chars = new char[str.length()];        
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                chars[i] = (char) (ch + 32); // Convert uppercase to lowercase
            } else if (ch >= 'a' && ch <= 'z') {
                chars[i] = (char) (ch - 32); // Convert lowercase to uppercase
            } else {
                chars[i] = ch; // Keep non-alphabet characters unchanged
            }
        }       
        String result = "";
        for (char c : chars) {
            result += c; // Append each character to result string
        }      
        return result;
    }
    public static void main(String[] args) {
        String input = "HeLLo WoRLd123";
        String output = toggleCase(input);
        System.out.println("Toggled case: " + output);
    }
}

