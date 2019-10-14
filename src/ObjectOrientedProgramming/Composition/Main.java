package ObjectOrientedProgramming.Composition;

public class Main {
    public static void main(String[] args) {

        // Composition / HAS A relationship.

        Dimensions dimensions = new Dimensions(20, 20);
        Case theCase = new Case("220B", "Dell", "220",dimensions);

        Monitor monitor = new Monitor("Beast", "Samsung", 27, new Resolution(2540, 1440));

        Motherboard mobo = new Motherboard("z130", "ASUS", 4, 6, "Version 2.00");

        PersonalComputer pc = new PersonalComputer(theCase, monitor, mobo);

        pc.powerUp();

    }
}
