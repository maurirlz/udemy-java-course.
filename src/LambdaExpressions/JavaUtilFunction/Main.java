package LambdaExpressions.JavaUtilFunction;

import LambdaExpressions.Introduction.Employee;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {

        Employee mauricio = new Employee("Mauricio Benitez", 23);
        Employee lucas = new Employee("Lucas Frias", 24);
        Employee bruzzo = new Employee("Fernando Bruzzo", 30);
        Employee mauri = new Employee("Mauricio Caravaglia", 21);
        Employee gaona = new Employee("German Gaona", 45);
        Employee luro = new Employee("Luro", 41);

        List<Employee> employees = new ArrayList<>();
        employees.add(mauricio);
        employees.add(lucas);
        employees.add(bruzzo);
        employees.add(mauri);
        employees.add(gaona);
        employees.add(luro);

        printEmployeessByAge(employees, "Employees with age < 25", employee -> employee.getAge() < 25);
        System.out.println("--------------------------------------------------------------------------------------------");
        printEmployeessByAge(employees, "Employees with age > 40", employee -> employee.getAge() > 40);
    }

    private static void printEmployeessByAge(List<Employee> employees,
                                             String ageText,
                                            Predicate<Employee> ageCondition) {

        System.out.println(ageText);
        for (Employee employee : employees) {
            if (ageCondition.test(employee)) {

                System.out.println(employee.getName());
            }
        }
    }
}
