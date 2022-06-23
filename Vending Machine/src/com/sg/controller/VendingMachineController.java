package com.sg.controller;

import com.sg.dao.InventoryFileImpl;
import com.sg.dto.Item;
import com.sg.dto.ItemWrapper;
import com.sg.ui.VendingMachineView;

import java.math.BigDecimal;

public class VendingMachineController {

    private final VendingMachineView view;
    private final InventoryFileImpl inventory;


    public VendingMachineController(VendingMachineView view, InventoryFileImpl inventory) {
        this.view = view;
        this.inventory = inventory;
    }

    public void Init()
    {

        inventory.PreAddItemReplaceIfExisted(new Item("Mineral Water Bottle 500ml", new BigDecimal("0.70")),10);
        inventory.PreAddItemReplaceIfExisted(new Item("Sprite Can 330ml", new BigDecimal("0.85")),6);
        inventory.PreAddItemReplaceIfExisted(new Item("7up Can 330ml", new BigDecimal("0.75")),7);
        inventory.PreAddItemReplaceIfExisted(new Item("Coke can 330ml", new BigDecimal("1.20")),0);
        inventory.PreAddItemReplaceIfExisted(new Item("Pepsi can 330ml", new BigDecimal("1.00")),2);
        inventory.PreAddItemReplaceIfExisted(new Item("Milo can 250ml", new BigDecimal("1.80")),1);
        inventory.PreAddItemReplaceIfExisted(new Item("Nestle Coffee can 250ml", new BigDecimal("1.80")),1);
        inventory.PreAddItemReplaceIfExisted(new Item("Yeo sofa bean milk 330ml", new BigDecimal("0.90")),5);
        inventory.PreAddItemReplaceIfExisted(new Item("Jasmine Green Tea Bottle 500ml", new BigDecimal("2.00")),3);
        inventory.PreAddItemReplaceIfExisted(new Item("Red Bull 500ml", new BigDecimal("2.30")),9);
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
                StockUpMenu();
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
            int options = view.PrintBuyMenu(inventory.getItems());

            // insert money menu
            if (options == (inventory.getItems().size() + 1)) {

                options = view.PrintInsertMoneyMenu();
            }

            // buying stuff
            if(options > 0 && options <= inventory.getItems().size())
            {
                if(SuccessFullyBuy(options))
                {
                    options = 0;
                }

            }

            if(options == 0)
            {
                // set insert money to zero
                view.getIo().InitUserInputMoneyLinkHashMap();
                break;
            }

        }
    }

    private Boolean SuccessFullyBuy(int options)
    {
        int index = options - 1;

        ItemWrapper selectedItem = inventory.getItems().get(index);

        if(selectedItem.getStock() <= 0 )
        {
            System.out.println(options + ":" + selectedItem.getItem().getName() + " is out of stock.");
            return false;
        }

        BigDecimal userMoney = view.getIo().CountUserInputMoney();
        if(selectedItem.getItem().getCost().compareTo(userMoney) > 0)
        {
            System.out.println("Insufficient amount.");
            return false;
        }

        inventory.RemoveItemCount(index, 1);
        System.out.println("Successfully purchase " + selectedItem.getItem().getName() +".");
        System.out.println("Thank you for buying.");
        return true;

    }

    public void StockUpMenu()
    {
        while (true)
        {
            int options = view.PrintStockUpMenu(inventory.getItems());

            if(options > 0 && options <= inventory.getItems().size())
            {
                int index = options - 1;
                ItemWrapper item = inventory.getItems().get(index);
                String name = item.getItem().getName();
                BigDecimal price = item.getItem().getCost();
                Integer count = item.getStock();
                view.StartBanner("Edit " + name + " menu");
                while(true)
                {
                    int editOptions = view.PrintItemEditMenu(name,price,count);
                    
                    if(editOptions == 1)
                    {
                        name = view.getIo().StringInput();
                        inventory.ModifyItemProduct(index,name,price,count);
                        System.out.println("Name updated.");
                    }
                    else if (editOptions == 2)
                    {
                        price =view.getIo().BigDecimalInput();
                        inventory.ModifyItemProduct(index,name,price,count);
                        System.out.println("Price updated.");
                    }
                    else if (editOptions == 3)
                    {
                        count = view.getIo().IntegerInput();
                        System.out.println("Stock updated.");
                        inventory.ModifyItemProduct(index,name,price,count);
                    }
                    else if (editOptions == 4)
                    {
                        inventory.RemoveItemProduct(index);
                        System.out.println("Item removed.");
                        editOptions = 0;
                    }

                    if(editOptions == 0)
                        break;
                }
                view.CloseBanner();
            }
            // add new item
            else if (options == (inventory.getItems().size() + 1)) {

                String name = view.getIo().StringInput();
                BigDecimal price = view.getIo().BigDecimalInput();
                Integer count = view.getIo().IntegerInput();

                inventory.AddNewItemProduct(name,price,count);

            }

            if(options == 0)
            {
                // save file
                break;
            }

        }
    }
}
