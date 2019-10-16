package ObjectOrientedProgramming.Composition.Challenge;

public class Shelf {

    private String material;
    private int numberOfScrews;
    private double limitOnKilograms;

    public Shelf(String material, int numberOfScrews, double limitOnKilograms) {
        this.material = material;
        this.numberOfScrews = numberOfScrews;
        this.limitOnKilograms = limitOnKilograms;
    }

    public String getMaterial() {
        return material;
    }

    public int getNumberOfScrews() {
        return numberOfScrews;
    }

    public double getLimitOnKilograms() {
        return limitOnKilograms;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void setNumberOfScrews(int numberOfScrews) {
        this.numberOfScrews = numberOfScrews;
    }

    public void setLimitOnKilograms(double limitOnKilograms) {
        this.limitOnKilograms = limitOnKilograms;
    }
}
