package FunctionalProgramming.FunctionalProgrammingEx;

import java.util.*;
import java.util.stream.Collectors;

public class CustomComparator {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        List<Integer>numbers= Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        Comparator<Integer>comparator=(num1,num2)->{
            if(num1%2==0 && num2%2!=0){
                return -1;
            }else if(num1%2!=0 &&num2%2==0){
                return 1;
            }else {
                return num1.compareTo(num2);
            }
        };
        numbers.sort(comparator);
        numbers.forEach(e-> System.out.print(e+" "));
    }
}
