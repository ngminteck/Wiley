package com.sg.controller;

import com.sg.dao.Inventory;
import com.sg.ui.VendingMachineView;

public class VendingMachineController {

    private VendingMachineView view;
    private Inventory inventory;


    public VendingMachineController(VendingMachineView view, Inventory inventory) {
        this.view = view;
        this.inventory = inventory;
    }

    public void Run()
    {
        while (true)
        {
            int options = view.PrintBuyItemOrStockUp();

            if(options == 1)
            {
                view.StartBanner("Display Item");

                view.CloseBanner();
            }
            else
            {

            }
        }
    }
}
