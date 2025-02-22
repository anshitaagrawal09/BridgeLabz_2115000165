import java.util.regex.*;

public class ValidateIPAddress {
    public static boolean isValidIPv4(String ip) {
        // Regular expression for IPv4
        String ipRegex = "^((25[0-5]|2[0-4][0-9]|1?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|1?[0-9][0-9]?)$";
        
        // Compile pattern
        Pattern pattern = Pattern.compile(ipRegex);
        Matcher matcher = pattern.matcher(ip);
        
        return matcher.matches(); // Returns true if IP is valid
    }

    public static void main(String[] args) {
        // Test cases
        String[] testIPs = { "192.168.1.1", "255.255.255.255", "256.100.50.25", "192.168.01.1", "192.168.1" };

        for (String ip : testIPs) {
            System.out.println(ip + " -> " + (isValidIPv4(ip) ? "Valid" : "Invalid"));
        }
    }
}
