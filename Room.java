import java.util.*;

public class Room
{
    private String name;
    private String description;
    private Room[] doors;
    private ArrayList<LivingBeing> beings;
    private Random generator;


    public Room(String name, String description, int seed)
    {
        this.name = name;
        this.description = description;
        this.doors = new Room[4]; // Elements will be initialized to null.

	generator  = new Random(seed);

	beings = new ArrayList<LivingBeing>();

	for (int i=0; i <generator.nextInt(4) ; i++)
	    {
		int type = generator.nextInt(3);
		switch (type)
		    {
		    case 0:
			beings.add( new Monkey(randomName()));
		    break;
		    case 1:
			beings.add( new Wizard(randomName()));
		    break;
		    case 2:
			beings.add( new Fairy(randomName()));
		    break;
		    }
	    }
    }


    private String randomName()
    {
	String[] names= {"Amber Tsunami","Axe Mysterybattler","Axe Spirittiger",
				 "Bedlam Zealot","Comet Gravebattler","Edge Spelldrake",
				 "Gale Shadow","Gunner Jackalsong","Hawk Honorseeker",
				 "Knight Royalfiend","Knight Seeker","Lightning Godheart",
				 "Lightning Lancefiend","Maxim Ladymage","Melody Madcaster",
				 "Mist Lightdemon","Quake Battler","Ragnarok Blizzard",
				 "Rogue Light","Song Iconcaster","Star Storm",
				 "Storm Steelseeker","Tsunami Roamer","Victory Magicnoble",
				 "Warlock Ironangel","Albion Demonhawk","Bedlam Mourner",
				 "Blood Bedlam","Clash Puritymourner","Dirk Honorjackal",
				 "Drake Doom","Eden Talon","Ghost Roamer",
				 "Grimoire Squall","Honor Bane","Ice Ghostmagus",
				 "Katana Nemesislore","King Fellraven","King Grimtotem",
				 "Melody Ghostseeker","Midnight Gustbattler","Midnight Rubyanchor",
				 "Mist Madlaw","Rain Guardcaster","Rascal Magefauna",
				 "Reaper Drakeanger","Rune Pandemonium","Spirit Mysterymourner",
				 "Victor Victory","Warlock Madquake","Axe Knightclaw",
				 "Bedlam Fiendfinder","Belladonna Gunner","Claymore Gust",
				 "Cult Wolf","Dawn Magus","Dawn Violetmagus",
				 "Eden Rogue","Eternity Tempestreaper","Flame Midnight",
				 "Grief Zealotrage","Griffon Witchclaw","Grim Royal",
				 "Honor Maverick","Jericho Royalsinner","Lightning Magicchanter",
				 "Paradox Ivyhunter","Paradox Jackalreaper","Ragnarok Honor",
				 "Rouge Mourner","Seeker Spiritcult","Shroud Nemesisheart",
				 "Star Darkdread","Tempest Songcaster","Tempest Wanderlust",
				 "Amber Ghosthawk","Arcane Albion","Claw Warslayer",
				 "Cloud Rogue","Curse Tempestraven","Edge Roseknight",
				 "Eternity Holygod","Fate Zealotchanter","Gale Victory",
				 "Ice Tombguard","Katana Jackal","King Goldgrief",
				 "Lightning Magefinder","Magus Wanderlust","Opera Ironghost",
				 "Opera Sinnersoul","Ragnarok Grimoire","Rose Puritystar",
				 "Ruby Tomemagus","Saber Strifeghost","Spirit Blacktempest",
				 "Star Flameguard","Tiger Mistcomet","Victor Chaosreaper",
				 "Zealot Magereaper","Albion Dire","Battler Goldveil",
				 "Blood Brand","Cult Sephiroth","Dagger Amber",
				 "Edge Totemghost","Fate Flora","Grave Seraphim",
				 "Harmony Rogue","Jasmine Wisehowl","Katana Warlight",
				 "Maxim Goldguard","Maxim Kingseeker","Maxim Shadow",
				 "Mist Violetguard","Saber Amber","Saber Ironeden",
				 "Sheol Knightguard","Shroud Ghostveil","Sinner Honor",
				 "Slayer Liongrief","Spirit Sheol","Talon Fauna",
		                 "Tempest Demonguard","Zeal Spiritgod", "Ben Dover"};

	return (names[generator.nextInt(names.length)]);
	
    }
    
    public void setDoor(int direction, Room room)
    {
        // Write code that sets the element in the doors array that
        // corresponds to the given direction to the room parameter.
        // Note that array indexes start at zero, but our direction
        // numbers start at one, thus you need to subtract one from
        // the direction parameter to get the corresponding array index.
	doors[direction-1] = room;	
    }
    
    public boolean hasDoor(int direction)
    {
	return (( direction < 5) && (direction > 0) && (doors[direction -1] != null) );
    }
   
    public ArrayList<LivingBeing> geifBeings()
    {
	ArrayList<LivingBeing> temp  = beings;
	beings = new ArrayList<LivingBeing>();
	return temp;
    }
    
    public void addBeings(ArrayList<LivingBeing> newBeings )
    {
	beings.addAll(newBeings);
    }
    public Room openDoor(int direction)
    {
        // Write code that returns the room for the door in the given 
        // direction.
	return doors[direction -1];
    }
    
    public void printDescription()
    {
	Console.print(name);
	Console.print(description);
	for (int i = 0 ; i < beings.size(); i++)
	    {
		beings.get(i).sayHello();
	    }
    }
}
