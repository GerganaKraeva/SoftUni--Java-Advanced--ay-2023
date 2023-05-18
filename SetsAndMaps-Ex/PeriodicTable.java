package SetsAndMapsAdvancedEx;

import java.util.*;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Set<String> chemicalCompounds = new TreeSet<>();

        for (int i = 1; i <= n; i++) {
            String[] userInput = scanner.nextLine().split(" ");
            for (String element : userInput) {
                chemicalCompounds.add(element);
            }
        }
        chemicalCompounds.forEach(element-> System.out.print(element+" "));
    }
}
