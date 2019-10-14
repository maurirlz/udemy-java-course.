package ObjectOrientedProgramming.Composition.Challenge;

public class Door {

    private boolean lock;
    private String material;
    private String color;

    public Door(boolean lock, String material, String color) {
        this.lock = lock;
        this.material = material;
        this.color = color;
    }

    public boolean isLock() {
        return lock;
    }

    public String getMaterial() {
        return material;
    }

    public String getColor() {
        return color;
    }

}
