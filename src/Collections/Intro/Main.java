package Collections.Intro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Theatre hoytsCinema = new Theatre("Hoyts", 8, 12);

        // Coping an an Arraylist to another Arraylist.

        List<Theatre.Seat> seatCopy = new ArrayList<>(hoytsCinema.seats);

        // Usage of reverse() and shuffle():

//        Collections.reverse(seatCopy);
//        System.out.println("Printing seatCopy");
//        printList(seatCopy);
//        System.out.println("Printing Hoyts Cinema arraylist in shuffle order.");
//        Collections.shuffle(hoytsCinema.seats);
//        printList(hoytsCinema.seats);

        // usage of min() and max():
        Theatre.Seat lesserSeat = Collections.min(seatCopy);
        Theatre.Seat higherSeat = Collections.max(seatCopy);

        System.out.println("The higher number of seats available is: " + higherSeat.getSeatNumber());
        System.out.println("The lesser number of seats available is: " + lesserSeat.getSeatNumber());


    }

    public static void printList(List<Theatre.Seat> list) {
        for (Theatre.Seat seat : list) {

            System.out.print(" " + seat.getSeatNumber());
        }
        System.out.println();
        System.out.println("============================================================================");
    }
}
