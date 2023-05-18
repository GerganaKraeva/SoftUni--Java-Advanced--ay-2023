package SetsAndMapsAdvancedEx;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class PhoneBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String data = scanner.nextLine();
        boolean isFound = false;
        Map<String, String> phoneNumbers = new TreeMap<>();

        while (!data.equals("search")) {
            String[] contactInfo = data.split("\\-");
            phoneNumbers.put(contactInfo[0], contactInfo[1]);
            data = scanner.nextLine();
        }
        String forSearch = scanner.nextLine();
        while (!forSearch.equals("stop")) {
            if (phoneNumbers.containsKey(forSearch)) {
                System.out.printf("%s -> %s\n", forSearch, phoneNumbers.get(forSearch));
            } else {
                System.out.printf("Contact %s does not exist.\n", forSearch);
            }
            forSearch=scanner.nextLine();
        }
    }
}
