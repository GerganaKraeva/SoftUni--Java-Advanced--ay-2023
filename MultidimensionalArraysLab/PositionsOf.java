package MultidimensionalArraysLab;

import java.util.Scanner;

public class PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] userInput = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(userInput[0]);
        int cols = Integer.parseInt(userInput[1]);
        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] lineCol = scanner.nextLine().split("\\s+");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = Integer.parseInt(lineCol[col]);
            }
        }
        boolean isFound = false;
        int number = Integer.parseInt(scanner.nextLine());
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (number == matrix[row][col]) {
                    isFound = true;
                    System.out.println(row + " " + col);
                }
            }
        }
        if (!isFound) {
            System.out.println("not found");
        }

    }
}
