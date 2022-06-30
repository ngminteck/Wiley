package com.sg.dao;

import com.sg.dto.DVD;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DVDLibrary
{
    List<DVD> dvdList = new ArrayList<>();



    public void AddDVD(String title, LocalDateTime releaseDate, String mPAARating, String directorName, String studio, String ratingAndNote)
    {
        dvdList.add(new DVD(title,releaseDate,mPAARating,directorName,studio,ratingAndNote));
    }

    public void RemoveDVD(int index)
    {
        dvdList.remove(index);
    }

    public void EditDVD (int index,String title, LocalDateTime releaseDate, String mPAARating, String directorName, String studio, String ratingAndNote)
    {
        DVD dvd = dvdList.get(index);
        dvd.setTitle(title);
        dvd.setReleaseDate(releaseDate);
        dvd.setmPAARating(mPAARating);
        dvd.setDirectorName(directorName);
        dvd.setStudio(studio);
        dvd.setRatingAndNote(ratingAndNote);
    }

    public StringBuilder DisplayList()
    {
        StringBuilder info = new StringBuilder();
        dvdList.forEach(i -> { info.append("" + (dvdList.indexOf(i) + 1) + "# " + i.toString());});
        return info;
    }

    public String DisplayInformation(DVD dvd)
    {
        return dvd.toString();
    }

    public DVD SearchDVD(String title)
    {
        DVD foundDVD = null;
        for(DVD dvd : dvdList)
        {
            if(title.compareTo(dvd.getTitle()) == 0)
            {
                foundDVD = dvd;
                break;
            }
        }
        return foundDVD;
    }


    public void LoadDVD()
    {
        List<String> list = new ArrayList<>();

        try (BufferedReader br = Files.newBufferedReader(Paths.get("dvd.txt"))) {

            list = br.lines().collect(Collectors.toList());
            System.out.println("Data loaded.");

        } catch (IOException e) {
            e.printStackTrace();
        }

        list.forEach(this::DeSerialization);
    }

    public void DeSerialization(String string)
    {
        // remove the first "
        string = string.substring(1);
        int index =  string.indexOf("\"");

        if(index < 0)
            return;

        String title = string.substring(0,index);

        string = string.substring(index);

        if(string.length() < 2)
            return;

        string = string.substring(2);

        index =  string.indexOf(",");

        if(index < 0)
            return;

        String date = string.substring(0,index);
        LocalDate relaseDate;

        try
        {
            relaseDate = LocalDate.parse(date);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return;
        }

        if(string.length() < 1)
            return;

        string = string.substring(1);




    }

    public void SaveDVD()
    {

    }

}
