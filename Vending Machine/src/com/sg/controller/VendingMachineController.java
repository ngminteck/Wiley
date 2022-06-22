package com.sg.controller;

import com.sg.dao.InventoryFileImpl;
import com.sg.dto.Item;
import com.sg.dto.Money;
import com.sg.ui.VendingMachineView;
import javafx.util.Pair;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

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
            int optionsMainMenu = view.PrintMainMenu();


            if(optionsMainMenu == 1)
            {
                BuyMenu();
            }
            else  if(optionsMainMenu == 2)
            {

            }
            else
            {
                break;
            }
        }
    }

    private void BuyMenu()
    {
        while (true) {
            int buyOptions = view.PrintBuyDisplayMenu(inventory.getItems(), inventory.getUserInputMoneys());

            if (buyOptions == 1) {
                int insertOption = view.InsertMoneyMenu(inventory.getUserInputMoneys());

                if(insertOption == 0)
                {
                    // refund if any coin insert
                    break;
                }

            } else if (buyOptions == 2) {

            }
            else
            {
                // refund if any coin insert
                break;
            }

        }
    }
}
