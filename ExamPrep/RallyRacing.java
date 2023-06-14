package ExamPrep;

import java.util.Scanner;


public class RallyRacing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String racingNumber = scanner.nextLine();
        String[][] matrix = new String[n][n];

        for (int i = 0; i < n; i++) {
            String[] rowContent = scanner.nextLine().split("\\s+");
            matrix[i] = rowContent;
        }
        int currentRow = 0;
        int currentCol = 0;
        int km = 0;
        boolean isFinished = false;
        String command = scanner.nextLine();
        while (!command.equals("End")) {
            if (command.equals("up")) {
                currentRow--;
            } else if (command.equals("down")) {
                currentRow++;
            } else if (command.equals("right")) {
                currentCol++;
            } else if (command.equals("left")) {
                currentCol--;
            }

            if (matrix[currentRow][currentCol].equals(".")) {
                km += 10;
            } else if (matrix[currentRow][currentCol].equals("T")) {
                km += 30;
                matrix[currentRow][currentCol] = ".";
                String coordinates = getNextTunnel(matrix);
                currentRow = Integer.parseInt(coordinates.split("")[0]);
                currentCol = Integer.parseInt(coordinates.split("")[1]);
                matrix[currentRow][currentCol] = ".";
            } else if (matrix[currentRow][currentCol].equals("F")) {
                km+=10;
                matrix[currentRow][currentCol] = ".";
                isFinished = true;
                break;
            }

            command = scanner.nextLine();
        }
        matrix[currentRow][currentCol]="C";
        if (isFinished) {
            System.out.printf("Racing car %s finished the stage!\n", racingNumber);
        } else {
            System.out.printf("Racing car %s DNF.\n", racingNumber);
        }
        System.out.printf("Distance covered %d km.\n", km);
        printMatrix1(matrix);
    }
    private static void printMatrix1(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                String current = matrix[i][j];
                System.out.print(current + "");
            }
            System.out.println();
        }
    }
    private static String getNextTunnel(String[][] matrix) {
        String found = "";
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].equals("T")) {
                    found += i;
                    found += j;
                }
            }
        }
        return found;
    }
}