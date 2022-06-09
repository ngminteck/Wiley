import java.util.ArrayList;
import java.util.Scanner;

class PizzaInfo
{
    PizzaInfo(String _name, double _price)
    {
        name = _name;
        price = _price;
    }
    String name = "";
    double price = 0.0;
}
class PizzaMenu
{
    PizzaMenu()
    {
        pizzaArray.add(new PizzaInfo("Cheese", 5));
        pizzaArray.add(new PizzaInfo("Chicken", 7.50));
        pizzaArray.add(new PizzaInfo("Seafood", 10));
    }

    public void DisplayMenu()
    {
        for(int i = 0; i < pizzaArray.size() ; ++ i)
        {
            System.out.println(i + 1 + ":" + pizzaArray.get(i).name + ":$" + DoubleStringFormat(pizzaArray.get(i).price));
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

     ArrayList<PizzaInfo> pizzaArray = new ArrayList<PizzaInfo>();

}
class PizzaOrder
{
    PizzaOrder(String _name, double _price , int _quantity )
    {
        name = _name;
        price = _price;
        quantity = _quantity;
    }

    String name ="";
    int quantity = 1;
    double price = 0;
}
class PizzaCustomer
{
    PizzaCustomer(String _name)
    {
        name = _name;
    }

    public void DisplayOrder()
    {
        System.out.println(name + ", you have order");
        double finalPrice = 0.0;
        for(int i =0;i< pizzaArray.size() ; ++ i)
        {
            double totalPrice =  pizzaArray.get(i).price * pizzaArray.get(i).quantity;
            System.out.println(pizzaArray.get(i).name + ":$" + DoubleStringFormat(pizzaArray.get(i).price) + " x " + pizzaArray.get(i).quantity + " = $" + DoubleStringFormat(totalPrice));
            finalPrice += totalPrice;
        }
        System.out.println("Total $" + finalPrice);
    }

    public static String DoubleStringFormat(double value)
    {
        // not a good practice cast double to long as maybe the size is difference
        if(value == (long) value)
            return String.format("%d",(long)value);
        else
            return String.format("%s",value);
    }

     String name ="";
     ArrayList<PizzaOrder> pizzaArray = new ArrayList<PizzaOrder>();

}


public class Lab4Q3
{

    public static void main(String[] args)
    {
        Scanner userInput = new Scanner(System.in).useDelimiter("\n");
        PizzaMenu menu = new PizzaMenu();
        boolean run = true;

        String msg = "";
        System.out.println("Welcome! How can i address you?");
        PizzaCustomer customer = new PizzaCustomer(userInput.next());
        System.out.println(customer.name + " below is our pizza menu");
        menu.DisplayMenu();
        System.out.println("Please type the index follow by space and then follow by quantity");
        msg = userInput.next();
        String[] data = msg.split("[ ]");

        for(int i = 0; i < data.length ; i+= 2)
        {
            // check value
            if( i + 1 > data.length)
                break;

            int quantity = 0;
            try
            {
                quantity = Integer.parseInt(data[i + 1]);
            }
            catch(NumberFormatException ex)
            {

            }
            if (quantity < 1 )
                continue;

            int number = 0;

            try
            {
                number = Integer.parseInt(data[i]);
            }
            catch(NumberFormatException ex)
            {

            }

            if (number < 0)
                continue;

            int index = number - 1;

            if(index > menu.pizzaArray.size())
                continue;

            // processing
            customer.pizzaArray.add(new PizzaOrder(menu.pizzaArray.get(index).name, menu.pizzaArray.get(index).price, quantity));

        }
        // possible make as a loop that user can edit order again .
        customer.DisplayOrder();

    }
}
