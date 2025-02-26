public class CensorshipUtil {
    public static String maskTeamName(String teamName) {
        if (teamName.contains(" ")) {
            return teamName.substring(0, teamName.indexOf(" ")) + " ***";
        }
        return teamName; 
    }

    public static String redactPlayer(String player) {
        return "REDACTED";
    }
}
