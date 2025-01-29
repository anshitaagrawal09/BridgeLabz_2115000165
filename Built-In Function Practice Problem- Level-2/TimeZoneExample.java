import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
public class TimeZoneExample {
    public static void main(String[] args) {
        ZonedDateTime now = ZonedDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        ZonedDateTime gmtTime = now.withZoneSameInstant(ZoneId.of("GMT"));
        System.out.println("Current time in GMT: " + gmtTime.format(formatter));
        ZonedDateTime istTime = now.withZoneSameInstant(ZoneId.of("Asia/Kolkata"));
        System.out.println("Current time in IST: " + istTime.format(formatter));
        ZonedDateTime pstTime = now.withZoneSameInstant(ZoneId.of("America/Los_Angeles"));
        System.out.println("Current time in PST: " + pstTime.format(formatter));
    }
}


