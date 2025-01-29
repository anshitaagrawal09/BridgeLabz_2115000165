public class ToggleCase {
    public static void main(String[] args) {
        String input = "Hello World!";
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (Character.isLowerCase(ch)) {
                result.append(Character.toUpperCase(ch));
            } else if (Character.isUpperCase(ch)) {
                result.append(Character.toLowerCase(ch));
            } else {
                result.append(ch);
            }
        }
        System.out.println("Original: " + input);
        System.out.println("Toggled: " + result.toString());
    }
