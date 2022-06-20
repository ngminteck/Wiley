package com;

import com.sg.dao.Inventory;
import com.sg.dao.InventoryFileImpl;
import com.sg.ui.UserIO;

import com.sg.ui.VendingMachineView;

public class App
{
    public static void main(String[] args)
    {
        UserIO myIO = new UserIO();
        VendingMachineView myView = new VendingMachineView(myIO);

        Inventory myInventory = new InventoryFileImpl();

    }
}
