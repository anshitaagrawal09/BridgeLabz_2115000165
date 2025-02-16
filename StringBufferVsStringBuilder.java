public class StringBufferVsStringBuilder {
    public static void main(String[] args) {
        int iterations = 1_000_000; // 1 million iterations
        String text = "hello";
        // Measure time for StringBuffer
        StringBuffer stringBuffer = new StringBuffer();
        long startTime1 = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            stringBuffer.append(text);
        }
        long endTime1 = System.nanoTime();
        long stringBufferTime = endTime1 - startTime1;
        // Measure time for StringBuilder
        StringBuilder stringBuilder = new StringBuilder();
        long startTime2 = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            stringBuilder.append(text);
        }
        long endTime2 = System.nanoTime();
        long stringBuilderTime = endTime2 - startTime2;
        // Print results
        System.out.println("Time taken by StringBuffer: " + stringBufferTime / 1_000_000 + " ms");
        System.out.println("Time taken by StringBuilder: " + stringBuilderTime / 1_000_000 + " ms");
        // Compare Performance
        if (stringBufferTime > stringBuilderTime) {
            System.out.println("StringBuilder is faster.");
        } else {
            System.out.println("StringBuffer is faster.");
        }
    }
}
