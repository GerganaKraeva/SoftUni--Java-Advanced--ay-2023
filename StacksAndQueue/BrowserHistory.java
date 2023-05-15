package StacksAndQueue;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        ArrayDeque<String> urls = new ArrayDeque();

        while (!command.equals("Home")) {
            if (command.equals("back")) {
                if (urls.size() > 1) {
                    urls.pop();
                    String previousUrls = urls.peek();
                    System.out.println(previousUrls);
                } else {
                    System.out.println("no previous URLs");
                }
            } else {
                urls.push(command);
                String current = urls.peek();
                System.out.println(current);
            }
            command = scanner.nextLine();
        }
    }
}
