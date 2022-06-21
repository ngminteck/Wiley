package com.sg.ui;

import com.sg.dto.Item;
import com.sg.dto.Money;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class VendingMachineView {
    private UserIO io;

    public VendingMachineView(UserIO io) {
        this.io = io;
    }

    private void PrintSeprater()
    {
        System.out.println("================================================================================");
    }
    private void StartBanner(String header)
    {
        PrintSeprater();
        System.out.println(header);
        PrintSeprater();
    }

    private void CloseBanner()
    {
        PrintSeprater();
        System.out.println();
    }

    public int PrintMainMenu()
    {
        StartBanner("Main Menu");
        int result = io.BuyItemOrStockUpMenu();
        CloseBanner();
        return result;
    }

    public int PrintBuyMenu(Set<Pair<Item, Integer>> items, Map<Money, Integer> userInputMoney)
    {
        StartBanner("Buy Menu");
        int result = io.BuyItemMenu(items, userInputMoney);
        CloseBanner();
        return result;
    }

    public void InsertMoneyMenu(Map<Money, Integer> userInputMoney)
    {
        StartBanner("Insert Money Menu");
        io.InsertMoneyMenu(userInputMoney);
        CloseBanner();
    }



}
