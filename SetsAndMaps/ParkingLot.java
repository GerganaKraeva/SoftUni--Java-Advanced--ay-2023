package SetsAndMapsAdvancedLab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String command=scanner.nextLine();
        Set<String>carsNumbers=new LinkedHashSet<>();

        while (!command.equals("END")) {
            String[] userInput = command.split(", ");
            String direction = userInput[0];
            String number = userInput[1];

            if(direction.equals("IN")){
                carsNumbers.add(number);
            }else if(direction.equals("OUT")){
                carsNumbers.remove(number);
            }
            command=scanner.nextLine();
        }
        if(carsNumbers.isEmpty()){
            System.out.println("Parking Lot is Empty");
        }else{
            for (String carsNumber : carsNumbers) {
                System.out.println(carsNumber);
            }
        }
    }
}
