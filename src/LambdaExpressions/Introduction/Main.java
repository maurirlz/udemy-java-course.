package LambdaExpressions.Introduction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Employee mauricio = new Employee("Mauricio Benitez", 23);
        Employee lucas = new Employee("Lucas Frias", 24);
        Employee bruzzo = new Employee("Fernando Bruzzo", 30);
        Employee mauri = new Employee("Mauricio Caravaglia", 21);

        List<Employee> employees = new ArrayList<>();
        employees.add(mauricio);
        employees.add(lucas);
        employees.add(bruzzo);
        employees.add(mauri);

//         Sort mediante clase anonima para instanciar una clase que implementa comparator:
//        employees.sort(new Comparator<Employee>() {
//            @Override
//            public int compare(Employee o1, Employee o2) {
//                return o1.getName().compareTo(o2.getName());
//            }
//        });

        Collections.sort(employees, Comparator.comparing(Employee::getName));

        employees.forEach(employee -> {
            System.out.println(employee.getName() + ", Age: " + employee.getAge());
        });

//        String sillyString = doStringStuff(new UpperConcat() {
//            @Override
//            public String upperAndConcat(String s1, String s2) {
//                return s1.toUpperCase() + s2.toUpperCase();
//            }
//        }, employees.get(0).getName(), employees.get(1).getName());

        UpperConcat uc = (s1, s2) -> {
            String result = s1.toUpperCase() + " " + s2.toUpperCase();
            return result;
        };

        String sillyString = doStringStuff(uc, employees.get(0).getName(), employees.get(1).getName());
        System.out.println(sillyString);

        AnotherClass anotherClass = new AnotherClass();
        String s = anotherClass.doSomething();
        System.out.println(s);
    }

    public static String doStringStuff(UpperConcat uc, String s1, String s2) {

        return uc.upperAndConcat(s1, s2);
    }
}

