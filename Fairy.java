public class Fairy extends LivingBeing
{
    // Write code for the constructor and
    // the sayHello method.
    public Fairy(String name)
    {
	super(name);
    }
    
    public void sayHello()
    {
	Console.print(getName() + " the Fairy says: Watch out for the wizards!");
    }
}

