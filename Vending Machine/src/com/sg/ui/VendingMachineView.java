package com.sg.ui;

import com.sg.dto.Item;
import com.sg.dto.Money;
import javafx.util.Builder;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Map;

public class VendingMachineView {
    private final UserIO io;

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

    private StringBuilder PrintInventoryList(ArrayList<Pair<Item, Integer>> items)
    {
        StringBuilder chars = new StringBuilder();
        items.forEach(i -> chars.append((items.indexOf(i) + 1) + ":" + i.getKey().getName() +" $"+ i.getKey().getCost() +"\n"));
        return chars;
    }



    public int PrintMainMenu()
    {
        StartBanner("Main Menu");
        System.out.println("Welcome to my vending machine.");
        int result = io.BuyItemOrStockUpMenu();
        CloseBanner();
        return result;
    }

    public int PrintBuyMenu(ArrayList<Pair<Item, Integer>> items)
    {
        StartBanner("Buy Menu");
        StringBuilder msg = PrintInventoryList(items);
        msg.append("0:Cancel and exit to main menu.\n");
        msg.append((items.size() + 1));
        msg.append(":Insert money.\n");
        msg.append("Type the number options.");
        int result = io.BuyMenu(msg,items.size() + 1);
        CloseBanner();
        return result;
    }

    public int InsertMoneyMenu()
    {
        StartBanner("Insert Money Menu");
        int result = io.InsertMoneyMenu();
        CloseBanner();
        return result;
    }





}
