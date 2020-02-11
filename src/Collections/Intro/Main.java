package Collections.Intro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Theatre hoysCinema = new Theatre("Hoyts", 8, 12);
        List<Theatre.Seat> seatCopy = new ArrayList<>();


        if (hoysCinema.reserveSeat("A02")) {

            System.out.println("Please pay for A02");
        } else {

            System.out.println("Seat already reserved.");
        }

        List<Theatre.Seat> priceSeats = new ArrayList<>(hoysCinema.getSeats());
        priceSeats.add(hoysCinema.new Seat("B00", 13.00));
        priceSeats.add(hoysCinema.new Seat("A00", 13.00));
        Collections.sort(priceSeats, Theatre.PRICE_ORDER);

        printList(priceSeats);
    }

    public static void printList(List<Theatre.Seat> list) {
        for (Theatre.Seat seat : list) {

            System.out.print(" " + seat.getSeatNumber() + " " + seat.getPrice());
        }
        System.out.println();
        System.out.println("============================================================================");
    }

}

