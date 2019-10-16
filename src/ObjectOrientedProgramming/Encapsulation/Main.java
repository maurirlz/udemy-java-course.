package ObjectOrientedProgramming.Encapsulation;

public class Main {

    public static void main(String[] args) {
        Player playerOne = new Player();
        playerOne.fullName = "Tim";
        playerOne.health = 20;
        playerOne.weapon = "Sword";

        double damage = 10;
        playerOne.health =  200; // problem of not encapsulating Player class.
        playerOne.loseHealth(damage);
        System.out.println("Remaining health = " + playerOne.healthRemaning());

    }
}
