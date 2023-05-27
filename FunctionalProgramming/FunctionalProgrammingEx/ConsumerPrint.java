package FunctionalProgramming.FunctionalProgrammingEx;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class ConsumerPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    List<String> userText =Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        Consumer<String>printWord=word-> System.out.println(word+" ");
//        for (String currentWord : userText) {
//            printWord.accept(currentWord);
//        }
        userText.forEach(word->printWord.accept(word));
    }
}
