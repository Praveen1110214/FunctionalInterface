package Employee;

public class Employee {
    private final String name;
    private final Integer age;
    private final String department;

    public Employee(String name, Integer age, String department){
        this.name = name;
        this.age = age;
        this.department = department;
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
}