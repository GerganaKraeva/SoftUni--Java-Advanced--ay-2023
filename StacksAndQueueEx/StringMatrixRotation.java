package MultidimensionalArraysExercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String rotateDegree = scanner.nextLine();
        int startDegree = getDegree(rotateDegree);
        int endDegree = rotateDegree.length() - 1;
        int degree = Integer.parseInt(rotateDegree.substring(startDegree, endDegree)) % 360;
        String userInput = scanner.nextLine();
        List<String> data = new ArrayList<>();

        while (!userInput.equals("END")) {
            data.add(userInput);
            userInput = scanner.nextLine();
        }
        int rows = data.size();
        int cols = data.get(0).length();

        for (int i = 1; i <data.size() ; i++) {
            int currentSize=data.get(i).length();
            if(currentSize>cols){
                cols=currentSize;
            }
        }
        char[][] matrix = new char[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (col < data.get(row).length()) {
                    matrix[row][col] = data.get(row).charAt(col);
                } else {
                    matrix[row][col] =' ';
                }
            }
        }
        rotateMatrix(matrix, degree, rows, cols);
    }
    private static void rotateMatrix(char[][] matrix, int degree, int rows, int maxCol) {
        if (degree == 90) {
            for (int col = 0; col < maxCol; col++) {
                for (int row = rows - 1; row >= 0; row--) {
                    char current = matrix[row][col];
                    System.out.print(current);
                }
                System.out.println();
            }

        } else if (degree == 180) {
            for (int row = rows-1; row >=0; row--) {
                for (int col = maxCol-1; col >=0; col--) {
                    char current = matrix[row][col];
                    System.out.print(current);
                }
                System.out.println();
            }

        } else if (degree == 270) {
            for (int col = maxCol-1; col >=0; col--) {
                for (int row = 0; row <rows; row++) {
                    char current = matrix[row][col];
                    System.out.print(current);
                }
                System.out.println();
            }
        } else {
            printTheMatrix(matrix);
        }
    }
    private static void printTheMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "");
            }
            System.out.println();
        }
    }

    private static int getDegree(String rotateDegree) {
        int start = 0;
        for (int i = 0; i < rotateDegree.length(); i++) {
            char currentSymbol = rotateDegree.charAt(i);
            if (currentSymbol == '(') {
                start = i;
            }
        }
        return start + 1;
    }
}
