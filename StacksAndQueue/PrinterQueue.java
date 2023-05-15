package StacksAndQueue;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String userInput=scanner.nextLine();
        ArrayDeque<String>queue=new ArrayDeque<>();

        while(!userInput.equals("print")){
            if(userInput.equals("cancel")){
                if(queue.size()==0){
                    System.out.println("Printer is on standby");
                }else{
                   String canceledItem= queue.poll();
                    System.out.println("Canceled "+canceledItem);
                }
            }else{
                queue.offer(userInput);
            }
            userInput=scanner.nextLine();
        }
        for (String item: queue) {
            System.out.println(item);
        }
    }
}
