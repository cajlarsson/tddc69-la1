import java.util.*;

public class Castle 
{
    private Room currentRoom;
    //    private Room[] rooms;
    private Collection<Room> rooms = new ArrayList<Room>

    public Castle()
    {
        // Create the rooms in the castle.

        this.createRooms();
    }

    public void createRooms()
    {
        // Add your own rooms here! You should have at least five rooms.
        
        // Create room instances.
	
        Room hallway = new Room(
                "Hallway", 
                "You are in the Hallway. There is mystery in the air.\n" +
                "To the right are dark stairs leading to the East Tower.\n" +
                "In the front is a big door that leads to the Great Hall.");
        Room eastTower = new Room(
                "East Tower", 
                "You are in the East Tower. The view from here is magnificent.");
        Room greatHall = new Room(
                "Great Hall", 
                "This seems like a great place for a big party. There are all\n" +
                "sorts of ornaments and art on the walls, and there is a band with\n"+
                "small monkeys playing soft music.");

        // Connect rooms.

        hallway.setDoor(1, greatHall); // North door goes to the Great Hall
        hallway.setDoor(2, eastTower); // East door goes to the East Tower
        greatHall.setDoor(3, hallway); // South door goes to the Hallway
        eastTower.setDoor(4, hallway); // West door goes to the Hallway

	
	rooms.add(hallway);
	rooms.add(eastTower);
	rooms.add(greatHall);
    //	rooms[3] = greatHall;
    //	rooms[4] = greatHall;
	

        // Set the room to start in.

        this.currentRoom = hallway;
    }

    

    public void playGame()
    {
        // Write code that allows the player to move around
        // between the rooms. Use a while-loop and change the
        // currentRoom until the player types a zero.

        // Before you write the code you can use this line
        // to verify that the Castle class works. It won't allow
        // you to move around, but you will see the first room
        // when running the program.
	currentRoom.printDescription();	
	int input;
	while (( input = Console.read())  != 0)
	    {
		if (currentRoom.hasDoor(input))
		    {
			currentRoom = currentRoom.openDoor(input);
			currentRoom.printDescription();	
		    }
		else
		    {
			Console.print("There is no door there.");
		    }
	    }

       
    }

    public static void main(String[] args)
    {
        Castle myCastle = new Castle();
        myCastle.playGame();
    }
}
