package MultidimensionalArraysLab;

import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int rows=Integer.parseInt(scanner.nextLine());
        int cols=Integer.parseInt(scanner.nextLine());

        String[][]matrix1=new String [rows][cols];
        for (int row = 0; row < matrix1.length; row++) {
            String[] lineCol = scanner.nextLine().split("\\s+");
            for (int col = 0; col < matrix1[row].length; col++) {
                matrix1[row][col] = lineCol[col];
            }
        }

        String [][]matrix2=new String[rows][cols];
        for (int row = 0; row < matrix2.length; row++) {
            String[]lineCol=scanner.nextLine().split("\\s+");
            for (int col = 0; col < matrix2[row].length; col++) {
                matrix2[row][col]=lineCol[col];
            }
        }
        for (int row = 0; row < matrix1.length; row++) {
            for (int col = 0; col < matrix1[row].length; col++) {
                if((matrix1[row][col]).equals(matrix2[row][col])){
                    System.out.print(matrix1[row][col]+" ");
                }else{
                    System.out.print("* ");
                }
            }
            System.out.println();
        }

    }
}
