package com.sg.ui;

import com.sg.dto.Item;

public class VendingMachineView {
    private UserIO io;

    public VendingMachineView(UserIO io) {
        this.io = io;
    }

    private void PrintSeprater()
    {
        System.out.println("============================================================");
    }
    public void StartBanner(String header)
    {
        PrintSeprater();
        System.out.println(header);
        PrintSeprater();
    }

    public void CloseBanner()
    {
        PrintSeprater();
        System.out.println();
    }

    public int PrintBuyItemOrStockUp()
    {
        StartBanner("Main Menu");
        int result = io.BuyItemOrStockUpMenu();
        CloseBanner();
        return result;
    }

    public void DisplayInventoryItem(int index, Item item)
    {

    }

}
