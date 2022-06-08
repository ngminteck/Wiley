import java.util.Scanner;

public class Lab1
{
    public static void PrintAdd(double x, double y)
    {
        String print = DoubleStringFormat(x) + " + " + DoubleStringFormat(y) + " = ";
        double result = x + y;
        System.out.println(print + DoubleStringFormat(result));

    }

    public static void PrintSub(double x, double y)
    {
        String print = DoubleStringFormat(x) + "  " + DoubleStringFormat(y) + " = ";
        double result = x - y;
        System.out.println(print +  DoubleStringFormat(result));
    }

    public static void PrintMul(double x, double y)
    {
        String print = DoubleStringFormat(x) + " * " + DoubleStringFormat(y) + " = ";
        double result = x * y;
        System.out.println(print +  DoubleStringFormat(result));
    }

    public static void PrintDiv(double x, double y)
    {
        String print = DoubleStringFormat(x) + " / " + DoubleStringFormat(y) + " = ";
        double result = 0;
        // check div 0
        if(y != 0)
            result = x / y;
        System.out.println(print +  DoubleStringFormat(result));
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

    public static String Cal(double x, double y, char operator)
    {
        switch (operator)
        {
            case '+':
                return Add(x,y);

            case '-':
                return Sub(x,y);

            case '*':
                return Mul(x,y);

            case '/':
                return Div(x,y);

            default:
                return "Error!";
        }

    }

    public static void PrintCal(double x, double y, char operator)
    {
        switch (operator)
        {
            case '+':
                PrintAdd(x,y);
                break;
            case '-':
                PrintSub(x,y);
                break;
            case '*':
                PrintMul(x,y);
                break;
            case '/':
                PrintDiv(x,y);
                break;
            default:
                System.out.println("Error!");
        }

    }

    public static String DoubleStringFormat(double value)
    {
        // not a good practice cast double to long as maybe the size is difference
        if(value == (long) value)
            return String.format("%d",(long)value);
        else
            return String.format("%s",value);
    }

    public static void main(String[] args)
    {
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
        PrintCal(x,y,op);
        System.out.println(Cal(x,y,op));

    }
}
