import java.util.Scanner;

class Calulator
{
    Calulator()
    {
        firstDigit = 0;
        secondDigit = 0;
        operator = ' ';
    }

    public void Calulate()
    {
        // reset all value
        setValue(0.0, ' ', 0.0);

        Scanner userInput1 = new Scanner(System.in);

        double x = 0.0;
        System.out.println("Please enter first value.");
        while(!userInput1.hasNextDouble())
        {
            System.out.println("Please enter first value.");
            userInput1.next();
        }
        x = userInput1.nextDouble();

        Scanner userInput2 = new Scanner(System.in);

        System.out.println("Please the operator.");
        char op = userInput2.next().charAt(0);

        // has problem here, it need type 2 character somehow.
        while( op != '+' && op != '-' && op != '*' && op !='/')
        {
            System.out.println("Please the operator.");
            op = userInput2.next().charAt(0);

        }

        Scanner userInput3 = new Scanner(System.in);
        double y = 0.0;
        System.out.println("Please enter second value.");
        while(!userInput3.hasNextDouble())
        {
            System.out.println("Please enter second value.");
            userInput3.next();
        }
        y = userInput3.nextDouble();
        setValue(x, op, y);
        System.out.println(Cal());

    }

    private void setValue(double _first, char _op, double _second)
    {
        firstDigit =_first;
        secondDigit =_second;
        operator =_op;
    }

    public static String Add(double x, double y)
    {
        String print = DoubleStringFormat(x) + " + " + DoubleStringFormat(y) + " = ";
        double result = x + y;
        return print + DoubleStringFormat(result);
    }

    public static String Sub(double x, double y)
    {
        String print = DoubleStringFormat(x) + " - " + DoubleStringFormat(y) + " = ";
        double result = x - y;
        return print + DoubleStringFormat(result);
    }

    public static String Mul(double x, double y)
    {
        String print = DoubleStringFormat(x) + " * " + DoubleStringFormat(y) + " = ";
        double result = x * y;
        return print + DoubleStringFormat(result);
    }

    public static String Div(double x, double y)
    {
        String print = DoubleStringFormat(x) + " / " + DoubleStringFormat(y) + " = ";
        double result = 0;
        // check div 0
        if(y != 0)
            result = x / y;
        return print + DoubleStringFormat(result);
    }

    public static String DoubleStringFormat(double value)
    {
        // not a good practice cast double to long as maybe the size is difference
        if(value == (long) value)
            return String.format("%d",(long)value);
        else
            return String.format("%s",value);
    }

    private String Cal()
    {
        switch (operator)
        {
            case '+':
                return Add(firstDigit,secondDigit);

            case '-':
                return Sub(firstDigit,secondDigit);

            case '*':
                return Mul(firstDigit,secondDigit);

            case '/':
                return Div(firstDigit,secondDigit);

            default:
                return "Error!";
        }
    }
    private double firstDigit;
    private double secondDigit;
    private char operator;
}
public class Lab4Q2
{
    public static void main(String[] args)
    {
        Calulator myCalulator = new Calulator();

        for(int i = 0; i< 2 ; ++ i)
        {
            myCalulator.Calulate();
        }
    }
}
