import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class IplCsvProcessor {
    public static void main(String[] args) throws Exception {
        CsvMapper csvMapper = new CsvMapper();
        CsvSchema schema = CsvSchema.emptySchema().withHeader();

        // Read CSV file
        File inputFile = new File("ipl_data.csv");
        MappingIterator<IplMatchCsv> it = csvMapper.readerFor(IplMatchCsv.class).with(schema).readValues(inputFile);
        List<IplMatchCsv> matches = it.readAll();

        // Apply censorship
        for (IplMatchCsv match : matches) {
            match.team1 = CensorshipUtil.maskTeamName(match.team1);
            match.team2 = CensorshipUtil.maskTeamName(match.team2);
            match.winner = CensorshipUtil.maskTeamName(match.winner);
            match.playerOfMatch = CensorshipUtil.redactPlayer(match.playerOfMatch);
        }

        // Define CSV Schema
        CsvSchema outputSchema = csvMapper.schemaFor(IplMatchCsv.class).withHeader();
        
        // Write to new censored CSV file
        csvMapper.writer(outputSchema).writeValue(new File("ipl_data_censored.csv"), matches);
        System.out.println("Censored CSV file created: ipl_data_censored.csv");
    }
}
