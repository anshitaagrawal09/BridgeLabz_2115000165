import com.fasterxml.jackson.annotation.JsonProperty;

public class IplMatchCsv {
    @JsonProperty("match_id")
    public int matchId;

    @JsonProperty("team1")
    public String team1;

    @JsonProperty("team2")
    public String team2;

    @JsonProperty("score_team1")
    public int scoreTeam1;

    @JsonProperty("score_team2")
    public int scoreTeam2;

    @JsonProperty("winner")
    public String winner;

    @JsonProperty("player_of_match")
    public String playerOfMatch;
}
