
package SetsAndMapsAdvancedEx;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmail {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        Map<String, String> namesAndEmail = new LinkedHashMap<>();

        while (!userInput.equals("stop")) {
            String userInput2 = scanner.nextLine();
            if (!userInput2.endsWith("us") && !userInput2.endsWith("uk") && !userInput2.endsWith("com")) {
                namesAndEmail.put(userInput, userInput2);
            }
            userInput = scanner.nextLine();
        }
        namesAndEmail.entrySet().forEach(entry-> System.out.printf("%s -> %s\n",entry.getKey(),entry.getValue()));
    }
}

//Вариант 2
//package SetsAndMapsAdvancedEx;
//import java.util.HashMap;
//import java.util.LinkedHashMap;
//import java.util.Map;
//import java.util.Scanner;
//
//public class FixEmail {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String userInput = scanner.nextLine();
//        Map<String, String> namesAndEmail = new LinkedHashMap<>();
//
//        while (!userInput.equals("stop")) {
//            String userInput2 = scanner.nextLine();
//            namesAndEmail.put(userInput, userInput2);
//            userInput=scanner.nextLine();
//        }
//       namesAndEmail.entrySet().removeIf(entry->entry.getValue().endsWith("uk")||entry.getValue().endsWith("com")||
//               entry.getValue().endsWith("us"));
//        namesAndEmail.entrySet().forEach(entry-> System.out.printf("%s -> %s\n",entry.getKey(),entry.getValue()));
//    }
//}