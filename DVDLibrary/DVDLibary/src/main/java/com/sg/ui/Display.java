package com.sg.ui;

import com.sg.dao.DVDLibrary;

import java.time.LocalDate;

public class Display
{
    private final UserInput userInput;

    public Display(UserInput io) {
        this.userInput = io;
    }

    public UserInput getIo() {
        return userInput;
    }

    private void PrintTwoLine()
    {
        System.out.println("================================================================================");
    }
    public void StartBanner(String header)
    {
        PrintTwoLine();
        System.out.println(header);
        PrintTwoLine();
    }

    public void CloseBanner()
    {
        PrintTwoLine();
        System.out.println();
    }

    public int MainMenu()
    {
        StringBuilder inst = new StringBuilder("1.Add New DVD.");
        inst.append("\n").append("2.Remove DVD.");
        inst.append("\n").append("3.Edit DVD.");
        inst.append("\n").append("4.List DVD.");
        inst.append("\n").append("5.Display DVD in detail.");
        inst.append("\n").append("6.Search DVD.");
        inst.append("\n").append("0.Exit.");
        return userInput.UserIntChoice(inst,6);
    }

    public void AddDVD(DVDLibrary dvdLibrary)
    {
        String title = userInput.StringInput("Please enter the title name.");
        LocalDate localDate = userInput.LocalDateInput("Please enter the release date in yyyy-mm-dd format.\nExample:2022-05-01");
        String mpaa = userInput.StringInput("Please enter the MPAA rating.");
        String directorName = userInput.StringInput("Please enter the director's name.");
        String studioName = userInput.StringInput("Please enter the studio name.");
        String ratingAndNote = userInput.StringInput("Please the rating & comment.");

        dvdLibrary.AddDVD(title,localDate,mpaa,directorName,studioName,ratingAndNote);
    }

    public int DVDOptionsChoice(StringBuilder list, int optionsChoice)
    {
        list.append("\n0# Return to main menu.\nType the number options.");
        return userInput.UserIntChoice(list,optionsChoice);
    }

    public int EditDVDChoice(String dvdInformation)
    {
        StringBuilder inst = new StringBuilder("Current edit DVD Info:");
        inst.append(dvdInformation);
        inst.append("\n").append("1.Edit title.");
        inst.append("\n").append("2.Edit release date.");
        inst.append("\n").append("3.Edit MPAA rating.");
        inst.append("\n").append("4.Edit director's name.");
        inst.append("\n").append("5.Edit studio name.");
        inst.append("\n").append("6.Edit rating & comment.");
        inst.append("\n").append("0.Exit.");
        return userInput.UserIntChoice(inst,6);

    }


    public void ListDVD(StringBuilder list)
    {
        System.out.println(list);
        System.out.println("Type anything to return main menu.");
        userInput.Continue();
    }
}
