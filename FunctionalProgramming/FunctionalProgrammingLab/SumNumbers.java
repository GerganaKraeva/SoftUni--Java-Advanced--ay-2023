package FunctionalProgramming.FunctionalProgrammingLab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int size = numbers.size();
        System.out.println("Count = "+size);
        Function<List<Integer>, Integer> sumOfNumbers = list -> {
            int sum = 0;
            for (Integer number : list) {
                sum += number;
            }
            return sum;
        };
        System.out.println("Sum = "+sumOfNumbers.apply(numbers));
    }
}
