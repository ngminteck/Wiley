package com.sg.controller;

import com.sg.dao.InventoryFileImpl;
import com.sg.dto.Item;
import com.sg.dto.Money;
import com.sg.ui.VendingMachineView;

import java.math.BigDecimal;

public class VendingMachineController {

    private VendingMachineView view;
    private InventoryFileImpl inventory;


    public VendingMachineController(VendingMachineView view, InventoryFileImpl inventory) {
        this.view = view;
        this.inventory = inventory;
    }

    public void Init()
    {
        inventory.PreAddMoneyReplace(Money.TWO_DOLLAR,0);
        inventory.PreAddMoneyReplace(Money.ONE_DOLLAR,100);
        inventory.PreAddMoneyReplace(Money.FIFTY_CENT,100);
        inventory.PreAddMoneyReplace(Money.TWENTY_CENT,100);
        inventory.PreAddMoneyReplace(Money.TEN_CENT,100);
        inventory.PreAddMoneyReplace(Money.FIVE_CENT,100);
        inventory.PreAddMoneyReplace(Money.ONE_CENT,100);

        inventory.PreAddItemReplaceIfExisted(new Item("Dasani Mineral Water Bottle 500ml", new BigDecimal("0.70")),10);
        inventory.PreAddItemReplaceIfExisted(new Item("Sprite Can 330ml", new BigDecimal("0.85")),10);
        inventory.PreAddItemReplaceIfExisted(new Item("7up Can 330ml", new BigDecimal("0.75")),10);
        inventory.PreAddItemReplaceIfExisted(new Item("Coke can 330ml", new BigDecimal("1.20")),10);
        inventory.PreAddItemReplaceIfExisted(new Item("Pepsi can 330ml", new BigDecimal("1.00")),10);
        inventory.PreAddItemReplaceIfExisted(new Item("Milo can 250ml", new BigDecimal("1.80")),10);
        inventory.PreAddItemReplaceIfExisted(new Item("Nestle Coffee can 250ml", new BigDecimal("1.80")),10);
        inventory.PreAddItemReplaceIfExisted(new Item("Yeo sofa bean milk 330ml", new BigDecimal("0.90")),10);
        inventory.PreAddItemReplaceIfExisted(new Item("Jasmine Green Tea Bottle 500ml", new BigDecimal("2.00")),10);
        inventory.PreAddItemReplaceIfExisted(new Item("Red Bull 500ml", new BigDecimal("2.30")),10);
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