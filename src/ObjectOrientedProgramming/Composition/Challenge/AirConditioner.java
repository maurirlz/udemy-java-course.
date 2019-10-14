package ObjectOrientedProgramming.Composition.Challenge;

public class AirConditioner {

    private boolean plugged;
    private String color;
    private String model;
    private String manufacturer;

    public AirConditioner(boolean plugged, String color, String model, String manufacturer) {
        this.plugged = plugged;
        this.color = color;
        this.model = model;
        this.manufacturer = manufacturer;
    }

    public boolean isOn() {
        if (!plugged) {
            System.out.println("Air conditioner is off.");
            return false;
        } else {
            System.out.println("Air conditioner is on");
            return true;
        }
    }

    public boolean isPlugged() {
        return plugged;
    }

    public String getColor() {
        return color;
    }

    public String getModel() {
        return model;
    }

    public String getManufacturer() {
        return manufacturer;
    }
}
