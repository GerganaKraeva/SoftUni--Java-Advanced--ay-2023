package ExamPrep;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TheSquirrel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<String> directions = Arrays.stream(scanner.nextLine().split(",\\s"))
                .collect(Collectors.toList());
        String[][] matrix = new String[n][];
        for (int row = 0; row < matrix.length; row++) {
            String[] rowContent = scanner.nextLine().split("");
            matrix[row] = rowContent;
        }
        String currentPosition = getPosition(matrix);
        int currentRow = Integer.parseInt(currentPosition.split("")[0]);
        int currentColumn = Integer.parseInt(currentPosition.split("")[1]);
        int countHazelnuts = 0;
        boolean isCollectAllHazelnuts=false;
        boolean isInTrap=false;
        boolean isInTheField=true;

        for (String currentMove : directions) {

            if (currentMove.equals("left")) {
                currentColumn--;

            } else if (currentMove.equals("right")) {
                currentColumn++;

            } else if (currentMove.equals("down")) {
                currentRow++;

            } else  {
                currentRow--;
            }
             isInTheField = isSquirrelIn(currentColumn, currentRow, n);
            if (!isInTheField) {
                System.out.println("The squirrel is out of the field.");
                break;
            }
            if (matrix[currentRow][currentColumn].equals("h")) {
                countHazelnuts++;
                if (countHazelnuts == 3) {
                    System.out.println("Good job! You have collected all hazelnuts!");
                    matrix[currentRow][currentColumn] = "s";
                    isCollectAllHazelnuts=true;
                    break;
                }
            } else if (matrix[currentRow][currentColumn].equals("t")) {
                System.out.println("Unfortunately, the squirrel stepped on a trap...");
                isInTrap=true;
                break;
            }
            matrix[currentRow][currentColumn] = "*";

        }
        if(!isInTrap && !isCollectAllHazelnuts && isInTheField){
            System.out.println("There are more hazelnuts to collect.");
        }
        System.out.printf("Hazelnuts collected: %d",countHazelnuts);
    }
    private static boolean isSquirrelIn(int currentColumn, int currentRow, int n) {
        if (currentColumn > n - 1 || currentColumn < 0 || currentRow < 0 || currentRow > n - 1) {
            return false;
        }
        return true;
    }
    private static String getPosition(String[][] matrix) {
        String position = "";
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col].equals("s")) {
                    position += row;
                    position += col;
                }
            }
        }
        return position;
    }
}
