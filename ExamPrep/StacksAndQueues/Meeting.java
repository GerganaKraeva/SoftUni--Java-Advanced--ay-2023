package ExamPrep;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Meeting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> male = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(male::push);
        ArrayDeque<Integer> female = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(female::offer);

        int match = 0;

        while (!male.isEmpty() && !female.isEmpty()) {
            int femaleValue = female.peek();
            int maleValue = male.peek();
            if (femaleValue == maleValue && femaleValue > 0) {
                female.poll();
                male.pop();
                match++;
            } else {
                if (femaleValue <= 0) {
                    female.poll();
                } else if (maleValue <= 0) {
                    male.pop();
                } else if (femaleValue % 25 == 0 || maleValue % 25 == 0) {
                    if (femaleValue % 25 == 0) {
                        female.poll();
                        female.poll();
                    } else {
                        male.pop();
                        male.pop();
                    }
                } else {
                    female.poll();
                    male.pop();
                    male.push(maleValue - 2);
                }
            }
        }
        System.out.println("Matches: "+match);
        String resultMale= male.isEmpty()
                ?"none"
                :male.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.printf("Males left: %s%n",resultMale);

        String resultFemale= female.isEmpty()
                ?"none"
                :female.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
            System.out.printf("Females left: %s%n",resultFemale);

    }
}
