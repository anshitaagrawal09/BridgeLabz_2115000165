public class WordReplace {
    public static void main(String[] args) {
        String sentence = "I love programming in Java.";
        String wordToReplace = "Java";
        String replacementWord = "Python";        
        String modifiedSentence = replaceWord(sentence, wordToReplace, replacementWord);
        System.out.println("Modified Sentence: " + modifiedSentence);
    }
    public static String replaceWord(String sentence, String wordToReplace, String replacementWord) {
        return sentence.replace(wordToReplace, replacementWord);
    }
}

