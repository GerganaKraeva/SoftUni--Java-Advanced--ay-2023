package ExamPrep;

import java.util.*;
import java.util.stream.Collectors;

public class EnergyDrinks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> firstLine = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        ArrayDeque<Integer> milligramsOfCaffeine = new ArrayDeque<>();
        firstLine.forEach(e -> milligramsOfCaffeine.push(e));
        List<Integer> secondLine = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        ArrayDeque<Integer> energyDrinks = new ArrayDeque<>();
        secondLine.forEach(e -> energyDrinks.offer(e));
        int result;
        int stamatsCoffeine=0;
        int remaider=300;

        while (!energyDrinks.isEmpty() && !milligramsOfCaffeine.isEmpty()) {
            result = milligramsOfCaffeine.peek() * energyDrinks.peek();

            if( result<=remaider){
                milligramsOfCaffeine.pop();
                energyDrinks.poll();
                stamatsCoffeine += result;
                remaider-=result;
            }else{
                milligramsOfCaffeine.pop();
                int removedDrink=energyDrinks.poll();
                energyDrinks.offer(removedDrink);
                if(stamatsCoffeine>30) {
                    stamatsCoffeine -= 30;
                    remaider+=30;
                }
            }

        }
        if(!energyDrinks.isEmpty()){
            List<String>resultToPrint=new ArrayList<>();
            energyDrinks.forEach(e->resultToPrint.add(e+""));
            System.out.println("Drinks left: "+ String.join(", ",resultToPrint));
        }else{
            System.out.println("At least Stamat wasn't exceeding the maximum caffeine.");
        }
        System.out.printf("Stamat is going to sleep with %d mg caffeine.",stamatsCoffeine);

    }
}
