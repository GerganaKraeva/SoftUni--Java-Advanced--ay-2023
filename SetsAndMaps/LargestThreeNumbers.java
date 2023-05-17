package SetsAndMapsAdvancedLab;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LargestThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .sorted((n1, n2) -> n2.compareTo(n1))
                .collect(Collectors.toList());
        int limit=Math.min(numbers.size(),3);
        for (int i = 0; i < limit; i++) {
            System.out.print(numbers.get(i)+" ");
        }

    }
}

