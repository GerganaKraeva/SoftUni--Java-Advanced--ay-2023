package FunctionalProgramming.FunctionalProgrammingEx;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
      Integer[] numbers=Arrays.stream(scanner.nextLine().split("\\s+"))
              .map(Integer::parseInt)
              .toArray(Integer[]::new);
//      Function<Integer[],Integer>minNumber=allNumbers->{
//          int current=Integer.MAX_VALUE;
//          for (Integer number : allNumbers) {
//              if(number<=current){
//                  current=number;
//              }
//          }
//          return current;
//      };

        Function<Integer[],Integer>minNumber=allNumbers->
                Arrays.stream(allNumbers).mapToInt(e->e).min().getAsInt();
        System.out.println(minNumber.apply(numbers));
    }
}
