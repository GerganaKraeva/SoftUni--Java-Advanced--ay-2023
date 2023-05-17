package SetsAndMapsAdvancedLab;
import java.text.DecimalFormat;
import java.util.*;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int numberOfStudents=Integer.parseInt(scanner.nextLine());
        Map<String, Double> studentsGrade=new TreeMap<>();
        for (int i = 1; i <=numberOfStudents ; i++) {
            String name=scanner.nextLine();
            double grade=Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToDouble(Double::parseDouble)
                    .average()
                    .getAsDouble();
            studentsGrade.put(name,grade);
        }
        for (String name : studentsGrade.keySet()) {
            DecimalFormat df=new DecimalFormat("#.###############");
            System.out.println(name+" is graduated with " +df.format(studentsGrade.get(name)));
        }
    }
}