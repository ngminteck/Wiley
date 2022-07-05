package com.sg.ui;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class UserInput
{
    private final Scanner sc;

    public UserInput()
    {
        sc = new Scanner(System.in).useDelimiter("\n");

    }

    public int UserIntChoice(StringBuilder msg, int maxValidChoice)
    {
        int userOption;
        do {
            userOption = -1;
            System.out.println(msg);
            if(sc.hasNextInt()) {
                userOption = sc.nextInt();

                if(userOption < 0 && userOption > maxValidChoice)
                    System.out.println("Invalid request!");

            }
            else {
                sc.next();
                System.out.println("Invalid request!");
            }
        }
        while (userOption < 0 && userOption > maxValidChoice);
        return userOption;
    }

    public String StringInput(String instruction)
    {
        System.out.println(instruction);
        String userInput = sc.next();
        userInput = userInput.replaceAll("\"","");
        return userInput;
    }

    public LocalDate LocalDateInput(String instruction)
    {
        boolean valid = false;
        LocalDate localDate = null;
        while(!valid)
        {
            System.out.println(instruction);
            try
            {
                localDate =  LocalDate.parse(sc.next());
                valid = true;
            }
            catch (DateTimeParseException ignored )
            {

            }

        }
        return localDate;
    }

    public void Continue()
    {
        sc.next();
    }

}
