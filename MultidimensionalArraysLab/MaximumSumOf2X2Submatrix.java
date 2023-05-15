package MultidimensionalArraysLab;

import java.util.Scanner;

public class MaximumSumOf2X2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] sizeOtMatrix = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(sizeOtMatrix[0]);
        int cols = Integer.parseInt(sizeOtMatrix[1]);
        int [][]matrix=new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            String [] columnsEl= scanner.nextLine().split(", ");
            for (int col = 0; col < cols; col++) {
                matrix[row][col]=Integer.parseInt(columnsEl[col]);
            }
        }

        int max= Integer.MIN_VALUE;
        int indexRow=0;
        int indexCol=0;
        for (int row = 0; row < rows-1; row++) {
            for (int col = 0; col < cols-1; col++) {
                int sum=matrix[row][col]+matrix[row][col+1]+matrix[row+1][col]+matrix[row+1][col+1];
                if(sum>max){
                    max=sum;
                    indexRow= row;
                    indexCol=col;
                }
            }
        }
        System.out.println(matrix[indexRow][indexCol]+" "+matrix[indexRow][indexCol+1]);
        System.out.println(matrix[indexRow+1][indexCol]+" "+matrix[indexRow+1][indexCol+1]);
        System.out.println(max);
    }
}
