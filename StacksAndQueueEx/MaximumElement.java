package StacksAndQueueEx;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 1; i <= number; i++) {
            String nextCommand = scanner.nextLine();
            if (nextCommand.startsWith("1")) {
                stack.push(Integer.parseInt(nextCommand.split(" ")[1]));
            } else if (nextCommand.equals("2")) {
                stack.pop();
            } else {
                if(!stack.isEmpty()) {
                    System.out.println(Collections.max(stack));
                }
            }
        }
    }
}
