package Collectors;

import java.util.*;
import java.util.stream.Collectors;
import Employee.Employee;

public class CollectorsImpl {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> result = numbers.stream()
                .filter(number -> number % 2 == 0)
                .toList();
        //.collect(Collectors.toList());
        Set<Integer> resultSet = numbers.stream()
                .collect(Collectors.toSet());
        // equivalent to new HashSet<>(numbers);
        TreeSet<Integer> resultTreeSet = numbers.stream()
                .collect(Collectors.toCollection(TreeSet::new));
        // equivalent to new TreeSet<>(numbers);
        List<String> names = List.of("Java", "Springboot", "Docker");
        String resultString = names.stream()
                .collect(Collectors.joining());
        // same as String.join("", names);
        long numbersCount = numbers.stream().collect(Collectors.counting());
        //same as numbers.stream().count();
        int numbersSum = numbers.stream()
                .collect(Collectors.summingInt(n -> n));
        //same as numbers.stream().mapToInt(n -> n).sum();
        IntSummaryStatistics statistics = numbers.stream().collect(Collectors.summarizingInt(n -> n));
        System.out.println(statistics.getMax());
        System.out.println(statistics.getMin());
        System.out.println(statistics.getAverage());
        System.out.println(statistics.getCount());
        System.out.println(statistics.getSum());
        List<Employee> employees = List.of(
                new Employee("Alice", 25, "IT"),
                new Employee("Bob", 26, "Data Center"),
                new Employee("Charlie", 27, "IT"),
                new Employee("Alice", 30, "Networking")
        );

        Map<String, Employee> map = employees.stream()
                .collect(Collectors.toMap(
                        employee -> employee.getName(),
                        employee -> employee,
                        (employee1, employee2) -> employee1
                ));
        System.out.println(map);

        Map<String, List<Employee>> employeeMap = employees.stream()
                .collect(Collectors.groupingBy(
                        employee -> employee.getDepartment()
                ));
        System.out.println(employeeMap);

        Map<String, List<String>> employeeMap1 = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.mapping(
                                employee -> employee.getName(),
                                Collectors.toList()
                        )
                ));
        System.out.println(employeeMap1);
    }
}
