import java.io.*;

public class Console
{
    public static void print(String s)
    {
        System.out.println(s);
    }
    
    public static int read()
    {
	return Integer.valueOf(stringRead()).intValue();
    }

    private static String stringRead()
    {
        BufferedReader reader;
        String line = "";

        try
        {
            // The try block contains code that might cause an error.
            
            reader = new BufferedReader(new InputStreamReader(System.in));
            line = reader.readLine();
        }
        catch (Exception ex)
        {
            // The catch block handles the error. In this case
            // the error is just printed.
            
            System.out.println(ex.toString());
        }

        return line;
    }
}
