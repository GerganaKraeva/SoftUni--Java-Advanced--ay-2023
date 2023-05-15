package StacksAndQueueEx;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] numbers = scanner.nextLine().split("\\s+");
        int numberToPush = Integer.parseInt(numbers[0]);
        int numberToPop = Integer.parseInt(numbers[1]);
        //Или numbersToPush=scanner.nextInt;
        //or Arrays.stream(scanner.nextLine().split(\\s+)
//        .mapToInt(Integer::parseInt)
//                .forEach(stack/elements::push);
        String element = numbers[2];
        boolean isTrue = false;
        String[] numbersToCheck = scanner.nextLine().split("\\s+");
        ArrayDeque<String> elements = new ArrayDeque<>();
        for (int i = 0; i < numberToPush; i++) {
            elements.push(numbersToCheck[i]);
        }
        for (int i = 0; i < numberToPop; i++) {
            elements.pop();
        }
        //Или elements.contains(element)
        for (String item : elements) {
            if (item.equals(element)) {
                isTrue = true;
            }
        }
        if (elements.isEmpty()) {
            System.out.println(0);
        } else {
            if (isTrue) {
                System.out.println("true");
            } else {
                System.out.println(Collections.min(elements));
            }
        }

    }
}
