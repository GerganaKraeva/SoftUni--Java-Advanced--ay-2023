package StacksAndQueue;

import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinaryConvector {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int number=Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer>binaryNumber=new ArrayDeque<>();
        if (number==0){
            System.out.println(0);
        }
        while (number!=0){
            int binary=number%2;
            binaryNumber.push(binary);
            number=number/2;
        }
        for (Integer numberBinary : binaryNumber) {
            System.out.print(numberBinary);
        }
    }
}
