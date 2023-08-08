package ExamPrep;

import java.util.Scanner;

public class NavyBattle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[n][n];

        for (int row = 0; row < matrix.length; row++) {
            String[] rowContent = scanner.nextLine().split("");
            matrix[row] = rowContent;
        }

        String currentPosition = getPosition(matrix);
        int currentRow = Integer.parseInt(currentPosition.split("")[0]);
        int currentCol = Integer.parseInt(currentPosition.split("")[1]);
        String command = scanner.nextLine();
        int countHits = 0;
        int cruiserHits = 0;

        while (true) {
            int newRow=currentRow;
            int newCol=currentCol;
            if (command.equals("up")) {
                newRow = currentRow - 1;
            } else if (command.equals("down")) {
                newRow = currentRow + 1;
            } else if (command.equals("right")) {
                newCol = currentCol + 1;
            } else if (command.equals("left")) {
                newCol = currentCol - 1;
            }
            if (matrix[newRow][newCol].equals("*")) {
                countHits++;
                matrix[currentRow][currentCol] = "-";
                matrix[newRow][newCol] = "S";
            } else if (matrix[newRow][newCol].equals("C")) {
                cruiserHits++;
                matrix[currentRow][currentCol] = "-";
                matrix[newRow][newCol] = "S";

            } else if (matrix[newRow][newCol].equals("-")) {
                matrix[currentRow][currentCol] = "-";
                matrix[newRow][newCol] = "S";
            }
            if (countHits == 3) {
                System.out.printf("Mission failed, U-9 disappeared! Last known coordinates [%d, %d]!\n", newRow, newCol);
                break;
            }
            if (cruiserHits == 3) {
                System.out.println("Mission accomplished, U-9 has destroyed all battle cruisers of the enemy!");
                break;
            }
            currentRow = newRow;
            currentCol = newCol;
            command = scanner.nextLine();
        }
        printMatrix(matrix);
    }

    private static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                String current = matrix[i][j];
                System.out.print(current + "");
            }
            System.out.println();
        }
    }


    private static String getPosition(String[][] matrix) {
        String position = "";
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col].equals("S")) {
                    position += row;
                    position += col;
                }
            }
        }
        return position;
    }
}
