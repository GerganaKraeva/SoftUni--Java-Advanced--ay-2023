package FunctionalProgramming.FunctionalProgrammingLab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
            List<String> inputText=  Arrays.stream(scanner.nextLine().split("\\s+"))
                    .collect(Collectors.toList());
        Predicate<String>isUpperCase=word->Character.isUpperCase(word.charAt(0));
        inputText=inputText.stream().filter(isUpperCase).collect(Collectors.toList());
        System.out.println(inputText.size());
        System.out.println(String.join("\n",inputText));
    }
}
