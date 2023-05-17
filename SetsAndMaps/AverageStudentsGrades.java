package SetsAndMapsAdvancedLab;

import java.util.*;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>>allStudent= new TreeMap<>();
        Map<String, Double>avgGrade= new TreeMap<>();

        for (int i = 1; i <= n; i++) {
            String[] studentInfo=scanner.nextLine().split("\\s+");
            String studentName=studentInfo[0];
            double grade=Double.parseDouble(studentInfo[1]);
            if(!allStudent.containsKey(studentName)){
                allStudent.put(studentName,new ArrayList<>());
            }
            allStudent.get(studentName).add(grade);
            if(!avgGrade.containsKey(studentName)) {
                avgGrade.put(studentName, grade);
            }
        }
        System.out.println();
        for (String name : allStudent.keySet()) {
            System.out.printf("%s -> ",name);
            for (Double grade : allStudent.get(name)) {
                System.out.printf("%.2f ",grade);
            }
            double avg=getAvgGrade(allStudent.get(name));
            System.out.printf("(avg: %.2f)\n",avg);
        }
    }
    private static double getAvgGrade(List<Double> grades) {
        double sumOfGrade=0;
        int count=0;
        for (Double grade : grades) {
            sumOfGrade+=grade;
            count++;
        }
        double  avgGrade=sumOfGrade/count;
        return avgGrade;
    }
}
