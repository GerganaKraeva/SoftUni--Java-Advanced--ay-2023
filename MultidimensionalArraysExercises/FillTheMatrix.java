package MultidimensionalArraysExercises;

import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] matrixSize = scanner.nextLine().split(", ");
        int size = Integer.parseInt(matrixSize[0]);
        String typePattern = matrixSize[1];

        int[][] matrix = new int[size][size];
        if(typePattern.equals("A")) {
            fillMatrixPatternA(matrix);
        }else {
            fillMatrixPatternB(matrix);
        }
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                int current = matrix[i][j];
                System.out.print(current + " ");
            }
            System.out.println();
        }
    }

    private static void fillMatrixPatternB(int[][] matrix) {
        int cell = 1;
        for (int col = 0; col < matrix.length; col++) {
            if ((col + 1) % 2 != 0) {
                for (int row = 0; row < matrix.length; row++) {
                    matrix[row][col] = cell;
                    cell++;
                }
            } else {
                for (int row = matrix.length-1; row >=0; row--) {
                    matrix[row][col] = cell;
                    cell++;
                }
            }
        }
    }

    private static void fillMatrixPatternA(int[][] matrix) {
        int cell = 1;
        for (int col = 0; col < matrix.length; col++) {
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][col] = cell;
                cell++;
            }
        }
    }
}
