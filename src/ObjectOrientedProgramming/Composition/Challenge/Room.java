package ObjectOrientedProgramming.Composition.Challenge;

public class Room {

    private Door door;
    private Window window;
    private AirConditioner airconditioner;
    private Bed bed;
    private Shelf shelf;

    public Room(Door door, Window window, AirConditioner airconditioner, Bed bed, Shelf shelf) {
        this.door = door;
        this.window = window;
        this.airconditioner = airconditioner;
        this.bed = bed;
        this.shelf = shelf;
    }

    private boolean isShelfSafe() {
        if (shelf.getNumberOfScrews() < 6 && shelf.getLimitOnKilograms() > 30d) {
            return false;
        } else {
            System.out.println("The shelf is safe.");
            return true;
        }
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

    public Door getDoor() {
        return door;
    }

    public Window getWindow() {
        return window;
    }

    public AirConditioner getAirconditioner() {
        return airconditioner;
    }

    public Bed getBed() {
        return bed;
    }

    public Shelf getShelf() {
        return shelf;
    }

    public void setDoor(Door door) {
        this.door = door;
    }

    public void setWindow(Window window) {
        this.window = window;
    }

    public void setAirconditioner(AirConditioner airconditioner) {
        this.airconditioner = airconditioner;
    }

    public void setBed(Bed bed) {
        this.bed = bed;
    }

    public void setShelf(Shelf shelf) {
        this.shelf = shelf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Room)) return false;
        Room room = (Room) o;
        return door.equals(room.door) &&
                window.equals(room.window) &&
                airconditioner.equals(room.airconditioner) &&
                bed.equals(room.bed) &&
                shelf.equals(room.shelf);
    }
}
