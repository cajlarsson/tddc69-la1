import java.util.*;

public class Castle 
{
    private Room currentRoom;
    //    private Room[] rooms;
    private ArrayList<Room> rooms = new ArrayList<Room>();

    private Random generator = new Random(System.currentTimeMillis()); 
    
    public Castle()
    {
        // Create the rooms in the castle.

        this.createRooms();
    }

    public void teleportRandom()
    {
	currentRoom =  rooms.get( generator.nextInt(rooms.size()));
    }
    public void createRooms()
    {
        // Add your own rooms here! You should have at least five rooms.
        
        // Create room instances.
	
        Room hallway = new Room(
                "Hallway", 
                "You are in the Hallway. There is mystery in the air.\n" +
                "To the right are dark stairs leading to the East Tower.\n" +
                "In the front is a big door that leads to the Great Hall."
		,generator.nextInt());
        Room eastTower = new Room(
                "East Tower", 
                "You are in the East Tower. The view from here is magnificent.",
		generator.nextInt());
        Room greatHall = new Room(
                "Great Hall", 
                "This seems like a great place for a big party. There are all\n" +
                "sorts of ornaments and art on the walls, and there is a band with\n"+
                "small monkeys playing soft music.",
		generator.nextInt());

	Room france = new Room(
			       "France",
			       "You are in france. It smells of baguettes and cheese.\n"+
			       "You can no longer see the castle, wonder where it went.",
			       generator.nextInt());

	Room mordor = new Room(
			       "Mordor",
			       "You don't simply walk into Mordor",
			       generator.nextInt());
	Room baljan = new Room(
			       "Baljan",
			       "It is thursday, everyone is drinking beer and fighting, even the monkeys",
			       generator.nextInt());

	

        // Connect rooms.
	
        hallway.setDoor(1, greatHall); // North door goes to the Great Hall
        hallway.setDoor(2, eastTower); // East door goes to the East Tower
       	hallway.setDoor(3, france); 
	hallway.setDoor(4, baljan);
	france.setDoor(1, france);
        france.setDoor(2, france);
	france.setDoor(3, france);
	france.setDoor(4, france);
	mordor.setDoor(1, france);
	mordor.setDoor(2, greatHall);
	baljan.setDoor(1,hallway);
	baljan.setDoor(2, france);
        greatHall.setDoor(3, hallway); // South door goes to the Hallway
        eastTower.setDoor(4, hallway); // West door goes to the Hallway

	
	rooms.add(hallway);
	rooms.add(eastTower);
	rooms.add(greatHall);
	rooms.add(france);
	rooms.add(baljan);
	rooms.add(mordor);


    //	rooms[3] = greatHall;
    //	rooms[4] = greatHall;
	

        // Set the room to start in.

        this.currentRoom = hallway;
    }
    
    public void teleportAllBeings()
    {
	int from = generator.nextInt(rooms.size());
	int to = generator.nextInt(rooms.size());
	
	rooms.get(to).addBeings(rooms.get(from).geifBeings());	
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
		
		
		if (input == 5)
		    {
			teleportRandom();
			currentRoom.printDescription();
			teleportAllBeings();
		    }
		else if (currentRoom.hasDoor(input))
		    {
			currentRoom = currentRoom.openDoor(input);
			currentRoom.printDescription();	
			teleportAllBeings();
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
