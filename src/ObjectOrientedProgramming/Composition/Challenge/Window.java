package ObjectOrientedProgramming.Composition.Challenge;

public class Window {

    private String material;
    private String color;
    private int numberOfHinges;
    private boolean isOpen;

    public Window(String material, String color, int numberOfHinges, boolean isOpen) {
        this.material = material;
        this.color = color;
        this.numberOfHinges = numberOfHinges;
        this.isOpen = isOpen;
    }

    public void isWindowOpen() {
        if (isOpen) {
            System.out.println("Window is open.");
        } else {
            System.out.println("Window is closed.");
        }
    }

    public String getMaterial() {
        return material;
    }

    public String getColor() {
        return color;
    }

    public int getNumberOfHinges() {
        return numberOfHinges;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setNumberOfHinges(int numberOfHinges) {
        this.numberOfHinges = numberOfHinges;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }
}
