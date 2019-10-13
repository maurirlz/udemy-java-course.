package ObjectOrientedProgramming.ClassesObjectsConstructors;

public class Car {

    private int doors;
    private int wheels;
    private String model;
    private String engine;
    private String colour;

    public void setModel(String model)  {

        this.model = model;
    }

    public String getModel() {
        String validModel = model.toLowerCase();
        if (validModel.equals("porsche") || (validModel.equals("holden"))) {
            return this.model;
        } else {
            return this.model = "Unknown";
        }
    }
}

