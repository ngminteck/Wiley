package com;

import com.sg.controller.VendingMachineController;
import com.sg.dao.Inventory;
import com.sg.dao.InventoryFileImpl;
import com.sg.ui.UserIO;

import com.sg.ui.VendingMachineView;

import java.math.BigDecimal;

public class App
{
    public static void main(String[] args)
    {
        UserIO myIO = new UserIO();
        VendingMachineView myView = new VendingMachineView(myIO);

        InventoryFileImpl myInventory = new InventoryFileImpl(new BigDecimal("2.00"));

        VendingMachineController controller = new VendingMachineController(myView,myInventory);
        // uncomment Init if want hardcore add item and money into the vending machine
        controller.Init();
        controller.Run();

    }
}
