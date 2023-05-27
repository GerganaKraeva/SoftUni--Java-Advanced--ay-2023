package FunctionalProgramming.FunctionalProgrammingEx;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AppliedArithmetic {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        List<Integer> numbers= Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        String userInput=scanner.nextLine();
        Consumer<List<Integer>>print=list->list.forEach(num-> System.out.print(num+" "));
        Function<List<Integer>,List<Integer>>subtract=currentList->currentList.stream().map(num->num-1).collect(Collectors.toList());
        Function<List<Integer>,List<Integer>>multiply=currentList->currentList.stream().map(num->num*2).collect(Collectors.toList());
        Function<List<Integer>,List<Integer>>add=currentList->currentList.stream().map(num->num+1).collect(Collectors.toList());
        while (!userInput.equals("end")){
            if(userInput.equals("print")){
                print.accept(numbers);
                System.out.println();
            }else if(userInput.equals("subtract")){
                numbers=subtract.apply(numbers);
            }else if(userInput.equals("multiply")){
                numbers=multiply.apply(numbers);
            }else if(userInput.equals("add")){
                numbers=add.apply(numbers);
            }
            userInput=scanner.nextLine();
        }
    }
}
