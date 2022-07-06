package com.sg.controller;

import com.sg.dao.*;
import com.sg.dto.Item;
import com.sg.dto.ItemWrapper;
import com.sg.dto.Money;
import com.sg.service.VendingMachineServiceLayer;
import com.sg.ui.VendingMachineView;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;

public class VendingMachineController {

    private final VendingMachineView view;
    private final VendingMachineServiceLayer myService;


    public VendingMachineController(VendingMachineView view, VendingMachineServiceLayer myService) {
        this.view = view;
        this.myService = myService;
    }


    public void Run()
    {
       myService.LoadFile();
        while (true)
        {
            int optionsMainMenu = view.PrintMainMenu();

            if(optionsMainMenu == 1)
            {
                myService.BuyMenu();
            }
            else  if(optionsMainMenu == 2)
            {
                myService.StockUpMenu();
            }
            else
            {
                break;
            }
        }

        myService.SaveFile();


    }










}
