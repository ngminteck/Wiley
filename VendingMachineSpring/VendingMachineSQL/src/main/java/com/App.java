package com;

import com.sg.controller.VendingMachineController;
import com.sg.dao.InventoryFileImpl;
import com.sg.ui.UserIO;
import com.sg.ui.VendingMachineView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class App
{
    public static void main(String[] args)
    {
    	SpringApplication.run(App.class, args);
    	
        UserIO myIO = new UserIO();
        VendingMachineView myView = new VendingMachineView(myIO);

        InventoryFileImpl myInventory = new InventoryFileImpl();

        VendingMachineController controller = new VendingMachineController(myView,myInventory);
        // uncomment Init if want hardcore add item and money into the vending machine
       // controller.Init();
        controller.Run();

    }
}
