package LambdaExpressions.Introduction;

class AnotherClass {

    String doSomething() {

        UpperConcat uc = (s1, s2) -> {

            System.out.println("The lambda expression's class is: " + getClass().getSimpleName());
            String result = s1.toUpperCase() + " " + s2.toUpperCase();
            return result;
        };

        System.out.println("The AnotherClass class's name is: " + getClass().getSimpleName());
        return Main.doStringStuff(uc, "String1", "String2");
    }
}