import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.Arrays;
import java.util.List;

public class IplJsonProcessor {
    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        // Read JSON file
        List<IplMatch> matches = Arrays.asList(objectMapper.readValue(new File("ipl_data.json"), IplMatch[].class));

        // Apply censorship
        for (IplMatch match : matches) {
            match.team1 = CensorshipUtil.maskTeamName(match.team1);
            match.team2 = CensorshipUtil.maskTeamName(match.team2);
            match.winner = CensorshipUtil.maskTeamName(match.winner);
            match.playerOfMatch = CensorshipUtil.redactPlayer(match.playerOfMatch);
        }

        // Write to new censored JSON file
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File("ipl_data_censored.json"), matches);
        System.out.println("Censored JSON file created: ipl_data_censored.json");
    }
}
