import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class MonsterExtermination {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> armorOfMonsters = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(","))
                .mapToInt(Integer::parseInt)
                .forEach(armorOfMonsters::offer);

        ArrayDeque<Integer> soldersImpact = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(","))
                .mapToInt(Integer::parseInt)
                .forEach(soldersImpact::push);
        int killedMonstersCount = 0;

        while (!armorOfMonsters.isEmpty() && !soldersImpact.isEmpty()) {

            int armorValue = armorOfMonsters.poll();
            int strengthValue = soldersImpact.pop();

            if (strengthValue > armorValue) {
                killedMonstersCount++;
                if ( !soldersImpact.isEmpty()) {
                    int previousStrength = soldersImpact.pop();
                    soldersImpact.push(previousStrength + strengthValue - armorValue);
                }
            } else {
                armorOfMonsters.offer(armorValue - strengthValue);
            }
        }
        if (armorOfMonsters.isEmpty()) {
            System.out.println("All monsters have been killed!");
        }
        if (soldersImpact.isEmpty() && !armorOfMonsters.isEmpty()) {
            System.out.println("The soldier has been defeated.");
        }
        System.out.printf("Total monsters killed: %d", killedMonstersCount);

    }
}