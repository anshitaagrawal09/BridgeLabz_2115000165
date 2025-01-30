public class RemoveCharacter {
    public static String removeCharacter(String str, char ch) {
        char[] chars = new char[str.length()];
        int index = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ch) {
                chars[index] = str.charAt(i);
                index++;
            }
        }
        String result = "";
        for (int i = 0; i < index; i++) {
            result += chars[i];
        }
        return result;
    }
    public static void main(String[] args) {
        String input = "Hello World";
        char charToRemove = 'l';
        String output = removeCharacter(input, charToRemove);
        System.out.println("Modified String: " + output);
    }
}

