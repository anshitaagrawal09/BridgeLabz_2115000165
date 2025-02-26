import com.fasterxml.jackson.annotation.JsonProperty;

public class IplMatch {
    @JsonProperty("match_id")
    public int matchId;

    @JsonProperty("team1")
    public String team1;

    @JsonProperty("team2")
    public String team2;

    @JsonProperty("score")
    public Score score;

    @JsonProperty("winner")
    public String winner;

    @JsonProperty("player_of_match")
    public String playerOfMatch;
}

class Score {
    @JsonProperty("Mumbai Indians")
    public int mumbaiIndians;

    @JsonProperty("Chennai Super Kings")
    public int chennaiSuperKings;

    @JsonProperty("Royal Challengers Bangalore")
    public int rcb;

    @JsonProperty("Delhi Capitals")
    public int delhiCapitals;
}
