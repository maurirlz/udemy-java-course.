package Collections.Intro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Theatre {

    private final String theatreName;
    public List<Seat> seats = new ArrayList<>();

    public Theatre(String theatreName, int numRows, int seatsPerRow) {
        this.theatreName = theatreName;

        int lastRow = 'A' + (numRows - 1);
        for (char row = 'A'; row <= lastRow; row++) {
            for (int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {

                Seat seat = new Seat(row + String.format("%02d", seatNum));
                seats.add(seat);
            }
        }
    }

    public String getTheatreName() {
        return theatreName;
    }

    public boolean reserveSeat(String seatNumber) {

        Seat requestedSeat = new Seat(seatNumber);
        int foundSeat = Collections.binarySearch(seats, requestedSeat, null);

        if (foundSeat >= 0) {

            return seats.get(foundSeat).reserve();
        } else {

            System.out.println("There is not seat " + seatNumber);
            return false;
        }
    }

    public void getSeats() {

        for (Seat seat : seats) {

            System.out.println(seat.getSeatNumber());
        }
    }

    public class Seat implements Comparable<Seat>{

        private final String seatNumber;
        private boolean reserved;

        public Seat(String seatNumber) {
            this.seatNumber = seatNumber;
        }

        public boolean reserve() {

            if (!this.reserved) {
                this.reserved = true;
                System.out.println("Seat " + seatNumber + " Has been reserved.");
                return this.reserved;
            } else {
                return false;
            }
        }

        public boolean cancelReserve() {

            boolean reservedSeat = this.reserved;
            if (reservedSeat) {

                this.reserved = false;
                System.out.println("Reservation of seat: " + seatNumber + "cancelled");
                return true;
            } else {
                return false;
            }
        }

        @Override
        public int compareTo(Seat seat) {
            return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
        }

        public String getSeatNumber() {
            return seatNumber;
        }
    }
}
