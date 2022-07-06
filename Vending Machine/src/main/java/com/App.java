package com;

import com.sg.controller.VendingMachineController;
import com.sg.dao.InventoryFileImpl;
import com.sg.service.VendingMachineAuditDao;
import com.sg.service.VendingMachineAuditDaoFileImpl;
import com.sg.service.VendingMachineServiceLayer;
import com.sg.ui.UserIO;
import com.sg.ui.VendingMachineView;

public class App
{
    public static void main(String[] args)
    {
        // Instantiate the UserIO implementation
        UserIO myIO = new UserIO();
        // Instantiate the View and wire the UserIO implementation into it
        VendingMachineView myView = new VendingMachineView(myIO);
        // Instantiate the DAO
        InventoryFileImpl myInventory = new InventoryFileImpl();
        // Instantiate the Audit DAO
        VendingMachineAuditDao myAuditDao = new VendingMachineAuditDaoFileImpl();

        // Instantiate the Service Layer and wire the DAO and Audit DAO into it
        VendingMachineServiceLayer myService = new VendingMachineServiceLayer(myInventory, myAuditDao, myView);


        // Instantiate the Controller and wire the Service Layer into it
        VendingMachineController controller = new VendingMachineController(myView,myService);
        // uncomment Init if want hardcore add item and money into the vending machine
       // controller.Init();
        // Kick off the Controller
        controller.Run();





    }
}
