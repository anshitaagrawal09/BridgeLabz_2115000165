public class SubstringOccurrences{
    public static int countSubstringOccurrences(String str, String substring) {
        int count = 0;
        int strLength = str.length();
        int subLength = substring.length();
        for (int i = 0; i <= strLength - subLength; i++) {
            boolean match = true;
            for (int j = 0; j < subLength; j++) {
                if (str.charAt(i + j) != substring.charAt(j)) {
                    match = false;
                    break;
                }
            }
            if (match) {
                count++;
            }
        }      
        return count;
    }
    public static void main(String[] args) {
        String str = "ababcabcabc";
        String substring = "abc";
        int occurrences = countSubstringOccurrences(str, substring);
        System.out.println("The substring '" + substring + "' occurs " + occurrences + " times.");
    }
}
