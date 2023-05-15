package MultidimensionalArraysLab;

import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] firstLine = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(firstLine[0]);
        int cols = Integer.parseInt(firstLine[1]);
        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < matrix.length; row++) {
            String[] elements = scanner.nextLine().split("\\s+");
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = Integer.parseInt(elements[col]);
            }
        }
        String[] secondLine = scanner.nextLine().split("\\s+");
        int rows2 = Integer.parseInt(secondLine[0]);
        int cols2 = Integer.parseInt(secondLine[1]);
        int[][] matrix2 = new int[rows2][cols2];

        for (int row = 0; row < matrix2.length; row++) {
            String[] elements = scanner.nextLine().split("\\s+");
            for (int col = 0; col < matrix2[row].length; col++) {
                matrix2[row][col] = Integer.parseInt(elements[col]);
            }
        }
        boolean isEqual = true;
        if (rows != rows2 || cols != cols2) {
            isEqual = false;
        } else {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (matrix[i][j] != matrix2[i][j]) {
                        isEqual = false;
                        break;
                    }
                    if (!isEqual) {
                        break;
                    }
                }
            }
        }
        if (isEqual) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }
    }
}
