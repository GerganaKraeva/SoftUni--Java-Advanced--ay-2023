package FunctionalProgramming.FunctionalProgrammingEx;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfInt = Integer.parseInt(scanner.nextLine());
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
//        for (int i = 1; i <= numberOfInt; i++) {
//            int current = i;
//            Predicate<Integer> isDivisible = number -> current%number == 0;
//           if(numbers.stream().allMatch(isDivisible)){
//               System.out.print(i+" ");
//           };
//        }

        BiFunction<List<Integer>, Integer, Boolean> isDivisible = ((list, number) -> {
            for (Integer num : list) {
                if (number % num != 0) {
                    return false;
                }
            }
            return true;
        });
        for (int i = 1; i <= numberOfInt; i++) {

            if (isDivisible.apply(numbers, i)) {
                System.out.print(i + " ");
            }
        }
    }
}