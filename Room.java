public class Room
{
    private String name;
    private String description;
    private Room[] doors;
    
    public Room(String name, String description)
    {
        this.name = name;
        this.description = description;
        this.doors = new Room[4]; // Elements will be initialized to null.
    }
    
    public void setDoor(int direction, Room room)
    {
        // Write code that sets the element in the doors array that
        // corresponds to the given direction to the room parameter.
        // Note that array indexes start at zero, but our direction
        // numbers start at one, thus you need to subtract one from
        // the direction parameter to get the corresponding array index.
    }
    
    public Room openDoor(int direction)
    {
        // Write code that returns the room for the door in the given 
        // direction.
    }
    
    public void printDescription()
    {
        // Write code that prints the name and description of the room.
    }
}
