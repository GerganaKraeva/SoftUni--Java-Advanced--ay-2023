package ExamPrep;

import java.util.Scanner;

public class BlindMansBuff {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] numbers = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(numbers[0]);
        int cols = Integer.parseInt(numbers[1]);
        String[][] matrix = new String[rows][cols];
        boolean isIn = true;
        for (int row = 0; row < matrix.length; row++) {
            String[] rowContent = scanner.nextLine().split(" ");
            matrix[row] = rowContent;
        }
        String currentPosition = getPosition(matrix);
        int currentRow = Integer.parseInt(currentPosition.split("")[0]);
        int currentCol = Integer.parseInt(currentPosition.split("")[1]);

        String command = scanner.nextLine();
        int touchedOpponents = 0;
        int countMoves = 0;

        while (!command.equals("Finish")) {

            int newPosRow = currentRow;
            int newPosCol = currentCol;

            if (command.equals("up")) {
                newPosRow --;
            } else if (command.equals("down")) {
                newPosRow ++;
            } else if (command.equals("right")) {
                newPosCol ++;
            } else if (command.equals("left")) {
                newPosCol --;
            }
            isIn = isInField(newPosCol, newPosRow, rows, cols);
            if (!isIn) {
                newPosRow = currentRow;
                newPosCol = currentCol;
            } else {
                if (matrix[newPosRow][newPosCol].equals("O")) {
                    newPosRow = currentRow;
                    newPosCol = currentCol;
                } else if (matrix[newPosRow][newPosCol].equals("P")) {
                    countMoves++;
                    touchedOpponents++;
                    matrix[newPosRow][newPosCol] = "B";
                    matrix[currentRow][currentCol] = "-";
                    currentRow = newPosRow;
                    currentCol = newPosCol;
                    if (touchedOpponents == 3) {
                        break;
                    }
                } else if (matrix[newPosRow][newPosCol].equals("-")) {
                    countMoves++;
                    matrix[newPosRow][newPosCol] = "B";
                    matrix[currentRow][currentCol] = "-";
                    currentRow = newPosRow;
                    currentCol = newPosCol;
                }
            }
            if (touchedOpponents==3) {
                break;
            }
            command = scanner.nextLine();
        }
        System.out.println("Game over!");
        System.out.printf("Touched opponents: %d Moves made: %d\n", touchedOpponents, countMoves);
    }
    private static boolean isInField(int currentColumn, int currentRow, int row, int col) {
        if (currentColumn > col - 1 || currentColumn < 0 || currentRow < 0 || currentRow > row - 1) {
            return false;
        }
        return true;
    }

    private static String getPosition(String[][] matrix) {
        String position = "";
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col].equals("B")) {
                    position += row;
                    position += col;
                }
            }
        }
        return position;
    }
}
