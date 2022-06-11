import java.util.Scanner;

public class DogGenetics
{
    public static void main(String[] args)
    {
        Scanner userInput = new Scanner(System.in).useDelimiter("\n");
        System.out.println("What is your dog's name?");
        String dogName = userInput.next();
        System.out.println("Well then, I have this highly reliable report on " + dogName + "'s prestigious background right here.\n");

        System.out.println(dogName + " is:\n");

        String [] dogText = {"St. Bernard", "Chihuahua","Dramatic RedNosed Asian Pug","Common Cur","King Doberman"};
        int max = 100;
        for(int i = 0 ; i < dogText.length; ++i)
        {
            if(i == dogText.length)
            {
                System.out.println(max + "% " + dogText[i]);
            }
            else
            {
                int randomNumber = 0 + (int) (Math.random() * ((max +1 - 0) + 1));
                System.out.println(randomNumber + "% " + dogText[i]);
                max -= randomNumber;
            }
        }



    }
}
