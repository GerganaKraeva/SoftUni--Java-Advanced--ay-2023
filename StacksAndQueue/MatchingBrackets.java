package StacksAndQueue;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        ArrayDeque<Integer> indexes = new ArrayDeque<>();

        for (int i = 0; i < userInput.length(); i++) {
            if (userInput.charAt(i) == '(') {
                indexes.push(i);
            } else if (userInput.charAt(i) == ')') {
                int openBracketsIndex = indexes.pop();
                String expression=userInput.substring(openBracketsIndex,i+1);
                System.out.println(expression);
            }
        }


    }
}
