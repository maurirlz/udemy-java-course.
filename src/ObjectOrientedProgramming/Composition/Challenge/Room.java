package ObjectOrientedProgramming.Composition.Challenge;

public class Room {

    private Door door;
    private Window window;
    private Closet closet;
    private AirConditioner airconditioner;
    private Bed bed;
    private Shelf shelf;

    public Room(Door door, Window window, Closet closet, AirConditioner airconditioner, Bed bed, Shelf shelf) {
        this.door = door;
        this.window = window;
        this.closet = closet;
        this.airconditioner = airconditioner;
        this.bed = bed;
        this.shelf = shelf;
    }

    private void isRoomLocked() {
        if (door.isLock()) {
            System.out.println("Room is locked, you are safe!");
        } else {
            System.out.println("Room is unlocked.");
        }
    }

    private void isRoomCold() {
        if ((airconditioner.isOn()) || (window.isOpen())) {

            System.out.println("Room cooling");
        }
    }

}
