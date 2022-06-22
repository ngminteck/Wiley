package com.sg.ui;

import com.sg.dto.Item;
import com.sg.dto.Money;
import javafx.util.Pair;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class UserIO {

    private final Scanner sc;
    public UserIO()
    {
        sc = new Scanner(System.in).useDelimiter("\n");
    }


    public int BuyItemOrStockUpMenu()
    {
        System.out.println("Welcome to my vending machine.");
        int userOption;
        do {
            userOption = -1;
            System.out.println("0:Exit.");
            System.out.println("1:Buy stuff.");
            System.out.println("2:Stock up item or cash.");
            System.out.println("Type the number options.");
            if(sc.hasNextInt()) {
                userOption = sc.nextInt();

                if(userOption != 0 && userOption != 1 && userOption != 2)
                    System.out.println("Invalid request!");

            }
            else {
                sc.next();
                System.out.println("Invalid request!");
            }
        }
        while (userOption != 0 && userOption != 1 && userOption != 2);
        return userOption;
    }


    public int BuyMenu(ArrayList<Pair<Item, Integer>> items, Map<Money, Integer> userInputMoney)
    {

        Set<Money> keys = userInputMoney.keySet();
        BigDecimal currentTotalValue;
        int userOption;
        do {
            userOption = -1;

            items.forEach(i-> System.out.println((items.indexOf(i) + 1) +":" + i.getKey().getName() +" $"+ i.getKey().getCost()));
            System.out.println();

            currentTotalValue = new BigDecimal("0.00");
            for (Money key : keys)
            {
                currentTotalValue = currentTotalValue.add(BigDecimal.valueOf( userInputMoney.get(key) ).multiply( key.getMoneyValue()));
            }
            System.out.println("Current insert value:$" + currentTotalValue );

            System.out.println("0:Cancel and exit to main menu.");
            System.out.println((items.size() + 1) + ":Insert money.");
            System.out.println("Type the number options.");
            if(sc.hasNextInt()) {
                userOption = sc.nextInt();

                if(userOption < 0 && userOption > (items.size() + 1))
                    System.out.println("Invalid request!");

            }
            else {
                sc.next();
                System.out.println("Invalid request!");
            }
        }
        while (userOption < 0 && userOption > (items.size() + 1));

        int nextOptions = 0;
        if(userOption == items.size() + 1)
            nextOptions = 1;

        return nextOptions;
    }

    public int InsertMoneyMenu(Map<Money, Integer> userInputMoney)
    {
        Set<Money> keys = userInputMoney.keySet();
        BigDecimal currentTotalValue = new BigDecimal("0.00");
        for (Money key : keys)
        {
            currentTotalValue = currentTotalValue.add(BigDecimal.valueOf( userInputMoney.get(key) ).multiply( key.getMoneyValue()));
        }
        System.out.println("Current insert value:$" + currentTotalValue );
        System.out.println("Example: to insert 3 one dollar, type \"1 3\" --[Money Value] [Count]" );
        System.out.println("Example: to insert 2 two dollar and 1 fifty cent, type \"2 2 0.5 1\" or \"0.5 1 2 2\"" );
        System.out.println("Type 0 alone to exit to main menu." );
        String msg = sc.next();

        if(msg.length() == 1 && msg.charAt(0) == '0')
            return 0;

        String[] data = msg.split(" ");

        for (int i = 0; i < data.length; i += 2)
        {
            if (i + 1 > data.length)
                break;

            int quantity = 0;
            try {
                quantity = Integer.parseInt(data[i + 1]);
            } catch (NumberFormatException ignored) {

            }
            if (quantity < 1)
                continue;

            double value = 0.00;
            try {
                value = Double.parseDouble(data[i]);
            } catch (NumberFormatException ignored) {

            }
            BigDecimal moneyValue =  BigDecimal.valueOf(value);
            moneyValue = moneyValue.setScale(2, RoundingMode.HALF_UP);
            Money moneyEnum = Money.GetEnumByMoneyValue(moneyValue);

            if(moneyEnum == null)
                continue;

            System.out.println("Inserting " + quantity + " " + moneyEnum + " into the machine.");

            Integer newCount =  userInputMoney.get(moneyEnum) + quantity;
            userInputMoney.put(moneyEnum,newCount);

        }

        currentTotalValue = new BigDecimal("0.00");
        for (Money key : keys)
        {
            currentTotalValue = currentTotalValue.add(BigDecimal.valueOf( userInputMoney.get(key) ).multiply( key.getMoneyValue()));
        }
        System.out.println("Current insert value:$" + currentTotalValue );
        return 1;
    }


}
