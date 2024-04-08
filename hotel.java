package Hotel;

public class hotel {

    private String room; // Tipo de habitación
    private int roomNumber; // Número de habitación

    public hotel(String room, int roomNumber) {
        this.room = room;
        this.roomNumber = roomNumber;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Override
    public String toString() {
        return "[Tipo de Habitación: " + room + ", Número de Habitación: " + roomNumber + "]";
    }
}
