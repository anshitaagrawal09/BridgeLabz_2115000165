public class LongestWord {
    public static String findLongestWord(String sentence) {
        String longestWord = "";
        String currentWord = "";
        for (int i = 0; i < sentence.length(); i++) {
            char currentChar = sentence.charAt(i);
            if (currentChar == ' ' || i == sentence.length() - 1) {
                if (i == sentence.length() - 1 && currentChar != ' ') {
                    currentWord += currentChar;
                }
                if (currentWord.length() > longestWord.length()) {
                    longestWord = currentWord;
                }
                currentWord = "";
            } else {
                currentWord += currentChar;
            }
        }
        return longestWord;
    }
    public static void main(String[] args) {
        String sentence = "I love programming in Java";
        String longestWord = findLongestWord(sentence);
        System.out.println("Longest word in the sentence: " + longestWord);
    }
}

