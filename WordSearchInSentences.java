public class WordSearchInSentences {
    public static String findSentenceWithWord(String[] sentences, String word) {
        // Iterate through the sentences
        for (String sentence : sentences) {
            if (sentence.toLowerCase().contains(word.toLowerCase())) { // Case-insensitive search
                return sentence; // Return the first matching sentence
            }
        }
        return "Not Found"; // If no match is found
    }
    public static void main(String[] args) {
        String[] sentences = {
            "The quick brown fox jumps over the lazy dog.",
            "Java is a powerful programming language.",
            "Machine learning is transforming the world.",
            "This is a sample sentence with example."
        };
        String searchWord = "java"; // Word to search (case-insensitive)
        String result = findSentenceWithWord(sentences, searchWord);
        System.out.println("Sentence containing the word '" + searchWord + "': " + result);
    }
}
