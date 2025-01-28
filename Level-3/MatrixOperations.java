
import java.util.Random;
public class MatrixOperations {
    public static int[][] generateMatrix(int rows, int cols) {
        Random random = new Random();
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = random.nextInt(10);
            }
        }
        return matrix;
    }
    public static int[][] addMatrices(int[][] matrix1, int[][] matrix2) {
        int rows = matrix1.length, cols = matrix1[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return result;
    }
    public static int[][] subtractMatrices(int[][] matrix1, int[][] matrix2) {
        int rows = matrix1.length, cols = matrix1[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        return result;
    }
    public static int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2) {
        int rows = matrix1.length, cols = matrix2[0].length, common = matrix1[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                for (int k = 0; k < common; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return result;
    }
    public static int[][] transposeMatrix(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        int[][] transpose = new int[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }
        return transpose;
    }
    public static double determinant2x2(int[][] matrix) {
        return (matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]);
    }
    public static double determinant3x3(int[][] matrix) {
        return matrix[0][0] * ((matrix[1][1] * matrix[2][2]) - (matrix[1][2] * matrix[2][1]))
                - matrix[0][1] * ((matrix[1][0] * matrix[2][2]) - (matrix[1][2] * matrix[2][0]))
                + matrix[0][2] * ((matrix[1][0] * matrix[2][1]) - (matrix[1][1] * matrix[2][0]));
    }
    public static double[][] inverse2x2(int[][] matrix) {
        double determinant = determinant2x2(matrix);
        if (determinant == 0) return null;
        double[][] inverse = new double[2][2];
        inverse[0][0] = matrix[1][1] / determinant;
        inverse[0][1] = -matrix[0][1] / determinant;
        inverse[1][0] = -matrix[1][0] / determinant;
        inverse[1][1] = matrix[0][0] / determinant;
        return inverse;
    }
    public static double[][] inverse3x3(int[][] matrix) {
        double determinant = determinant3x3(matrix);
        if (determinant == 0) return null;
        double[][] cofactors = new double[3][3];
        cofactors[0][0] = determinant2x2(new int[][]{{matrix[1][1], matrix[1][2]}, {matrix[2][1], matrix[2][2]}});
        cofactors[0][1] = -determinant2x2(new int[][]{{matrix[1][0], matrix[1][2]}, {matrix[2][0], matrix[2][2]}});
        cofactors[0][2] = determinant2x2(new int[][]{{matrix[1][0], matrix[1][1]}, {matrix[2][0], matrix[2][1]}});
        cofactors[1][0] = -determinant2x2(new int[][]{{matrix[0][1], matrix[0][2]}, {matrix[2][1], matrix[2][2]}});
        cofactors[1][1] = determinant2x2(new int[][]{{matrix[0][0], matrix[0][2]}, {matrix[2][0], matrix[2][2]}});
        cofactors[1][2] = -determinant2x2(new int[][]{{matrix[0][0], matrix[0][1]}, {matrix[2][0], matrix[2][1]}});
        cofactors[2][0] = determinant2x2(new int[][]{{matrix[0][1], matrix[0][2]}, {matrix[1][1], matrix[1][2]}});
        cofactors[2][1] = -determinant2x2(new int[][]{{matrix[0][0], matrix[0][2]}, {matrix[1][0], matrix[1][2]}});
        cofactors[2][2] = determinant2x2(new int[][]{{matrix[0][0], matrix[0][1]}, {matrix[1][0], matrix[1][1]}});
        double[][] adjoint = transposeMatrix(cofactors);
        double[][] inverse = new double[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                inverse[i][j] = adjoint[i][j] / determinant;
            }
        }
        return inverse;
    }
    public static void displayMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double val : row) {
                System.out.printf("%.2f\t", val);
            }
            System.out.println();
        }
    }
    public static void displayMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + "\t");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[][] matrix1 = generateMatrix(2, 2);
        int[][] matrix2 = generateMatrix(2, 2);
        System.out.println("Matrix 1:");
        displayMatrix(matrix1);
        System.out.println("Matrix 2:");
        displayMatrix(matrix2);
        System.out.println("Addition:");
        displayMatrix(addMatrices(matrix1, matrix2));
        System.out.println("Subtraction:");
        displayMatrix(subtractMatrices(matrix1, matrix2));
        System.out.println("Multiplication:");
        displayMatrix(multiplyMatrices(matrix1, matrix2));
        System.out.println("Transpose of Matrix 1:");
        displayMatrix(transposeMatrix(matrix1));
        System.out.println("Determinant of Matrix 1: " + determinant2x2(matrix1));
        double[][] inverse = inverse2x2(matrix1);
        if (inverse != null) {
            System.out.println("Inverse of Matrix 1:");
            displayMatrix(inverse);
        } else {
            System.out.println("Matrix 1 is not invertible.");
        }
    }
}

