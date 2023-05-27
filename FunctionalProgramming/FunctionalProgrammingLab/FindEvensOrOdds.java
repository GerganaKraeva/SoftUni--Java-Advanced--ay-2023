package FunctionalProgramming.FunctionalProgrammingLab;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.*;
import java.util.stream.Collectors;

public class FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] userInput = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int start = userInput[0];
        int end = userInput[1];
        String oddOrEven = scanner.nextLine();
        List<Integer> result = getList(start, end);
        Consumer<List<Integer>>finalResult=toPrint->toPrint.forEach(e-> System.out.print(e+" "));
        if (oddOrEven.equals("odd")) {
            result=result.stream().filter(e->e%2!=0).collect(Collectors.toList());
            finalResult.accept(result);
        } else if (oddOrEven.equals("even")) {
            result=result.stream().filter(e->e%2==0).collect(Collectors.toList());
            finalResult.accept(result);
        }
    }
    private static List<Integer> getList(int start, int end) {
        List<Integer> currentList = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            currentList.add(i);
        }
        return currentList;
    }
}
