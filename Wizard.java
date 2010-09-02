public class Wizard extends LivingBeing
{
    public Wizard(String name)
    {
	super(name);
    }
    
    public void sayHello()
    {
	Console.print(getName() + " the Wizard says: May i show you my staff?, it is really mighty!");
    }
    // Write code for the constructor and
    // the sayHello method.
}

