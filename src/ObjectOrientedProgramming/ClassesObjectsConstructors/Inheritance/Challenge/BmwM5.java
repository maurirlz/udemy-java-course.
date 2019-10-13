package ObjectOrientedProgramming.ClassesObjectsConstructors.Inheritance.Challenge;

public class BmwM5 extends Car {

    private int roadServiceMonths;

    public BmwM5(double currentSpeed, double currentDirection, int roadServiceMonths) {
        super(currentSpeed, currentDirection,"4WD", "BMW",4, 5,6, true);
        this.roadServiceMonths = roadServiceMonths;
    }

    public int getRoadServiceMonths() {
        return roadServiceMonths;
    }

    public void setRoadServiceMonths(int roadServiceMonths) {
        this.roadServiceMonths = roadServiceMonths;
    }


}
