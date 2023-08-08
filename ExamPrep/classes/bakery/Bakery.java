package bakery;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Bakery {
    private String name;
    private int capacity;
    private List<Employee> employees;

    public Bakery(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees=new ArrayList<>();
    }
    public void add(Employee employee) {
        if(employees.size()<capacity) {
            employees.add(employee);
        }
    }
    public boolean remove(String name) {
        return employees.removeIf(p->p.getName().equals(name));
    }
    public Employee getOldestEmployee() {
        return Collections.max(employees, Comparator.comparingInt(Employee::getAge));
    }
    public Employee getEmployee(String name) {
       Employee employeeFound= employees.stream().filter(e->e.getName().equals(name)).findFirst().orElse(null);
       return employeeFound;
    }
    public int getCount() {
        return employees.size();
    }
    public String report() {
        StringBuilder sb=new StringBuilder();
        sb.append(String.format("Employees working at Bakery %s:",name));
        sb.append(System.lineSeparator());
        for (Employee empl : employees) {
            sb.append(empl).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
