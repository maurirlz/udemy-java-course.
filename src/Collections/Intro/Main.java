package Collections.Intro;

public class Main {

    public static void main(String[] args) {

        Theatre theatre = new Theatre("Hoyts", 8, 20);

        if (theatre.reserveSeat("H11")) {

            System.out.println("Please pay");
        } else {

            System.out.println("Sorry, seat is already taken.");
        }
    }
}
