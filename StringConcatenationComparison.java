public class StringConcatenationComparison {
    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000};
        for (int size : sizes) {
            System.out.println("Operations Count: " + size);
            // String (Inefficient, O(N²))
            long startTime = System.nanoTime();
            stringConcatenation(size);
            long stringTime = System.nanoTime() - startTime;
            // StringBuilder (Efficient, O(N))
            startTime = System.nanoTime();
            stringBuilderConcatenation(size);
            long stringBuilderTime = System.nanoTime() - startTime;
            // StringBuffer (Thread-safe, O(N))
            startTime = System.nanoTime();
            stringBufferConcatenation(size);
            long stringBufferTime = System.nanoTime() - startTime;
            System.out.println("String Concatenation Time: " + (stringTime / 1_000_000.0) + " ms");
            System.out.println("StringBuilder Time: " + (stringBuilderTime / 1_000_000.0) + " ms");
            System.out.println("StringBuffer Time: " + (stringBufferTime / 1_000_000.0) + " ms");
            System.out.println("-----------------------------------");
        }
    }
    public static void stringConcatenation(int size) {
        String str = "";
        for (int i = 0; i < size; i++) {
            str += "a"; // Inefficient, creates a new object each time
        }
    }
    public static void stringBuilderConcatenation(int size) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append("a"); // Efficient, modifies existing object
        }
    }
    public static void stringBufferConcatenation(int size) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < size; i++) {
            sb.append("a"); // Thread-safe, but slightly slower
        }
    }
}
