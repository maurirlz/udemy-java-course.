package ObjectOrientedProgramming.Composition.Challenge;

public class Blanket {

    private String material;
    private String color;
    private int holes;

    public Blanket(String material, String color, int holes) {
        this.material = material;
        this.color = color;
        this.holes = holes;
    }

    private void onBed() {
        System.out.println("Sheet organized on bed.");
    }

    private boolean hasHoles(int holes) {
        if (this.holes < 0) {
            holes = 0;
        }
        return holes == 0;
    }

    public String getMaterial() {
        return material;
    }

    public String getColor() {
        return color;
    }

    public int getHoles() {
        return holes;
    }
}
