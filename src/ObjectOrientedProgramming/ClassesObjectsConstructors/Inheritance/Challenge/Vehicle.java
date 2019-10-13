package ObjectOrientedProgramming.ClassesObjectsConstructors.Inheritance.Challenge;

public class Vehicle {

    private double currentSpeed;
    private double currentDirection;
    private String size;
    private String name;

    public Vehicle(double currentSpeed, double currentDirection, String size, String name) {
        this.currentSpeed = 0;
        this.currentDirection = 0;
        this.size = size;
        this.name = name;
    }

    public void stop() {
        this.currentSpeed = 0;
    }

    public void steer(double direction) {

        this.currentDirection = direction;
        System.out.println("Vehicle.steer(); Steering at " + currentDirection + "degrees");
    }

    public void move(double direction, double velocity) {
        currentSpeed = velocity;
        currentDirection = direction;
        System.out.println("Vehicle.move(); Moving at " + currentSpeed + "in direction " + currentDirection);
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(double currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public double getCurrentDirection() {
        return currentDirection;
    }

    public void setCurrentDirection(double currentDirection) {
        this.currentDirection = currentDirection;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
