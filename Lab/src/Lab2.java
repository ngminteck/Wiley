import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
class OddAndEvenArray
{
    ArrayList<Integer> oddArray = new ArrayList<Integer>();
    ArrayList<Integer> evenArray = new ArrayList<Integer>();

    public void FilterOddAndEven()
    {
        for(int i = 1; i <= 50; ++i)
        {
            if(i % 2 == 0)
                evenArray.add(i);
            else
                oddArray.add(i);
        }
    }
}
// wrap into custom class will more neat than using 2 out array parameter for 2 return.
class SortArray
{
    ArrayList<Integer> ascArray = new ArrayList<Integer>();
    ArrayList<Integer> descArray = new ArrayList<Integer>();
    public void SortArray(Integer [] arr)
    {
        for(int i = 0; i < arr.length; ++i)
        {
            ascArray.add(arr[i]);
            descArray.add(arr[i]);
        }
        Collections.sort(ascArray);
        Collections.sort(descArray , Collections.reverseOrder());
    }
}

public class Lab2
{
    public static void Question1()
    {
        Scanner userInput = new Scanner(System.in);

        int age = 0;
        System.out.println("Please enter your age.");
        while(!userInput.hasNextInt())
        {
            System.out.println("Please enter your age.");
            userInput.next();
        }
        age = userInput.nextInt();

        boolean single;

        // is better to take Y or N , somehow the chars have some issue.
        System.out.println("Are you single? Type true if yes, type false if no.");
        while(!userInput.hasNextBoolean())
        {
            System.out.println("Are you single? Type true if yes, type false if no.");
            userInput.next();
        }

        single = userInput.nextBoolean();

        boolean wearShoe;

        System.out.println("Do you wear shoe? Type true if yes, type false if no.");
        while(!userInput.hasNextBoolean())
        {
            System.out.println("Do you wear shoe? Type true if yes, type false if no.");
            userInput.next();
        }

        wearShoe = userInput.nextBoolean();

        if(age >= 21 && !single && wearShoe)
            System.out.println("Welcome to the party!");
        else
            System.out.println("Sorry! you did not met the requirement");

    }
    public static void Question2()
    {
        Scanner userInput = new Scanner(System.in);

        int grade = 0;
        System.out.println("Please enter your grade.");
        while(!userInput.hasNextInt())
        {
            System.out.println("Please enter your grade.");
            userInput.next();
        }
        grade = userInput.nextInt();

        if(grade >= 90)
            System.out.println("Gratz!! you got A!!!");
        else if (grade >= 80 )
            System.out.println("Good! you got B!!");
        else if (grade >= 70 )
            System.out.println("Not bad! you got C!!");
        else
            System.out.println("So Sorry, you failed the module. Digipen college sad life... =(");

    }
    public static void Question3()
    {
        for (int i = 0; i < 6 ; ++i)
        {
            String msg ="";
            for (int j = i; j < 6 ; ++j)
            {
                msg+="*";
            }
            System.out.println(msg);
        }

        for (int i = 6; i >= 0 ; --i)
        {
            String msg ="";
            for (int j = i; j < 6 ; ++j)
            {
                msg+="*";
            }
            System.out.println(msg);
        }

        System.out.println(" ");

        char stars[] = new char[13];
        Arrays.fill(stars, ' ');

        int center = stars.length / 2;
        for(int i =0; i < 6; ++i)
        {
            if(i < 4)
            {
                String msg ="";
                stars[center + i * 2] = '*';
                stars[center - i * 2] = '*';
                for(int j = 0; j< stars.length; ++j)
                {
                    msg+=stars[j];
                }
                System.out.println(msg);
            }
            else
            {
                // can just print seem all same, stars index at 5 & 7
                System.out.println("     * *     ");
            }
        }

    }
    public static void Question4()
    {
        int[] arrays = {2, 3, 55, 65, 42, 67};
        String msg = "";
        for(int i=0; i < arrays.length; ++i)
        {

            if(arrays[i] % 2 == 0)
            {
                msg += arrays[i];
                msg += " ";
            }
        }
        System.out.println(msg);
    }
    public static void Question5()
    {
        OddAndEvenArray arr = new OddAndEvenArray();
        arr.FilterOddAndEven();

        String msg = "Odd:";
        for(int i = 0; i < arr.oddArray.size(); ++i)
        {
            int number = arr.oddArray.get(i);
            msg += number;
            msg += " ";
        }
        System.out.println(msg);

        msg = "Even:";
        for(int i = 0; i < arr.evenArray.size(); ++i)
        {
            int number = arr.evenArray.get(i);
            msg += number;
            msg += " ";
        }
        System.out.println(msg);

    }
    public static void Question6()
    {
        Integer [] arr = {2, 34, 56, 12, 34, 1, 5};
        SortArray array = new SortArray();
        array.SortArray(arr);

        String msg = "Asc Order:";
        for(int i = 0; i < array.ascArray.size(); ++i)
        {
            int number = array.ascArray.get(i);
            msg += number;
            msg += " ";
        }
        System.out.println(msg);

        msg = "Des Order:";
        for(int i = 0; i < array.descArray.size(); ++i)
        {
            int number = array.descArray.get(i);
            msg += number;
            msg += " ";
        }
        System.out.println(msg);
    }


    public static void main(String[] args)
    {
        //Question1();
        //Question2();
        //Question3();
        //Question4();
        //Question5();
        Question6();
    }
}
