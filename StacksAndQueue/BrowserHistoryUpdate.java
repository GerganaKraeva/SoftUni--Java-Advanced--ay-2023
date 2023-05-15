package StacksAndQueue;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpdate {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String userInput=scanner.nextLine();
        ArrayDeque<String>queue=new ArrayDeque<>();

        while(!userInput.equals("Home")){

            if(userInput.equals("forward")){
                if(queue.isEmpty()){
                    System.out.println("no next URLs");
                }else {
                    System.out.println(queue.peek());
                }


            }else if(userInput.equals("back")){
                if(queue.isEmpty()){
                    System.out.println("no next URLs");
                }else {
                    String deletedUrl = queue.poll();
                    System.out.println(queue.peek());
                    queue.offer(deletedUrl);
                }
            }else{
                queue.offer(userInput);
                System.out.println(userInput);
            }
            userInput= scanner.nextLine();
        }
    }
}
