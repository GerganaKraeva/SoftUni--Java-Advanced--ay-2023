package FunctionalProgramming.FunctionalProgrammingLab;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        List<Integer>numbers= Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Integer::parseInt)
                .filter(e->e%2==0)
                .collect(Collectors.toList());
        System.out.println(numbers.stream().map(e->e+"").collect(Collectors.joining(", ")));
        Collections.sort(numbers);
        System.out.println(numbers.stream().map(e->e+"").collect(Collectors.joining(", ")));
    }
}
