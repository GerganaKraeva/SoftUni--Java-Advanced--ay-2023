package ExamPrep.StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Lootbox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> firstBox = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(firstBox::offer);

        ArrayDeque<Integer> secondBox = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(secondBox::push);

        int totalSum = 0;
        while (!firstBox.isEmpty() && !secondBox.isEmpty()) {
            int sum = firstBox.peek() + secondBox.peek();

            if (sum % 2 == 0) {
                totalSum += sum;
                firstBox.poll();
                secondBox.pop();
            } else {
                int removedEl = secondBox.pop();
                firstBox.offer(removedEl);
            }
        }
        if(firstBox.isEmpty()) {
            System.out.println("First lootbox is empty");
        }else{
            System.out.println("Second lootbox is empty");
        }

        if(totalSum>100) {
            System.out.println(String.format("Your loot was epic! Value: %d",totalSum));
        }else{
            System.out.println(String.format("Your loot was poor... Value: %d",totalSum));
        }
    }
}
