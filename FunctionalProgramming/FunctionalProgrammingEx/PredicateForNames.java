package FunctionalProgramming.FunctionalProgrammingEx;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int lengthOfNames=Integer.parseInt(scanner.nextLine());
        List<String>names= Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());
        Predicate<String>isCorrectLength=name->name.length()<=lengthOfNames;
        names.stream().filter(isCorrectLength).forEach(e-> System.out.println(e));
    }
}
