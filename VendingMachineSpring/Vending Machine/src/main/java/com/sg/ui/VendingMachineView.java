package com.sg.ui;

import com.sg.dto.ItemWrapper;

import java.math.BigDecimal;
import java.util.ArrayList;

public class VendingMachineView {
    private final UserIO io;

    public VendingMachineView(UserIO io) {
        this.io = io;
    }

    public UserIO getIo() {
        return io;
    }

    private void PrintTwoLine()
    {
        System.out.println("================================================================================");
    }
    public void StartBanner(String header)
    {
        PrintTwoLine();
        System.out.println(header);
        PrintTwoLine();
    }

    public void CloseBanner()
    {
        PrintTwoLine();
        System.out.println();
    }

    private StringBuilder PrintInventoryList(ArrayList<ItemWrapper> items)
    {
        StringBuilder chars = new StringBuilder();
        items.forEach(i -> chars.append(items.indexOf(i) + 1).append(":").append(i.getItem().getName()).append(" $").append(i.getItem().getCost()).append(" stock:").append(i.getStock()).append("\n"));
        return chars;
    }



    public int PrintMainMenu()
    {
        StartBanner("Main Menu");
        System.out.println("Welcome to my vending machine.");
        StringBuilder msg = new StringBuilder("1.Buy stuff.\n2.Edit item list.\n0.Exit.");
        int result = io.UserIntChoice(msg,2);
        CloseBanner();
        return result;
    }

    public int PrintBuyMenu(ArrayList<ItemWrapper> items)
    {
        StartBanner("Buy Menu");
        StringBuilder msg = PrintInventoryList(items);
        msg.append("0:Cancel and exit to main menu.\n");
        msg.append((items.size() + 1));
        msg.append(":Insert money.");
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
        int result = io.UserIntChoice(msg,items.size() + 1);
        CloseBanner();
        return result;
    }


    public int PrintItemEditMenu(String name, BigDecimal price, Integer count)
    {
        StringBuilder msg = new StringBuilder("Item Info: Name:"+ name + " Price:$" + price + " Stock:" + count + "\n");
        msg.append("1.Edit the name.\n2.Edit the price.\n3.Edit the count.\n4.Remove the item.\n0.Exit to Stock Up Menu.");
        int result = io.UserIntChoice(msg,4);
        CloseBanner();
        return result;
    }

    public void displayErrorMessage(String errorMsg) {
        StartBanner("Error");
        System.out.println(errorMsg);
        CloseBanner();
    }


}
