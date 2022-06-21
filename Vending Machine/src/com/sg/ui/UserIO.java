package com.sg.ui;

import com.sg.dto.Item;
import com.sg.dto.Money;
import javafx.util.Pair;

import java.math.BigDecimal;
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
            userOption = 0;
            System.out.println("1:Buy stuff.");
            System.out.println("2:Stock up item or cash.");
            System.out.println("Type the number options.");
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


    public int BuyItemMenu(Set<Pair<Item, Integer>> items, Map<Money, Integer> userInputMoney)
    {
        ArrayList<Pair<Item,Integer>> itemsArrayList = new ArrayList<>(items);
        Set<Money> keys = userInputMoney.keySet();
        BigDecimal currentTotalValue;
        int userOption;
        do {
            userOption = 0;

            itemsArrayList.forEach(i-> System.out.println(i.getKey().getName() +" $"+ i.getKey().getCost()));

            currentTotalValue = new BigDecimal("0.00");
            for (Money key : keys)
            {
                currentTotalValue = currentTotalValue.add(BigDecimal.valueOf( userInputMoney.get(key) ).multiply( key.getMoneyValue()));
            }
            System.out.println("Current insert value:$" + currentTotalValue );

            System.out.println("1:Insert coin.");
            System.out.println("2:Buy Item.");
            System.out.println("3:Exit to main menu.");
            System.out.println("Type the number options.");
            if(sc.hasNextInt()) {
                userOption = sc.nextInt();

                if(userOption != 1 && userOption != 2 && userOption != 3)
                    System.out.println("Invalid request!");

            }
            else {
                sc.next();
                System.out.println("Invalid request!");
            }
        }
        while (userOption != 1 && userOption != 2 && userOption != 3);
        return userOption;
    }

    public void InsertMoneyMenu(Map<Money, Integer> userInputMoney)
    {
        Set<Money> keys = userInputMoney.keySet();
        BigDecimal currentTotalValue = new BigDecimal("0.00");
        int counter = 1;
        for (Money key : keys)
        {
            System.out.println(counter +":" + key.toString());
            currentTotalValue = currentTotalValue.add(BigDecimal.valueOf( userInputMoney.get(key) ).multiply( key.getMoneyValue()));
        }
        System.out.println("Current insert value:$" + currentTotalValue );
        System.out.println("Example: to insert 3 one dollar, type \"1.00 3\" --[Money Value] [Count]" );
        System.out.println("Example: to insert 2 two dollar and 1 fifty cent, type \"2 2 0.5 1\" or \"0.5 1 2 2\"" );
        String msg = sc.next();

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
            Money moneyEnum = Money.GetEnumByMoneyValue(moneyValue);

            if(moneyEnum == null)
                continue;

            Integer newCount =  userInputMoney.get(moneyEnum) + quantity;
            userInputMoney.put(moneyEnum,newCount);

        }

    }
}
