package com.sg.ui;

import com.sg.dto.Money;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class UserIO {

    private final Scanner sc;

    private final Map<Money, Integer> userInputMoneys = new LinkedHashMap<>();
    public UserIO()
    {
        sc = new Scanner(System.in).useDelimiter("\n");
        InitUserInputMoneyLinkHashMap();
    }

    public Map<Money, Integer> getUserInputMoneys() {
        return userInputMoneys;
    }

    public String StringInput()
    {
        System.out.println("Please enter the name of the product,\" character will be remove.");
        String userInput = sc.next();
        userInput.replaceAll("\"","");
        return sc.next();
    }

    public BigDecimal BigDecimalInput()
    {
        do {
            System.out.println("Please enter the price for the product.");

            if(sc.hasNextDouble()) {
                double userOption = sc.nextDouble();
                BigDecimal price = new BigDecimal(userOption);
                price = price.setScale(2, RoundingMode.HALF_UP);
                System.out.println("Price are set $:" + price +".");
                return price;

            }
            else {
                sc.next();
                System.out.println("Invalid input!");
            }
        }
        while (!sc.hasNextDouble());

        return BigDecimal.ZERO;
    }
    public Integer IntegerInput()
    {
        do {
            System.out.println("Please enter the quantity for the product.");

            if(sc.hasNextInt()) {
                return sc.nextInt();

            }
            else {
                sc.next();
                System.out.println("Invalid input!");
            }
        }
        while (!sc.hasNextInt());

        return 0;
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

    public int BuyMenu(StringBuilder msg, int validChoiceLimit)
    {
        int userOption;
        do {
            userOption = -1;

            System.out.println(msg);
            System.out.println("Current insert value:$" + CountUserInputMoney());


            if(sc.hasNextInt()) {
                userOption = sc.nextInt();

                if(userOption < 0 && userOption > validChoiceLimit)
                    System.out.println("Invalid request!");

            }
            else {
                sc.next();
                System.out.println("Invalid request!");
            }
        }
        while (userOption < 0 && userOption > validChoiceLimit);

        return userOption;
    }

    public int InsertMoneyMenu()
    {
        System.out.println("Example: to insert 3 one dollar, type \"1 3\" --[Money Value] [Count]" );
        System.out.println("Example: to insert 2 two dollar and 1 fifty cent, type \"2 2 0.5 1\" or \"0.5 1 2 2\"" );
        System.out.println("Type 0 alone to exit to main menu." );
        System.out.println("Current insert value:$" + CountUserInputMoney());
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

            AddUserInputMoney(moneyEnum,quantity);

        }
        System.out.println("Current insert value:$" + CountUserInputMoney());
        return -1;
    }

    public void InitUserInputMoneyLinkHashMap() {
        userInputMoneys.put(Money.TWO_DOLLAR,0);
        userInputMoneys.put(Money.ONE_DOLLAR,0);
        userInputMoneys.put(Money.FIFTY_CENT,0);
        userInputMoneys.put(Money.TWENTY_CENT,0);
        userInputMoneys.put(Money.TEN_CENT,0);
        userInputMoneys.put(Money.FIVE_CENT,0);
        userInputMoneys.put(Money.ONE_CENT,0);
    }

    public BigDecimal CountUserInputMoney()
    {
        BigDecimal currentTotalValue = new BigDecimal("0.00");
        Set<Money> keys = userInputMoneys.keySet();
        for (Money key : keys)
        {
            currentTotalValue = currentTotalValue.add(BigDecimal.valueOf( userInputMoneys.get(key) ).multiply( key.getMoneyValue()));
        }
        return currentTotalValue;
    }

    public void PrintChange()
    {
        StringBuilder msg = new StringBuilder("Change:");
        Set<Money> keys = userInputMoneys.keySet();
        for (Money key : keys)
        {
            if(userInputMoneys.get(key) > 0)
            {
                msg.append(" ").append(userInputMoneys.get(key)).append(" ").append(key.toString());

            }
        }
        System.out.println(msg);
    }

    public void AddUserInputMoney(Money money, Integer count)
    {
        Integer newCount =  userInputMoneys.get(money) + count;
        System.out.println("Inserting " + count + " " + money + " into the machine.");
        userInputMoneys.put(money,newCount);
    }





}
