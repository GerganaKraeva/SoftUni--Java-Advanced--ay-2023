package ExamPrep;

import java.util.*;
import java.util.stream.Collectors;

public class DuckDebugger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> time = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> numberOfTask = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        ArrayDeque<Integer> queueTime = new ArrayDeque<>();
        for (Integer progTime : time) {
            queueTime.offer(progTime);
        }
        ArrayDeque<Integer> queueTask = new ArrayDeque<>();
        for (Integer task : numberOfTask) {
            queueTask.push(task);
        }
        Map<String, Integer> rubberDuckyType = new LinkedHashMap<>();
        rubberDuckyType.put("Darth Vader Ducky", 0);
        rubberDuckyType.put("Thor Ducky", 0);
        rubberDuckyType.put("Big Blue Rubber Ducky", 0);
        rubberDuckyType.put("Small Yellow Rubber Ducky", 0);

        while (!queueTask.isEmpty() || !queueTime.isEmpty()) {

            int removedTime = queueTime.poll();
            int removedTask = queueTask.pop();
            int sum=removedTask*removedTime;
            if (sum > 0 && sum <= 60) {
                int count = rubberDuckyType.get("Darth Vader Ducky") + 1;
                rubberDuckyType.put("Darth Vader Ducky", count);
            } else if (sum <= 120) {
                int count = rubberDuckyType.get("Thor Ducky") + 1;
                rubberDuckyType.put("Thor Ducky", count);
            } else if (sum <= 180) {
                int count = rubberDuckyType.get("Big Blue Rubber Ducky") + 1;
                rubberDuckyType.put("Big Blue Rubber Ducky", count);
            } else if (sum <= 240) {
                int count = rubberDuckyType.get("Small Yellow Rubber Ducky") + 1;
                rubberDuckyType.put("Small Yellow Rubber Ducky", count);
            } else {
                queueTime.offer(removedTime);
                queueTask.push(removedTask - 2);
            }
        }
        System.out.println("Congratulations, all tasks have been completed! Rubber ducks rewarded:");
        rubberDuckyType.entrySet().forEach(entry-> System.out.println(entry.getKey()+": "+entry.getValue()));
    }
}
