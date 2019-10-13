package ObjectOrientedProgramming.ClassesObjectsConstructors.Inheritance.Challenge;

public class Car extends Vehicle {

    private int numberOfWheels = 4;
    private int numberOfDoors;
    private int numberOfGears;
    private int currentGear;
    private boolean isManual;

    public Car(double currentSpeed, double currentDirection, String size, String name, int numberOfWheels, int numberOfDoors, int numberOfGears, boolean isManual) {
        super(currentSpeed, currentDirection, size, name);
        this.numberOfWheels = numberOfWheels;
        this.numberOfDoors = numberOfDoors;
        this.numberOfGears = numberOfGears;
        this.currentGear = 1;
        this.isManual = isManual;
    }

    public void changeGear(int currentGear) {
        this.currentGear = currentGear;
        System.out.println("Car.setCurrentGear(); Change to " + this.currentGear);
    }

    public void changeSpeed(double speed, double direction) {
        move(speed,direction);
        System.out.println("Car.changeSpeed(): Speed:" + speed + "direction" + direction);
    }

}
