public class RandomNumbers {
    public static int[] generate4DigitRandomArray(int size) {
        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = (int) (Math.random() * 9000) + 1000;
        }
        return numbers;
    }
    public static double[] findAverageMinMax(int[] numbers) {
        double[] result = new double[3];
        double sum = 0;
        int min = numbers[0];
        int max = numbers[0];
        for (int num : numbers) {
            sum += num;
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        result[0] = sum / numbers.length;
        result[1] = min;
        result[2] = max;
        return result;
    }
    public static void main(String[] args) {
        int size = 5;
        int[] randomNumbers = generate4DigitRandomArray(size);
        double[] results = findAverageMinMax(randomNumbers);
        System.out.println("Generated 4-digit numbers: ");
        for (int num : randomNumbers) {
            System.out.print(num + " ");
        }
        System.out.println("\nAverage: " + results[0]);
        System.out.println("Minimum: " + results[1]);
        System.out.println("Maximum: " + results[2]);
    }
}

