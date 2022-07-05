package com.sg.controller;

import com.sg.dao.DVDLibrary;
import com.sg.dto.DVD;
import com.sg.ui.Display;

import java.time.LocalDate;

public class Controller
{
    private final Display view;
    private final DVDLibrary dvdLibrary;

    public Controller(Display view, DVDLibrary dvdLibrary) {
        this.view = view;
        this.dvdLibrary = dvdLibrary;
    }

    public void Run()
    {
        dvdLibrary.LoadDVD();
        boolean run = true;
        while(run)
        {
            switch (view.MainMenu())
            {
                case 1:
                    view.StartBanner("Add Menu");
                    view.AddDVD(dvdLibrary);
                    view.CloseBanner();
                    break;
                case 2:
                    view.StartBanner("Remove Menu");
                    int options1 = view.DVDOptionsChoice(dvdLibrary.DisplayList(),dvdLibrary.getDVDListSize());
                    if(options1 >= 1 && options1 <= dvdLibrary.getDVDListSize())
                    {
                        dvdLibrary.RemoveDVD(options1 -1);
                    }
                    view.CloseBanner();
                    break;
                case 3:
                    view.StartBanner("Edit Menu");
                    int options2 = view.DVDOptionsChoice(dvdLibrary.DisplayList(),dvdLibrary.getDVDListSize());
                    if(options2 >= 1 && options2 <= dvdLibrary.getDVDListSize())
                    {
                        int index = options2 - 1;
                        boolean loop = true;
                        DVD selectedDVD = dvdLibrary.FindDVD(index);
                        String title = selectedDVD.getTitle();
                        LocalDate localDate =selectedDVD.getReleaseDate();
                        String mpaa = selectedDVD.getmPAARating();
                        String directorName = selectedDVD.getDirectorName();
                        String studioName = selectedDVD.getStudio();
                        String ratingAndComment = selectedDVD.getRatingAndNote();
                        while(loop)
                        {
                            view.StartBanner("Edit Menu - " + title);
                            String info = "Title=" + title + " Release Date=" + localDate + " MPAA Rating="+ mpaa + " Director's Name=" + directorName + " Studio Name=" + studioName + "\n Rating & Comment=" + ratingAndComment;
                            int options3 = view.EditDVDChoice(info);

                            switch (options3)
                            {
                                case 1:
                                    title = view.getIo().StringInput("Please enter the title name.");
                                    break;
                                case 2:
                                    localDate = view.getIo().LocalDateInput("Please enter the release date in yyyy-mm-dd format.\n Example:2022-05-01");
                                    break;
                                case 3:
                                    mpaa = view.getIo().StringInput("Please enter the MPAA rating.");
                                    break;
                                case 4:
                                    directorName = view.getIo().StringInput("Please enter the director's name.");
                                    break;
                                case 5:
                                    studioName = view.getIo().StringInput("Please enter the studio name.");
                                    break;
                                case 6:
                                    ratingAndComment = view.getIo().StringInput("Please the rating & comment.");
                                    break;
                                case 0:
                                    loop = false;
                            }
                            view.CloseBanner();
                        }
                        dvdLibrary.EditDVD(index,title,localDate,mpaa,directorName,studioName,ratingAndComment);
                    }
                    view.CloseBanner();
                    break;
                case 4:
                    view.StartBanner("List Menu");
                    view.ListDVD(dvdLibrary.DisplayList());
                    view.CloseBanner();
                    break;
                case 5:
                    view.StartBanner("View Detail Menu");
                    int options4 = view.DVDOptionsChoice(dvdLibrary.DisplayList(),dvdLibrary.getDVDListSize());
                    if(options4 >= 1 && options4 <= dvdLibrary.getDVDListSize())
                    {
                        System.out.println(dvdLibrary.DisplayInformation(options4 - 1));
                    }
                    view.CloseBanner();
                    break;
                case 6:
                    view.StartBanner("Search Menu");
                    while(true) {
                        String title = view.getIo().StringInput("Type the title name to search.");
                        DVD foundDVD = dvdLibrary.SearchDVD(title);
                        if (foundDVD == null) {
                            System.out.println(title + " not found.");
                        } else {
                            System.out.println("" + (dvdLibrary.getDVDIndex(foundDVD) + 1) + "#" + foundDVD);
                        }

                        int options5 = view.getIo().UserIntChoice(new StringBuilder("1.Continue Search.\n0.Back to main menu."),1);

                        if(options5 == 0)
                            break;
                    }
                    view.CloseBanner();
                    break;
                default:
                    run = false;
            }
        }
        dvdLibrary.SaveDVD();

    }
}
