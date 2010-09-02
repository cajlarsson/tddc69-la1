public abstract class LivingBeing
{
    private String name;
    
    public LivingBeing(String name)
    {
        this.name = name;
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public abstract void sayHello();
}
