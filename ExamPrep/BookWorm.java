package task2;


import java.util.Arrays;
import java.util.Scanner;


public class BookWorm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int number = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[number][number];
        boolean isInTheField = true;
        StringBuilder sb = new StringBuilder(input);


        for (int i = 0; i < matrix.length; i++) {
            String[] rowContent = scanner.nextLine().split("");
            matrix[i] = rowContent;
        }

        String currentPosition = getPosition(matrix);
        int currentRow = Integer.parseInt(currentPosition.split("")[0]);
        int currentColumn = Integer.parseInt(currentPosition.split("")[1]);
        String commands = scanner.nextLine();


        while (!commands.equals("end")) {
            int newPosRow = currentRow;
            int newPosCol = currentColumn;
            if (commands.equals("up")) {
                newPosRow --;
            } else if (commands.equals("down")) {
                newPosRow ++;
            } else if (commands.equals("right")) {
                newPosCol ++;
            } else if (commands.equals("left")) {
                newPosCol --;
            }
            isInTheField = isWormIn(newPosCol, newPosRow, number);
            if (!isInTheField) {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                if (matrix[newPosRow][newPosCol].equals("-")) {
                    matrix[newPosRow][newPosCol]="P";
                    matrix[currentRow][currentColumn]="-";
                } else if (Character.isLetter(matrix[newPosRow][newPosCol].charAt(0))) {
                    sb.append(matrix[newPosRow][newPosCol]);
                    matrix[newPosRow][newPosCol]="P";
                    matrix[currentRow][currentColumn]="-";
                }
                currentRow = newPosRow;
                currentColumn = newPosCol;
            }
            commands = scanner.nextLine();
        }
        System.out.println(sb.toString());
        printMatrix(matrix);

    }

    private static boolean isWormIn(int currentColumn, int currentRow, int number) {
        if (currentColumn > number - 1 || currentColumn < 0 || currentRow < 0 || currentRow > number - 1) {
            return false;
        }
        return true;
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
                if (matrix[row][col].equals("P")) {
                    position += row;
                    position += col;
                }
            }
        }
        return position;
    }
}
