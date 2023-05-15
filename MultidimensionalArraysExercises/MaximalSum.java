package MultidimensionalArraysExercises;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] dimensions = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);
        int[][] matrix = new int[rows][cols];
        fillMatrix(matrix,scanner);
        List <Integer>maxMatrix=getMaxSumOfMatrix3x3(matrix,rows,cols);
        System.out.println("Sum = "+maxMatrix.get(0));
        int row= maxMatrix.get(1);
        int col=maxMatrix.get(2);
        printMatrix(matrix, row, col);
    }
    private static void printMatrix(int[][] matrix, int row, int col) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(i==row &&j==col){
                    System.out.print(matrix[i][j]+" "+matrix[i][j+1]+" "+matrix[i][j+2]);
                    System.out.println();
                    System.out.print(matrix[i+1][j]+" "+matrix[i+1][j+1]+" "+matrix[i+1][j+2]);
                    System.out.println();
                    System.out.print(matrix[i+2][j]+" "+matrix[i+2][j+1]+" "+matrix[i+2][j+2]);
                }
            }
        }
    }
    private static List getMaxSumOfMatrix3x3(int [][] matrix,int rows, int cols) {
        List<Integer>maxMatrix3x3=new ArrayList<>();
        int sum=Integer.MIN_VALUE;
        int rowCell=0;
        int colCell=0;
        for ( int row = 0; row < rows-2; row++) {
            for ( int col = 0; col < cols-2; col++) {
                int currentSum=matrix[row][col]+matrix[row][col+1]+matrix[row][col+2]
                        +matrix[row+1][col]+matrix[row+1][col+1]+matrix[row+1][col+2]
                +matrix[row+2][col]+matrix[row+2][col+1]+matrix[row+2][col+2];
                if(currentSum>sum){
                    sum=currentSum;
                    rowCell=row;
                    colCell=col;
                }
            }
        }
        maxMatrix3x3.add(sum);
        maxMatrix3x3.add(rowCell);
        maxMatrix3x3.add(colCell);
        return maxMatrix3x3;
    }
    private static void fillMatrix(int[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            int[] rowContent= Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(element->Integer.parseInt(element))
                    .toArray();
            matrix[row]=rowContent;
        }
    }
}
