package Collections.Map;

import java.util.HashMap;
import java.util.Map;

public class MapExample {

    public static void main(String[] args) {

        Map<String, String> languages = new HashMap<>();
        languages.put("Java", "A compiled high level, object-orientated, platform independent language.");
        languages.put("Python", "an interpreted, object-orientated, high-level programming language with dynamic semantics");
        languages.put("Algol", "an algorithmic language");
        languages.put("BASIC", "Beginners All purposes Symbolic Instruction Code");
        languages.put("Lisp", "Therein lies madness.");

        if (languages.containsKey("Java")) {

            System.out.println("Java is already on the mao.");
        } else {

            languages.put("Java", "this course is about Java");
        }

        System.out.println("=====================================================================");

//        languages.remove("Lisp");
        if (languages.remove("Algol", "A family of algorithmic languages")) {

            System.out.println("Algol removed.");
        } else {

            System.out.println("Algol not removed, key/value not found");
        }

        if ((languages.replace("Lisp", "Therein lies madness.", "a functional programming language with imperative features."))) {

            System.out.println("Lisp replaced.");
        } else {

            System.out.println("Lisp was not replaced.");
        }

//        System.out.println(languages.replace("Scala", "This will not be added."));

        for (String key : languages.keySet()) {

            System.out.println(key + " : " + languages.get(key));
        }
     }
}
