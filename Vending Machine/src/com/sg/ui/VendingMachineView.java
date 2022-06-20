package com.sg.ui;

public class VendingMachineView {
    private UserIO io;

    public VendingMachineView(UserIO io) {
        this.io = io;
    }

    public int PrintBuyItemOrStockUp()
    {
        return io.BuyItemOrStockUpMenu();
    }

    public void DisplayInventory()
    {

    }

}
