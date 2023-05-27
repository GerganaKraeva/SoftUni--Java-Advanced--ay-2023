package FunctionalProgramming.FunctionalProgrammingEx;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> listOfPeople = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());
        String command = scanner.nextLine();
        Predicate<String> predicate = null;

        while (!command.equals("Party!")) {
            String criteria = command.split("\\s+")[2];

            if (command.contains("Length")) {
                predicate = x -> x.length() == Integer.parseInt(criteria);
            }else if(command.contains("StartsWith")){
                predicate = x -> x.startsWith(criteria);
            }else{
                predicate = x -> x.endsWith(criteria);
            }
            if (command.contains("Remove")){
                    ArrayList<String> toRemove = new ArrayList<>();
                    for (String person : listOfPeople) {
                        if(predicate.test(person)){
                            toRemove.add(person);
                        }
                    }
                    listOfPeople.removeAll(toRemove);
            }else{
                ArrayList<String> toAdd = new ArrayList<>();
                for (String person : listOfPeople) {
                    if(predicate.test(person)){
                        toAdd.add(person);
                    }
                }
                listOfPeople.addAll(toAdd);
            }
            command = scanner.nextLine();
        }
        if (listOfPeople.size() == 0) {
            System.out.println("Nobody is going to the party!");
        } else {
            Collections.sort(listOfPeople);
            System.out.print(String.join(", ", listOfPeople));
            System.out.println(" are going to the party!");
        }
    }
}

