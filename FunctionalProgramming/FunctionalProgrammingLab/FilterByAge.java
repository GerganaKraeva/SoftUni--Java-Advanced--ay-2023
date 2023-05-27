package FunctionalProgramming.FunctionalProgrammingLab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Consumer;


public class FilterByAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> personInfo = new LinkedHashMap<>();

        for (int i = 1; i <= n; i++) {
            String[] info = scanner.nextLine().split(",\\s+");
            String name = info[0];
            int age = Integer.parseInt(info[1]);
            personInfo.put(name, age);
        }
        String condition = scanner.nextLine();
        int ageBorder = Integer.parseInt(scanner.nextLine());
        String whatToPrint = scanner.nextLine();
        BiPredicate<Integer, Integer> filterPredicate;
        if (condition.equals("younger")) {
            filterPredicate = (personAge, age) -> personAge <= age;
        } else {
            filterPredicate = (personAge, age) -> personAge >= age;
        }

        Consumer<Map.Entry<String, Integer>> printConsumer;
        if (whatToPrint.equals("name")) {
            printConsumer = person -> System.out.println(person.getKey());
        } else if (whatToPrint.equals("age")) {
            printConsumer = person -> System.out.println(person.getValue());
        } else {
            printConsumer = person -> System.out.println(person.getKey() + " - " + person.getValue());
        }
        personInfo.entrySet()
                .stream()
                .filter(person -> filterPredicate.test(person.getValue(), ageBorder))
                .forEach(printConsumer);

    }
}
