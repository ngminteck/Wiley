package Lab;

class AdvanceCaluator extends Calulator
{
    AdvanceCaluator()
    {
        super();
    }

    public  String Div(double x, double y)
    {
        String print = DoubleStringFormat(x) + " / " + DoubleStringFormat(y) + " = ";
        int  wholeNumber = 0;
        int remainder;
        // check div 0
        try {
            wholeNumber = (int) (x / y);
        }
        // ignore because for user / 0 is not errror, but for computer science or math people divide zero is an error
        catch(ArithmeticException ignored)
        {
            System.out.println(ignored.getMessage());
        }

        remainder = (int)(x % y);

        return print + wholeNumber +  "R" + remainder;
    }
}

public class Lab5Q2
{
    public static void main(String[] args)
    {
        AdvanceCaluator myCalulator = new AdvanceCaluator();

        for(int i = 0; i< 2 ; ++ i)
        {
            myCalulator.Calulate();
        }
    }
}
