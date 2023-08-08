package ExamPrep;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class KAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> firstLine = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        ArrayDeque<Integer> licensePlate = new ArrayDeque<>();
        firstLine.forEach(e -> licensePlate.offer(e));
        int totalLicenseSum=0;
        for (Integer license : licensePlate) {
            totalLicenseSum+=license;
        }
        List<Integer> cars = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int totalCars=0;
        for (Integer car : cars) {
            totalCars+=car;
        }
        int countRegisterCars = 0;
        int days=0;

        while (!licensePlate.isEmpty() && cars.size()!=0) {
            int firstLicensePlate = licensePlate.poll();
            int lastCars = cars.remove(cars.size()-1);
            days++;

            if ((lastCars * 2) == firstLicensePlate) {
                countRegisterCars += lastCars;
            } else if (2* lastCars > firstLicensePlate) {
                countRegisterCars += firstLicensePlate / 2;
                int toAdd=lastCars-firstLicensePlate/2;
                cars.add(0,toAdd);
            } else {
                countRegisterCars += lastCars;
                int toAdd=firstLicensePlate-lastCars*2;
                licensePlate.offer(toAdd);
            }
        }
        System.out.printf("%d cars were registered for %d days!\n",countRegisterCars,days);
        if(!licensePlate.isEmpty()){
            System.out.printf("%d license plates remain!\n",totalLicenseSum-totalCars*2);
        }
        if(cars.size()!=0){
            System.out.printf("%d cars remain without license plates!",totalCars-countRegisterCars);
        }

        if(cars.isEmpty() && licensePlate.isEmpty()){
            System.out.println("Good job! There is no queue in front of the KAT!");
        }
    }
}
