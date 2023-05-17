package SetsAndMapsAdvancedLab;

import java.util.*;
import java.util.stream.Collectors;

public class War {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> cardsFirstPlayer = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> cardsSecondPlayer = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Set<Integer> firstPlayer = new LinkedHashSet<>();
        for (Integer card : cardsFirstPlayer) {
            firstPlayer.add(card);
        }
        Set<Integer> secondPlayer = new LinkedHashSet<>();
        for (Integer card : cardsSecondPlayer) {
            secondPlayer.add(card);
        }


        for (int i = 0; i < 50; i++) {
            if (firstPlayer.isEmpty()) {
                break;
            } else if (secondPlayer.isEmpty()) {
                break;
            }
            Integer firstNumber = firstPlayer.iterator().next();
            firstPlayer.remove(firstNumber);
            Integer secondNumber = secondPlayer.iterator().next();
            secondPlayer.remove(secondNumber);
            if (firstNumber > secondNumber) {
                firstPlayer.add(secondNumber);
                secondPlayer.remove(secondNumber);
            } else if (firstNumber < secondNumber) {
                secondPlayer.add(firstNumber);
                firstPlayer.remove(firstNumber);
            } else {
                firstPlayer.add(firstNumber);
                secondPlayer.add(secondNumber);
            }
        }
        if (firstPlayer.size() < secondPlayer.size() || firstPlayer.isEmpty()) {
            System.out.println("Second player win!");
        } else if(firstPlayer.size() > secondPlayer.size() || secondPlayer.isEmpty()){
            System.out.println("First player win!");
        }else{
            System.out.println("Draw!");
        }
    }
}

