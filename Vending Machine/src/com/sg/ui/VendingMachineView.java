package com.sg.ui;

import com.sg.dto.Item;
import com.sg.dto.ItemWrapper;
import com.sg.dto.Money;
import javafx.util.Builder;
import javafx.util.Pair;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Map;

public class VendingMachineView {
    private final UserIO io;

    public VendingMachineView(UserIO io) {
        this.io = io;
    }

    public UserIO getIo() {
        return io;
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

    private StringBuilder PrintInventoryList(ArrayList<ItemWrapper> items)
    {
        StringBuilder chars = new StringBuilder();
        items.forEach(i -> chars.append((items.indexOf(i) + 1) + ":" + i.getItem().getName() +" $"+ i.getItem().getCost() + " stock:" + i.getStock() + "\n"));
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

    public int PrintBuyMenu(ArrayList<ItemWrapper> items)
    {
        StartBanner("Buy Menu");
        StringBuilder msg = PrintInventoryList(items);
        msg.append("0:Cancel and exit to main menu.\n");
        msg.append((items.size() + 1));
        msg.append(":Insert money.\n");
        msg.append("This machine did not have change. \n");
        msg.append("Type the number options.");
        int result = io.BuyMenu(msg,items.size() + 1);
        CloseBanner();
        return result;
    }

    public int PrintInsertMoneyMenu()
    {
        StartBanner("Insert Money Menu");
        int result = io.InsertMoneyMenu();
        CloseBanner();
        return result;
    }

    public int PrintStockUpMenu(ArrayList<ItemWrapper> items)
    {
        StartBanner("Stock Up Menu");
        StringBuilder msg = PrintInventoryList(items);
        msg.append("0:Cancel and exit to main menu.\n");
        msg.append((items.size() + 1));
        msg.append(":Add non existing item.\n");
        msg.append("Type the number options.");
        int result = io.StockUpMenu(msg,items.size() + 1);
        CloseBanner();
        return result;
    }





}
