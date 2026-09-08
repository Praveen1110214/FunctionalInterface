package Comparator;

import Employee.Employee;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ComparatorImpl implements Comparator<Employee>{

    @Override
    public int compare(Employee employee1, Employee employee2) {
       return Integer.compare(employee1.getSalary(), employee2.getSalary());
    }
    public static void main(String[] args) {
        Comparator<Integer> comparator = Integer::compare;
        System.out.println(comparator.compare(10, 20));
        List<Employee> employees = List.of(
                new Employee("Alice", 25, "IT", 20000, List.of("Java", "React")),
                new Employee("Bob", 26, "Data Center", 25000, List.of("SpringBoot", "Spring")),
                new Employee("Charlie", 27, "IT", 30000, List.of("Python", "Java")),
                new Employee("Alice", 30, "Networking", 80000, List.of("Kubernetes", "Python"))
        );
        Comparator<Employee> salaryComparator = Comparator.comparingInt(employee -> employee.getSalary());
        employees.stream().sorted(salaryComparator.reversed()).forEach(employee -> System.out.println(employee.getName()));
        employees.stream().sorted(Comparator.comparing((Employee employee) -> employee.getDepartment())
                        .thenComparing(employee -> employee.getAge()))
                .forEach(employee -> System.out.println(employee.getName()));

        Comparator<Employee> nameComparator = Comparator.comparing(Employee::getName)
                .thenComparing(Employee::getSalary);
        System.out.println(employees.stream().sorted(nameComparator).map(employee -> employee.getName()).toList());
        Comparator<Employee> ageComparator = Comparator.comparing((Employee employee) -> employee.getAge())
                .thenComparing(employee -> employee.getName());
        System.out.println(
            employees.stream().sorted(ageComparator).collect(Collectors.mapping(
                    Employee::getName,
                    Collectors.toList()
            ))
        );
        System.out.println(
                employees.stream()
                        .sorted(ageComparator)
                        .map(employee -> employee.getDepartment())
                        .toList()
        );

        Map<String, String> highestPaidEmployeeInEachDepartment =
                employees.stream()
                        .collect(
                                Collectors.groupingBy(
                                        employee -> employee.getDepartment(),
                                        Collectors.collectingAndThen(
                                                Collectors.maxBy(Comparator.comparingInt(Employee::getSalary)),
                                                optionalEmployee -> optionalEmployee.get().getName()
                                        )
                                )
                        );
        System.out.println(highestPaidEmployeeInEachDepartment);

        AgeComparator ageComparator1 = new AgeComparator();
        employees.stream()
                .sorted(ageComparator1)
                .forEach(employee -> System.out.println(employee.getName()));
        employees.stream()
                .sorted(Comparator.comparingInt(Employee::getAge))
                .forEach(employee -> System.out.println(employee.getName()));
    }
}