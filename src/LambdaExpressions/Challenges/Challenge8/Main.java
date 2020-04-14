package LambdaExpressions.Challenges.Challenge8;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<String> topNames2015 = Arrays.asList(
                "Amelia",
                "Olivia",
                "emily",
                "Isla",
                "Ava",
                "oliver",
                "Jack",
                "Charlie",
                "harry",
                "Jacob"
        );

        List<String> firstUpperCaseList = new ArrayList<>(); // Arraylist for storing all the names with uppercase.
        Consumer<String> toUpperCaseFirstLetter = (String s) -> { // Consumer that will be passed as argument to topnames.ForEach call.

            firstUpperCaseList.add(s.substring(0, 1).toUpperCase() + s.substring(1));
        };

        topNames2015.forEach(toUpperCaseFirstLetter); // applying the consumer
        firstUpperCaseList.sort(String::compareTo);
        firstUpperCaseList.forEach(System.out::println);

        Set<String> finishedNames = topNames2015.stream()
                .map(name -> name.substring(0, 1).toUpperCase() + name.substring(1))
                .sorted(String::compareTo)
                .collect(HashSet::new, HashSet::add, HashSet::addAll);
    }
}
