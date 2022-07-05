package com.sg;

import com.sg.controller.Controller;
import com.sg.dao.DVDLibrary;
import com.sg.ui.Display;
import com.sg.ui.UserInput;

public class App {
    public static void main(String[] args)
    {
        UserInput myIO = new UserInput();
        Display myView = new Display(myIO);

        DVDLibrary myLib= new DVDLibrary();

        Controller controller = new Controller(myView,myLib);

        controller.Run();
    }
}
