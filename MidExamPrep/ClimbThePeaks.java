package ExamPrep;

import java.util.*;

import java.util.stream.Collectors;

public class ClimbThePeaks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> firstLine = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> secondLine = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        ArrayDeque<Integer> foodPortions = new ArrayDeque<>();
        firstLine.forEach(e -> foodPortions.push(e));
        ArrayDeque<Integer> staminaQuantities = new ArrayDeque<>();
        secondLine.forEach(e -> staminaQuantities.offer(e));
        List<String> mountainNames = new ArrayList<>();
        mountainNames.add("Vihren");
        mountainNames.add("Kutelo");
        mountainNames.add("Banski Suhodol");
        mountainNames.add("Polezhan");
        mountainNames.add("Kamenitza");
//    Arrays.asList("Vihren", "Kutelo", "Banski Suhodol", "Polezhan", "Kamenitza");
        ArrayDeque<Integer> difficultLevel = new ArrayDeque<>();
        difficultLevel.offer(80);
        difficultLevel.offer(90);
        difficultLevel.offer(100);
        difficultLevel.offer(60);
        difficultLevel.offer(70);
        ArrayDeque<String> conqueredPeak = new ArrayDeque<>();
        int countDays = 0;

        while (countDays < 7 || !foodPortions.isEmpty() && !secondLine.isEmpty()) {
            int food = foodPortions.pop();
            int stamina = staminaQuantities.poll();
            int result = food + stamina;
            countDays++;
            if (result >= difficultLevel.peek()) {
                difficultLevel.poll();
                conqueredPeak.offer(mountainNames.get(0));
                if(!mountainNames.isEmpty()) {
                    mountainNames.remove(0);
                }
            }
            if(mountainNames.isEmpty()){
                break;
            }
        }
        if(conqueredPeak.size()==5 && countDays<=7){
            System.out.println("Alex did it! He climbed all top five Pirin peaks in one week -> @FIVEinAWEEK");
            System.out.println("Conquered peaks:");
            conqueredPeak.forEach(System.out::println);
        }else {
            System.out.println("Alex failed! He has to organize his journey better next time -> @PIRINWINS");
            if(!conqueredPeak.isEmpty()){
                System.out.println("Conquered peaks:");
                conqueredPeak.forEach(System.out::println);
            }
        }
    }
}