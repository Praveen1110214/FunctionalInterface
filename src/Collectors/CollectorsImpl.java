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
                new Employee("Alice", 25, "IT", 20000, List.of("Java", "React")),
                new Employee("Bob", 26, "Data Center", 25000, List.of("SpringBoot", "Spring")),
                new Employee("Charlie", 27, "IT", 30000, List.of("Python", "Java")),
                new Employee("Alice", 30, "Networking", 80000, List.of("Kubernetes", "Python"))
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

        List<String> employeeNames = employees.stream()
                .map(employee -> employee.getName())
                .toList();
        System.out.println(employeeNames);

        List<String> employeeNamesUsingMapping = employees.stream()
                .collect(Collectors.mapping(
                        employee -> employee.getName(),
                        Collectors.toList()
                ));
        System.out.println(employeeNamesUsingMapping);

        Map<String, Long> departmentCount = employees.stream()
                .collect(
                        Collectors.groupingBy(
                                employee -> employee.getDepartment(),
                                Collectors.counting()
                        )
                );
        System.out.println(departmentCount);

        Map<String, List<String>> departmentToEmployeeList = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.filtering(
                                employee -> employee.getSalary() > 20000,
                                Collectors.mapping(
                                        employee -> employee.getName(),
                                        Collectors.toList()
                                )
                        )
                ));

        List<List<String>> skills = List.of(List.of("Java", "Python"), List.of("Networking", "Python"));
        Set<String> set = skills.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());
        System.out.println(set);

        Map<String, List<String>> flatMap = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getName,
                        Collectors.filtering(
                                employee -> employee.getSalary() > 20000,
                                Collectors.flatMapping(
                                        employee -> employee.getSkills().stream(),
                                        Collectors.toList()
                                )
                        )
                ));
        System.out.println(flatMap);

        Map<Boolean, List<String>> partition = employees.stream()
                .collect(Collectors.partitioningBy(
                        employee -> employee.getSalary() > 20000,
                        Collectors.mapping(
                                employee -> employee.getName(),
                                Collectors.toList()
                        )
                ));
        System.out.println(partition);
        System.out.println(employees.stream().collect(Collectors.summingInt(employee -> employee.getSalary())));

        List<Integer> marks = List.of(10,20,30,40,50);
        String mark = marks.stream()
                .collect(Collectors.teeing(
                        Collectors.summingInt(mark1 -> mark1),
                        Collectors.counting(),
                        (sum, count) ->
                            "Sum = " + sum + ", Count = " + count

                ));
        System.out.println(mark);

        String teeingResult = employees.stream()
                .collect(Collectors.teeing(
                        Collectors.averagingInt(
                                employee -> employee.getSalary()
                        ),
                        Collectors.maxBy(
                                Comparator.comparing(employee -> employee.getSalary())
                        ),
                        (average, max) -> "Average = " + average + ", Max = " +
                                max.map(employee -> employee.getName()).orElse("None")
                ));
        System.out.println(teeingResult);
    }
}
