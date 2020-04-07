package LambdaExpressions.JavaUtilFunction;

import LambdaExpressions.Introduction.Employee;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;

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

        /* Basic usage of predicates: */

        printEmployeessByAge(employees, "Employees with age < 25", employee -> employee.getAge() < 25);
        System.out.println("--------------------------------------------------------------------------------------------");
        printEmployeessByAge(employees, "Employees with age > 40", employee -> employee.getAge() > 40);
        System.out.println("--------------------------------------------------------------------------------------------");

        /* Passing an anonymous class instead of a lambda as a predicate. */

        printEmployeessByAge(employees, "employees with age < 23", new Predicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getAge() < 25;
            }
        });

        /* Using an Integer predicate with and without a expression as a passed parameter: */

        IntPredicate intp = i -> i > 25;
        System.out.println(intp.test(10)); // outputs false cause 10 < 25

        int testNumber = 20;
        System.out.println(intp.test(testNumber + 5)); // prints true cause 20 + 5 >= 25

        /* Chaining of Predicates: */

        IntPredicate greaterThan15 = i -> i > 15;
        IntPredicate lessThan100 = i -> i < 100;
        System.out.println(greaterThan15.and(lessThan100).test(50)); // outputs true cause 50 > 15 && 50 < 100

        /* Supplier interface examples: */

        Random random = new Random();

//        for (int i = 0; i < 10; i++) {
//
//            System.out.println(random.nextInt(1000));
//        }

        Supplier<Integer> randomSupplier = () -> random.nextInt(1000);

        for (int i = 0; i < 10; i++) {

            System.out.println(randomSupplier.get());
        }

//        employees.forEach(employee -> {
//            String lastName = employee.getName().substring(employee.getName().indexOf(" ") + 1);
//            System.out.println("Last name is: " + lastName);
//        });

        /* Function interface usage:
        * in the diamond operator, first  type (Employee) is the argument's type.
        * the second type is the type of what the function
        * will return, in this case, a String. */

        Function<Employee, String> getLastName = (Employee employee) -> {

            String employeeName = employee.getName();
            return employeeName.substring(employeeName.indexOf(" ") + 1);
        };

//         String lastName = getLastName.apply(employees.get(1));
//        System.out.println(lastNamesi

        Function<Employee, String> getFirstName = (Employee employee) -> {

            return employee.getName().substring(0, employee.getName().indexOf(" "));
        };

        Random random1 = new Random();

        for (Employee employee : employees) {

            if (random1.nextBoolean()) {

                System.out.println(getAName(getFirstName, employee));
            } else {

                System.out.println(getAName(getLastName, employee));
            }
        }

        /* Function chaining demostration: */

        Function<Employee, String> upperCase = employee -> employee.getName().toUpperCase();
        Function<String, String> firstName = name -> name.substring(0, name.indexOf(" "));
        Function chainedFunction = upperCase.andThen(firstName); // compose function because calls the andThen method

        System.out.println(chainedFunction.apply(employees.get(0))); // outputs MAURICIO

    }

    private static String getAName(Function<Employee, String> getName, Employee employee) {

        return getName.apply(employee);
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
