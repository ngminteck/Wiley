package com.sg.view;

import java.util.Scanner;

public class UserIO
{
    private final Scanner sc;

    UserIO()
    {
        sc = new Scanner(System.in).useDelimiter("\n");
    }

    public String GetNameFromUserInput()
    {
        String msg;
        boolean pass;
        do
        {
            System.out.println("Please enter the customer name.");
            System.out.println("May not be blank, allowed to contain [a-z][0-9] as well as periods and comma characters.");
            msg = sc.next();

            pass = msg.matches("^\\w+( ,.\\w+)*$");


        }
        while (!pass);

        return msg;

    }

    public double GetAreaFromUser()
    {
        double userOption = 0;
        do {

            System.out.println("Please enter the area.");
            System.out.println("The area must be a positive decimal. Minimum order size is 100 sq ft.");

            if(sc.hasNextDouble())
                 userOption = sc.nextDouble();


        }
        while (!sc.hasNextDouble() && userOption >= 100);
        return userOption;
    }

    public int GetListChoiceFromUser(int maxOption, String instructionMessage)
    {
        int userOption = 0;
        do {
            System.out.println(instructionMessage);
            if(sc.hasNextInt())
                userOption = sc.nextInt();


        }
        while (userOption >= 1 && userOption  <= maxOption);
        return userOption;
    }

}
