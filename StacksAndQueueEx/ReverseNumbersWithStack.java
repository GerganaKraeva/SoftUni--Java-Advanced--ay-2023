package StacksAndQueueEx;

import java.util.ArrayDeque;
import java.util.Scanner;

public class ReverseNumbersWithStack {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String [] numbers=scanner.nextLine().split("\\s+");
        ArrayDeque<String>numbersStack=new ArrayDeque<>();

        for (String numberArr : numbers) {
            numbersStack.push(numberArr);
        }
        while (!numbersStack.isEmpty()){
            System.out.print(numbersStack.pop()+" ");
        }


    }
}
