package MultidimensionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[number][];

        for (int row = 0; row < number; row++) {
            int[] currentRow = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(element -> Integer.parseInt(element))
                    .toArray();
            matrix[row] = currentRow;
        }

        for (int i = 0; i < matrix.length; i++) {
            System.out.print(matrix[i][i]+" ");
        }
        System.out.println();
        for (int row = number-1,col=0; col < number;  col++, row--) {
           int current=matrix[row][col];
            System.out.print(current+ " ");
        }

    }
}
