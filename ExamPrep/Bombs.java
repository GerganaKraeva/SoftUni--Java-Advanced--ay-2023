package ExamPrep;

import java.util.*;
import java.util.stream.Collectors;

public class Bombs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> firstLine = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> secondLine = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        ArrayDeque<Integer> queueBombEffect = new ArrayDeque<>();
        firstLine.forEach(e -> queueBombEffect.offer(e));
        ArrayDeque<Integer> stackBombCasing = new ArrayDeque<>();
        secondLine.forEach(e -> stackBombCasing.push(e));
        Map<String, Integer> bombPouch = new TreeMap<>();
        bombPouch.put("Datura Bombs", 0);
        bombPouch.put("Cherry Bombs", 0);
        bombPouch.put("Smoke Decoy Bombs", 0);
        boolean isFilledBombPouch = false;

        int result = 0;

        while (!queueBombEffect.isEmpty() && !stackBombCasing.isEmpty()) {
            if (bombPouch.get("Datura Bombs") >= 3 && bombPouch.get("Cherry Bombs") >= 3 && bombPouch.get("Smoke Decoy Bombs") >= 3) {
                break;
            }
            int bombEffect = queueBombEffect.peek();
            int bombCasing = stackBombCasing.peek();
            result = bombEffect + bombCasing;
            int currentCount = 0;
            if (result == 40) {
                currentCount = bombPouch.get("Datura Bombs");
                bombPouch.put("Datura Bombs", currentCount + 1);
                queueBombEffect.poll();
                stackBombCasing.pop();
            } else if (result == 60) {
                currentCount = bombPouch.get("Cherry Bombs");
                bombPouch.put("Cherry Bombs", currentCount + 1);
                queueBombEffect.poll();
                stackBombCasing.pop();
            } else if (result == 120) {
                currentCount = bombPouch.get("Smoke Decoy Bombs");
                bombPouch.put("Smoke Decoy Bombs", currentCount + 1);
                queueBombEffect.poll();
                stackBombCasing.pop();
            } else {
                stackBombCasing.pop();
                int toAdd = bombCasing - 5;
                stackBombCasing.push(toAdd);
            }
        }
        if (bombPouch.size() == 3 && bombPouch.get("Datura Bombs") >= 3 && bombPouch.get("Cherry Bombs") >= 3 && bombPouch.get("Smoke Decoy Bombs") >= 3) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");

        }
        if (queueBombEffect.isEmpty()) {
            System.out.println("Bomb Effects: empty");
        } else {
            List<String> resultToPrint = new ArrayList<>();
            queueBombEffect.forEach(e -> resultToPrint.add(e + ""));
            System.out.println("Bomb Effects: " + String.join(", ", resultToPrint));
        }
        if (stackBombCasing.isEmpty()) {
            System.out.println("Bomb Casings: empty");
        } else {
            List<String> resultToPrint = new ArrayList<>();
            stackBombCasing.forEach(e -> resultToPrint.add(e + ""));
            System.out.println("Bomb Casings: " + String.join(", ", resultToPrint));
        }

        for (Map.Entry<String, Integer> entry : bombPouch.entrySet()) {
            System.out.printf("%s: %d\n", entry.getKey(), entry.getValue());
        }
    }
}

