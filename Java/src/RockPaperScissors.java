import java.util.Scanner;

public class RockPaperScissors {

    private static int numsOfRounds;
    private static int userWin;
    private static int computerWin;
    private static int draw;
    public static boolean RoundValidnate()
    {
        Scanner userInput = new Scanner(System.in).useDelimiter("\n");

        System.out.println("How many round, in range of 1 to 10?");
        if(userInput.hasNextInt())
            numsOfRounds = userInput.nextInt();
        else
            userInput.next();

        if(numsOfRounds >= 1 && numsOfRounds <=10)
        {
            return true;
        }
        else
        {
            System.out.println("Number of Round not in range");
            return false;
        }
    }

    public static void Round()
    {
        Scanner userInput = new Scanner(System.in).useDelimiter("\n");

        for(int i =0 ; i <numsOfRounds; ++i)
        {
            System.out.println("Round " + (i + 1));
            int userOption = 0;
            do {
                System.out.println("Type 1 = Rock, 2 = Paper, 3 = Scissors");
                if (userInput.hasNextInt())
                    userOption = userInput.nextInt();
                else
                    userInput.next();
            }
            while (userOption < 0 || userOption > 3);

            int compOption = 1 + (int) (Math.random() * ((3 + 1 - 1) + 1));

            System.out.println("You:"+Choice(userOption) + " Computer:" + Choice(compOption));

            if (userOption == 1 && compOption == 1 || userOption == 2 && compOption == 2 || userOption == 3 && compOption == 3)
            {
                ++draw;
                System.out.println("Draw this round! " + "Draw:"+ draw +" Win:" +userWin + " Lose:" + computerWin );
            }
            else if (userOption == 1 && compOption == 2 || userOption == 2 && compOption == 3 || userOption == 3 && compOption == 1)
            {
                ++computerWin;
                System.out.println("You lose this round! " + "Draw:"+ draw +" Win:" +userWin + " Lose:" + computerWin );
            }
            else
            {
                ++userWin;
                System.out.println("You win this round! " + "Draw:"+ draw +" Win:" +userWin + " Lose:" + computerWin );
            }
        }

    }

    public static String Choice(int options)
    {
        if(options == 1)
            return "Rock";
        else if (options == 2)
            return "Paper";
        else
            return "Scissors";
    }

    public static void Result()
    {
        System.out.println("Final Result. Draw:"+ draw +" Win:" +userWin + " Lose:" + computerWin);

        if(userWin > computerWin)
            System.out.println("You Win!");
        else if (userWin < computerWin)
            System.out.println("You Lose!");
        else
            System.out.println("Draw!");

    }

    public static boolean Continue()
    {
        Scanner userInput = new Scanner(System.in).useDelimiter("\n");
        int userOption = 0;
        do {
            System.out.println("Continue? Type 1 = Yes, 2 = No");
            if(userInput.hasNextInt())
                userOption = userInput.nextInt();
            else
                userInput.next();
        }
        while (userOption < 0 || userOption > 2);

        if(userOption == 1)
        {
            return true;
        }
        else
        {
            System.out.println("Thanks for playing!");
            return false;
        }
    }

    public static void Reset()
    {
        numsOfRounds= 0;
        userWin = 0;
        computerWin =0;
        draw = 0;
    }

    public static void main(String[] args)
    {
        while(true)
        {
            Reset();
            if (RoundValidnate())
            {
                Round();
                Result();

                if(!Continue())
                    break;
            }
            else
                break;
        }

    }
}
