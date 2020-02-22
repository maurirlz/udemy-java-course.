package Collections.Sets.AsymmetricAndSymmetricSets;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetMain {

    public static void main(String[] args) {

        Set<Integer> squares = new HashSet<>();
        Set<Integer> cubes = new HashSet<>();

        for (int i = 1; i <= 100; i++) {

            squares.add(i * i);
            cubes.add(i * i * i);
        }

        System.out.println("There are " + squares.size() + " squares and " + cubes.size() + " cubes");

        Set<Integer> union = new HashSet<>(squares);

        union.addAll(cubes);
        System.out.println("Union constains " + union.size() + " elements");


        Set<Integer> intersection = new HashSet<>(squares);
        intersection.retainAll(cubes);
        System.out.println("Intersection contains " + intersection.size() + " elements");

        intersection.forEach(integer -> System.out.println(integer + " is square of " + Math.sqrt(integer) + " and the cube of " + Math.cbrt(integer)));

        String sentence = "one day in the year of the fox";
        String[] arrayWords = sentence.split(" ");
        Set<String> words = new HashSet<>(Arrays.asList(arrayWords));

//        words.forEach(System.out::println);

        String[] natureWords = {"all", "nature", "is", "art", "unknown", "to", "thee"};
        Set<String> nature = new HashSet<>(Arrays.asList(natureWords));

        String[] divineWords = {"to", "err", "is", "human", "to", "forgive", "divine"};
        Set<String> divine = new HashSet<>(Arrays.asList(divineWords));

//        System.out.println();
//        System.out.println("Nature - divine: ");
//        System.out.println();
        Set<String> diff1 = new HashSet<>(nature);
        diff1.removeAll(divine);
//        diff1.forEach(System.out::println);
//
//        System.out.println();
//        System.out.println("Divine - Nature");
//        System.out.println();
        Set<String> diff2 = new HashSet<>(divine);
        diff2.removeAll(nature);
//        diff2.forEach(System.out::println);




        Set<String> unionTest = new HashSet<>(nature);
        unionTest.addAll(divine);

        Set<String> intersectionTest = new HashSet<>(nature);
        intersection.retainAll(divine);

        System.out.println("Symmetric difference: ");
        unionTest.removeAll(intersectionTest);


        if (nature.containsAll(divine )) {

            System.out.println("Divine is a subset of nature");
        }

        if (nature.containsAll(intersectionTest)) {

            System.out.println("Intersection is a subset of nature.");
        }

        if (divine.containsAll(intersectionTest)) {

            System.out.println("Intersection is a subset of divine.");
        }
    }
}
