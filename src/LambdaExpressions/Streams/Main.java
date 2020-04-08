package LambdaExpressions.Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        List<String> someBingoNumbres = Arrays.asList(
                "N40", "N36",
                "B12", "B6",
                "G53", "G49", "G60", "G50", "g64",
                "I26", "I17", "I29",
                "O71");

        /* Using lambdas to:
        * Create a list that will store only G bingo numbers.
        * Add them
        * Sort them
        * Print them
        * It is done in 4 statements, with streams, we can do it on 1.
        * */

//        List<String> gNumbers = new ArrayList<>();
//
//        someBingoNumbres.forEach(number -> {
//            if (number.toUpperCase().startsWith("G")) {
//
//                gNumbers.add(number);
//            }
//        });
//
//        gNumbers.sort((s1, s2) -> s1.compareTo(s2));
//        gNumbers.forEach(s -> System.out.println(s));

        someBingoNumbres.stream()
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("G"))
                .sorted()
                .forEach(System.out::println);

        /* Creating a stream from scratch: */

        Stream<String> ioNumberStream = Stream.of("I26", "I17", "I29", "071");
        Stream<String> inNumberStream = Stream.of("N40", "N36", "I26", "I17", "I29", "O71");

        Stream<String> concatStream = Stream.concat(ioNumberStream, inNumberStream);

        System.out.println("-------------------------------------");
        System.out.println(concatStream
                .distinct()
                .peek(System.out::println)
                .count());

        /* Flat map usage */

        Employee john = new Employee("John Doe", 30);
        Employee jane = new Employee("Jane Deer", 22);
        Employee jack = new Employee("Jack Hill", 40);
        Employee snow = new Employee("Snow White", 22);

        Department hr = new Department("Human Resources");
        hr.addEmployee(jane);
        hr.addEmployee(jack);
        hr.addEmployee(snow);

        Department counting = new Department("Accounting");
        counting.addEmployee(john);

        List<Department> departments = new ArrayList<>();
        departments.add(hr);
        departments.add(counting);

        departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .forEach(System.out::println);

        /* Usage of collect terminal operation, converting the resulting stream of sorted bingo numbers into an arraylist:  */

        System.out.println("-------------------------------------");
        List<String> sortedGNumbers = someBingoNumbres
                .stream()
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("G"))
                .sorted()
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        sortedGNumbers.forEach(System.out::println);

        System.out.println("-------------------------------------");

        /* Using the groupingBy method to get a Map which the keys are the employeees age
        * and the value is the list of employees with that age: */

        Map<Integer, List<Employee>> groupedByAge = departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .collect(Collectors.groupingBy(Employee::getAge)); // or it can be Collectors.groupingBy(employee -> employee.getAge());

        for (Integer key : groupedByAge.keySet()) {

            System.out.println("Employees with age of " + key + ":");
            groupedByAge.get(key).forEach(employee -> System.out.println(employee.getName()));
        }
    }
}
