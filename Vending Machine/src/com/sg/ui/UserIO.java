package com.sg.ui;

import java.util.Scanner;

public class UserIO {

    private final Scanner sc;
    public UserIO()
    {
        sc = new Scanner(System.in).useDelimiter("\n");
    }

    public int BuyItemOrStockUpMenu()
    {
        int userOption;
        do {
            userOption = 0;
            System.out.println("Welcome to my vending machine, type 1 to buy item, type 2 to stock up item");
            if(sc.hasNextInt()) {
                userOption = sc.nextInt();

                if(userOption != 1 && userOption != 2)
                    System.out.println("Invalid request!");

            }
            else {
                sc.next();
                System.out.println("Invalid request!");
            }
        }
        while (userOption != 1 && userOption != 2);

        return userOption;
    }

}
