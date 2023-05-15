package MultidimensionalArraysExercises;

import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String [] dimensionsMatrix=scanner.nextLine().split(" ");
        int rows=Integer.parseInt(dimensionsMatrix[0]);
        int cols=Integer.parseInt(dimensionsMatrix[1]);
        String[][]matrix=new String[rows][cols];
        fillMatrix(matrix);
    }

    private static void fillMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                int numberAsciiTable=(row+97);
                int middleNumberAsciiTable=row+col+97;
                String cell=""+""+(char)numberAsciiTable+(char)middleNumberAsciiTable+(char)numberAsciiTable;
                System.out.print(cell+" ");
            }
            System.out.println();
        }
    }
}
