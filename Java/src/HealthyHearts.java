import java.util.Scanner;

public class HealthyHearts
{
    public static void main(String[] args)
    {
        double heartRate = 220;
        Scanner userInput = new Scanner(System.in).useDelimiter("\n");

        System.out.println("What is your age?");
        while (userInput.hasNext())
        {
            if(!userInput.hasNextInt())
            {
                System.out.println("What is your age?");
                userInput.next();
                continue;
            }
            heartRate -= userInput.nextInt();
            break;
        }


        System.out.println("Your maximum heart rate should be "+ heartRate + " beats per minute");
        System.out.println("Your target HR Zone is " + (heartRate * 0.5) + " - " + (heartRate * 0.85) + " beats per minute");

    }
}
