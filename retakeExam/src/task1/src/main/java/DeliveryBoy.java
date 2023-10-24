import java.util.Scanner;

public class DeliveryBoy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] size = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(size[0]);
        int cols = Integer.parseInt(size[1]);
        String[][] field = new String[rows][cols];
        int startRow = -1;
        int starCol = -1;

        for (int i = 0; i < rows; i++) {
            String[] row = scanner.nextLine().split("");
            field[i] = row;
            for (int j = 0; j < cols; j++) {
                if (field[i][j].equals("B")) {
                    startRow = i;
                    starCol = j;
                }
            }
        }
        String command = scanner.nextLine();

        boolean isPizzaDeliver = false;

        while (!isPizzaDeliver) {

            int newPosRow = startRow;
            int newPosCol = starCol;
            if (command.equals("up") && newPosRow != 0) {
                newPosRow--;
            } else if (command.equals("down") && newPosRow != rows - 1) {
                newPosRow++;
            } else if (command.equals("right") && newPosCol != cols - 1) {
                newPosCol++;
            } else if (command.equals("left") && newPosCol != 0) {
                newPosCol--;
            } else {
                System.out.println("The delivery is late. Order is canceled.");
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        if(field[i][j].equals("B")){
                            field[i][j]=" ";
                        }
                    }
                }
                          break;
            }

            if (field[newPosRow][newPosCol].equals("P")) {
                field[newPosRow][newPosCol] = "R";
                System.out.println("Pizza is collected. 10 minutes for delivery.");
            } else if (field[newPosRow][newPosCol].equals("*")) {
                newPosCol = starCol;
                newPosRow = startRow;
            } else if (field[newPosRow][newPosCol].equals("A")) {
                isPizzaDeliver = true;
                field[newPosRow][newPosCol] = "P";
                System.out.println("Pizza is delivered on time! Next order...");
                break;
            }

            startRow = newPosRow;
            starCol = newPosCol;
            if (!field[startRow][starCol].equals("B") && !field[startRow][starCol].equals("R")) {
                field[startRow][starCol] = ".";
            }
            command = scanner.nextLine();
        }
        printField(rows, cols, field);
    }

    private static void printField(int rows, int cols, String[][] field) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(field[i][j]);
            }
            System.out.println();
        }
    }
}
