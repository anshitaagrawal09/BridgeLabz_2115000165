// LegacyAPI class with an old method marked as @Deprecated
class LegacyAPI {
    
    @Deprecated
    void oldFeature() {
        System.out.println("This is the old feature. Please use newFeature() instead.");
    }
    
    void newFeature() {
        System.out.println("This is the new and improved feature!");
    }
}

// Main class to test the methods
public class APITest {
    public static void main(String[] args) {
        LegacyAPI api = new LegacyAPI();
        
        api.oldFeature(); // Should show a warning
        api.newFeature();
    }
}
