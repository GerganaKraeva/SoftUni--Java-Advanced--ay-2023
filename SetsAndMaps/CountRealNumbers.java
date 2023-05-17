package SetsAndMapsAdvancedLab;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        double[] numbers= Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();
        Map<Double,Integer>occurrenceOfNumbers=new LinkedHashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            double currentNumber=numbers[i];
            if(!occurrenceOfNumbers.containsKey(currentNumber)){
               occurrenceOfNumbers.put(currentNumber,1);
            }else{
                int currentValue=occurrenceOfNumbers.get(currentNumber);
                occurrenceOfNumbers.put(currentNumber,currentValue+1);
            }
        }
        for (Double number : occurrenceOfNumbers.keySet()) {
            System.out.printf("%.1f -> %d\n",number,occurrenceOfNumbers.get(number));
        }
    }
}
