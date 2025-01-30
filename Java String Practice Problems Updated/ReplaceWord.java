public class ReplaceWord {
    public static String replaceWord(String sentence, String target, String replacement) {
        char[] sentenceArr = new char[sentence.length() * 2]; 
        int index = 0;        
        for (int i = 0; i < sentence.length(); i++) {
            boolean match = true;
            
            for (int j = 0; j < target.length(); j++) {
                if (i + j >= sentence.length() || sentence.charAt(i + j) != target.charAt(j)) {
                    match = false;
                    break;
                }
            }            
            if (match) {
                for (int k = 0; k < replacement.length(); k++) {
                    sentenceArr[index++] = replacement.charAt(k);
                }
                i += target.length() - 1; 
            } else {
                sentenceArr[index++] = sentence.charAt(i);
            }
        }        
        String result = "";
        for (int i = 0; i < index; i++) {
            result += sentenceArr[i];
        }
        return result;
    }
    public static void main(String[] args) {
        String sentence = "I love programming and programming is fun";
        String target = "programming";
        String replacement = "coding";
        String modifiedSentence = replaceWord(sentence, target, replacement);
        System.out.println("Modified Sentence: " + modifiedSentence);
    }
}

