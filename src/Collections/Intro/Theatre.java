package Collections.Intro;

import java.util.ArrayList;
import java.util.List;

public class Theatre {

    private final String theatreName;
    private List<Seat> seats = new ArrayList<>();

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

    public boolean reserveSeat(String seatNumber) {

        Seat requestedSeat = null;

        for (Seat seat : seats) {

            if (seat.getSeatNumber().equals(seatNumber)) {

                requestedSeat = seat;
                break;
            }
        }

        if (requestedSeat == null) {

            System.out.println("There is no seat " + seatNumber);
            return false;
        }

        return requestedSeat.reserve();
    }

    public String getTheatreName() {
        return theatreName;
    }

    public void getSeat() {

        for (Seat seat : seats) {

            System.out.println(seat.getSeatNumber());
        }
    }

    private class Seat {

        private final String seatNumber;
        private boolean reserve = false;

        public Seat(String seatNumber) {
            this.seatNumber = seatNumber;
        }

        public boolean reserve() {

            if (!this.reserve) {

                this.reserve = true;
                System.out.println("Seat " + seatNumber + " reserved");
                return true;
            } else {

                return false;
            }
        }

        public boolean cancel() {

            if (this.reserve()) {

                this.reserve = false;
                System.out.println("Reservation of seat " + this.seatNumber + " canceled");
                return true;
            } else {

                return false;
            }
        }

        public String getSeatNumber() {
            return seatNumber;
        }

        public boolean isReserve() {
            return reserve;
        }


    }
}
