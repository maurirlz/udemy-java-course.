package ObjectOrientedProgramming.Encapsulation;

public class Player {

    public double health;
    public String fullName;
    public String weapon;

    public void loseHealth(double damage) {
        this.health -= damage;
        if (this.health <= 0) {
            System.out.println("Game over.");
        }
    }

    public double healthRemaning() {
        return this.health;
    }


}
