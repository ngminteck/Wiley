package Lab;



public class Lab8Q4 {
    public static void main(String[] args)
    {
        int i = 0;
        String greetings [] ={"Hello Twinkle ! ", "Hello Java ! ", "Hello World ! "};

        while(i < 4)
        {
            try
            {
                System.out.println(greetings [i]);
            }
            catch (Exception e)
            {
                System.out.println(e.toString());
                System.out.println("Resetting index value");
            }
            finally
            {
                System.out.println("Hi !");
                i++;
            }
        }
    }

}
