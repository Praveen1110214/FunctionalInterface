package Employee;

import java.util.List;

public class Employee {
    private final String name;
    private final Integer age;
    private final String department;
    private final Integer salary;
    private final List<String> skills;

    public Employee(String name, Integer age, String department, Integer salary, List<String> skills){
        this.name = name;
        this.age = age;
        this.department = department;
        this.salary = salary;
        this.skills = skills;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getDepartment() {
        return department;
    }

    public Integer getSalary() {
        return salary;
    }

    public List<String> getSkills(){
        return skills;
    }
}