package softUni;

import java.util.ArrayList;
import java.util.List;

public class SoftUni {
    private int capacity;
    private List<Student> data = new ArrayList<>();
    private List<Student> students;

    public SoftUni(int capacity) {
        this.capacity = capacity;
        this.data = data;
        this.students = new ArrayList<>();
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int getCount() {
        return data.size();
    }

    public String insert(Student student) {
        if (this.data.size() < this.capacity) {
            for (Student students : this.data) {
                if (students.getFirstName().equals(student.getFirstName()) && students.getLastName().equals(student.getLastName())) {
                    return "Student is already in the hall.";
                }
            }
            this.data.add(student);
            return String.format("Added student %s %s.", student.getFirstName(), student.getLastName());
        }
        return "The hall is full.";
    }

    public String remove(Student student) {
        for (Student students : this.data) {
            if (students.getFirstName().equals(student.getFirstName()) && students.getLastName().equals(student.getLastName())) {
                this.data.remove(student);
                return String.format("Removed student %s %s.", student.getFirstName(), student.getLastName());
            }
        }
        return "Student not found.";
    }

    public Student getStudent(String firstName, String lastName) {
        for (Student students : this.data) {
            if (students.getFirstName().equals(firstName) && students.getLastName().equals(lastName)) {
                return students;

            }
        }
        return null;
    }
    public String getStatistics(){
        StringBuilder sb=new StringBuilder();
        sb.append(String.format("Hall size: %d",this.data.size())).append(System.lineSeparator());
        this.data.forEach(e->sb.append(e).append(System.lineSeparator()));
        return sb.toString();
    }
}
