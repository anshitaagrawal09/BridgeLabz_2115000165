import java.util.Arrays;
import java.util.List;

public class CensorBadWords {
    public static void main(String[] args) {
        String input = "This is a damn bad example with some stupid words.";
        
        // List of bad words to censor
        List<String> badWords = Arrays.asList("damn", "stupid");

        // Replace each bad word with ****
        for (String word : badWords) {
            input = input.replaceAll("(?i)\\b" + word + "\\b", "****");
        }
        
        // Print censored sentence
        System.out.println(input);
    }
}
