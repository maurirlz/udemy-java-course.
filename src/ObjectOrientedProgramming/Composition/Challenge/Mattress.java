package ObjectOrientedProgramming.Composition.Challenge;

public class Mattress {

    private String material;
    private String color;
    private int holes; // holes in Mattress

    public Mattress(String material, String color, int holes) {
        this.material = material;
        this.color = color;
        this.holes = holes;
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
