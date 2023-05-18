package SetsAndMapsAdvancedEx;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class countSymbol {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        char []userInput=scanner.nextLine().toCharArray();
        Map<Character,Integer>symbols=new TreeMap<>();

        for (int i = 0; i < userInput.length; i++) {
            char currentSymbol=userInput[i];
            if(!symbols.containsKey(currentSymbol)){
                symbols.put(currentSymbol,1);
            }else{
                int count=symbols.get(currentSymbol);
                symbols.put(currentSymbol,count+1);
            }
        }
        for (Character symbol : symbols.keySet()) {
            System.out.printf("%c: %d time/s\n",symbol,symbols.get(symbol));
        }


    }
}
