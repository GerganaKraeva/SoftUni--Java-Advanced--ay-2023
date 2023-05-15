package MultidimensionalArraysLab;

import java.util.Scanner;

public class SumOfMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] sizeOfMatrix = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(sizeOfMatrix[0]);
        int cols = Integer.parseInt(sizeOfMatrix[1]);
        int[][] matrix = new int[rows][cols];
        int sum = 0;

        for (int row = 0; row < matrix.length; row++) {
            String[] columnsEl = scanner.nextLine().split(", ");
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = Integer.parseInt(columnsEl[col]);
                int cell=matrix[row][col];
                sum += cell;
            }
        }
        System.out.println(rows);
        System.out.println(cols);
        System.out.println(sum);

    }
}

