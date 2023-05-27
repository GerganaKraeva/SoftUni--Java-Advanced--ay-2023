package FunctionalProgramming.FunctionalProgrammingLab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AddVat {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        List<Double>prices= Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Double::parseDouble)
                .map(e->1.2*e)
                .collect(Collectors.toList());
        System.out.println("Prices with VAT:");
        prices.forEach(price-> System.out.printf("%.2f\n",price));
    }
}
