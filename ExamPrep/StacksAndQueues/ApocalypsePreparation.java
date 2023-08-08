package ExamPrep;
import java.util.*;

public class ApocalypsePreparation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] firstLine = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] secondLine = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        ArrayDeque<Integer> valueOfTextileQueue = new ArrayDeque<>();
        ArrayDeque<Integer> valueOfMedicamentsStack = new ArrayDeque<>();
        Map<String, Integer> info = new TreeMap<>();
        info.put("Patch", 0);
        info.put("Bandage", 0);
        info.put("MedKit", 0);
        for (int item : firstLine) {
            valueOfTextileQueue.offer(item);
        }
        for (int item : secondLine) {
            valueOfMedicamentsStack.push(item);
        }
        int sum = 0;
        while (!valueOfMedicamentsStack.isEmpty() && !valueOfTextileQueue.isEmpty()) {
            int textileValue = valueOfTextileQueue.poll();
            int medicaments = valueOfMedicamentsStack.pop();
            sum = textileValue + medicaments;
            if (sum == 30) {
                int count = info.get("Patch") + 1;
                info.put("Patch", count);
            } else if (sum == 40) {
                int count = info.get("Bandage") + 1;
                info.put("Bandage", count);
            } else if (sum == 100) {
                int count = info.get("MedKit") + 1;
                info.put("MedKit", count);
            } else if (sum > 100) {
                int count = info.get("MedKit") + 1;
                info.put("MedKit", count);
                int previousValue = valueOfMedicamentsStack.poll();
                valueOfMedicamentsStack.push(previousValue + sum - 100);
            } else {
                valueOfMedicamentsStack.push(medicaments + 10);
            }
        }
        if (valueOfMedicamentsStack.isEmpty() && valueOfTextileQueue.isEmpty()) {
            System.out.println("Textiles and medicaments are both empty.");
        } else if (valueOfTextileQueue.isEmpty()) {
            System.out.println("Textiles are empty.");
        } else if (valueOfMedicamentsStack.isEmpty()) {
            System.out.println("Medicaments are empty.");
        }
        info.entrySet().removeIf(entry -> entry.getValue() == 0);
        info.entrySet().stream().sorted((n1, n2) -> n2.getValue().compareTo(n1.getValue())).forEach(entry -> System.out.printf("%s - %d\n", entry.getKey(), entry.getValue()));
        if (!valueOfMedicamentsStack.isEmpty()) {
            System.out.print("Medicaments left: ");
            StringBuilder result=new StringBuilder();
            for (Integer item : valueOfMedicamentsStack) {
                result.append(item);
                result.append(", ");
            }
            result.deleteCharAt(result.length()-2);
            System.out.println(result);
        }
        if (!valueOfTextileQueue.isEmpty()) {
            System.out.print("Textiles left: ");
            StringBuilder result=new StringBuilder();
            for (Integer item : valueOfTextileQueue) {
                result.append(item);
                result.append(", ");
            }
            result.deleteCharAt(result.length()-2);
            System.out.println(result);
        }
    }
}
