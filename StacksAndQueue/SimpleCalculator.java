package StacksAndQueue;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] elements = scanner.nextLine().split("\\s+");
        ArrayDeque<String> toSum = new ArrayDeque<>();
        int sum = 0;

        for (int i = elements.length - 1; i >= 0; i--) {
            toSum.push(elements[i]);
        }
        String number="";
        while (!toSum.isEmpty()){
            String element=toSum.pop();
            if(element.equals("+")||element.equals("-")){
                number+=element;
            }else{
                number+=element;
                sum+=Integer.parseInt(number);
                number="";
            }
        }
        System.out.println(sum);
    }
}
