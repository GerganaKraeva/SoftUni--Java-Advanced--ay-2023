package SetsAndMapsAdvancedLab;

import java.util.Scanner;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String arrivedGuest = scanner.nextLine();
        TreeSet<String>allGuests=new TreeSet<>();

        while (!arrivedGuest.equals("PARTY")){
            allGuests.add(arrivedGuest);
            arrivedGuest=scanner.nextLine();
        }
        String leftGuest=scanner.nextLine();
        while (!leftGuest.equals("END")){
            allGuests.remove(leftGuest);
            leftGuest=scanner.nextLine();
        }

        System.out.println(allGuests.size());
        allGuests.forEach(guest-> System.out.println(guest));
    }
}
