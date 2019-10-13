package ObjectOrientedProgramming.ClassesObjectsConstructors.Inheritance;

public class Dog extends Animal {

    private String coat;
    private int eyes;
    private int legs;
    private int tail;
    private int teeth;

    public Dog(String name, int brain, int size, int weight, String coat, int eyes, int legs, int tail, int teeth) {
        super(name, 1, 1, size, weight); // all dogs have a brain and a body
        this.eyes = eyes;
        this.legs = legs;
        this.tail = tail;
        this.teeth = teeth;
        this.coat = coat;
    }

    private void chew() {
        System.out.println("Dog.chow() called.");
    }

    public void walk() {
        System.out.println("Dog.walk() called.");
        move(5);
    }

    public void run(int i) {
        System.out.println("Dog.run() called.");
        move(10);
    }

    @Override
    public void eat() {
        System.out.println("Dog.eat() called.");
        chew();
        super.eat();
    }

    private void moveLegs(int speed) {
        System.out.println("Dog.moveLegs(); called");
    }

    @Override
    public void move(int speed) {
        System.out.println("Dog.move(); called");
        moveLegs(speed);
        super.move(speed);
    }
}
