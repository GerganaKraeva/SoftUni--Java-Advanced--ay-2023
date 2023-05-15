package MultidimensionalArraysExercises;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] dimensions = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);
        String[][] matrix = new String[rows][cols];
        fillMatrix(matrix, scanner);
        String command = scanner.nextLine();

        while (!command.equals("END")) {
            String[] commands = command.split("\\s+");
            boolean isValid = isCommandValid(commands, rows, cols);
            if (isValid) {
                int indexRow1 = Integer.parseInt(commands[1]);
                int indexRow2 = Integer.parseInt(commands[3]);
                int indexCol1 = Integer.parseInt(commands[2]);
                int indexCol2 = Integer.parseInt(commands[4]);
                String currentCell=matrix[indexRow1][indexCol1];
                matrix[indexRow1][indexCol1]=matrix[indexRow2][indexCol2];
                matrix[indexRow2][indexCol2]=currentCell;
                printTheMatrix(matrix);
            } else {
                System.out.println("Invalid input!");
            }
            command = scanner.nextLine();
        }
    }
    private static void printTheMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    private static boolean isCommandValid(String[] commands, int rows, int cols) {

        if (commands.length != 5) {
            return false;
        } else if (!commands[0].equals("swap")) {
            return false;
        } else if (Integer.parseInt(commands[1])< 0 || Integer.parseInt(commands[1]) >= rows || Integer.parseInt(commands[3]) < 0 || Integer.parseInt(commands[3]) >= rows ||
                Integer.parseInt(commands[2])< 0 || Integer.parseInt(commands[2])>= cols || Integer.parseInt(commands[4]) < 0 || Integer.parseInt(commands[4])>= cols) {
            return false;
        } else {
            return true;
        }
    }
    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            String[] rowContent = scanner.nextLine().split("\\s+");
            matrix[row] = rowContent;
        }
    }
}
