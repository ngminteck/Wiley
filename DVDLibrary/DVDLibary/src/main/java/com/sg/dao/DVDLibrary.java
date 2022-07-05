package com.sg.dao;

import com.sg.dto.DVD;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DVDLibrary
{
    List<DVD> dvdList = new ArrayList<>();

    public DVD FindDVD(int index)
    {
        return  dvdList.get(index);
    }

    public int getDVDListSize()
    {
        return dvdList.size();
    }

    public int getDVDIndex(DVD dvd)
    {
        return dvdList.indexOf(dvd);
    }

    public void AddDVD(String title, LocalDate releaseDate, String mPAARating, String directorName, String studio, String ratingAndNote)
    {
        dvdList.add(new DVD(title,releaseDate,mPAARating,directorName,studio,ratingAndNote));
    }

    public void RemoveDVD(int index)
    {
        dvdList.remove(index);
    }

    public void EditDVD (int index,String title, LocalDate releaseDate, String mPAARating, String directorName, String studio, String ratingAndNote)
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
        dvdList.forEach(i -> info.append(dvdList.indexOf(i) + 1).append("# ").append(i.toString()).append("\n"));
        return info;
    }

    public String DisplayInformation(int index)
    {
        return dvdList.get(index).toString();
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
        List<String> list;

        try (BufferedReader br = Files.newBufferedReader(Paths.get("dvd.txt")))
        {

            list = br.lines().collect(Collectors.toList());
            System.out.println("Data loaded.");

        }
        catch (IOException e)
        {
            System.out.println("Data load failed.");
            e.printStackTrace();
            return;
        }

        list.forEach(this::DeSerialization);
    }

    public void DeSerialization(String string)
    {
        if(string.length() <= 1)
            return;

        string = string.substring(1);
        int index =  string.indexOf("\"");
        if(index < 0)
            return;
        String title = string.substring(0,index);

        string = string.substring(index);
        if(string.length() <= 2)
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
        string = string.substring(index);
        if(string.length()<= 2)
            return;
        string = string.substring(2);
        index =  string.indexOf("\"");
        if(index < 0)
            return;
        String mPAARating = string.substring(0,index);
        string = string.substring(index);

        if(string.length() <= 3)
            return;
        string = string.substring(3);

        index =  string.indexOf("\"");
        if(index < 0)
            return;
        String directorName = string.substring(0,index);

        string = string.substring(index);
        if(string.length() <=3 )
            return;
        string = string.substring(3);
        index =  string.indexOf("\"");
        if(index < 0)
            return;
        String studio = string.substring(0,index);

        string = string.substring(index);
        if(string.length() <= 3)
            return;
        string = string.substring(3);
        index =  string.indexOf("\"");
        if(index < 0)
            return;
        String ratingAndComment = string.substring(0,index);

        AddDVD(title,relaseDate,mPAARating,directorName,studio,ratingAndComment);

    }

    public void SaveDVD()
    {
        PrintWriter out;

        try
        {
            out = new PrintWriter(new FileWriter("dvd.txt"));
        }
        catch (IOException e)
        {
            System.out.println("Data save failed.");
            e.printStackTrace();
            return;
        }

        PrintWriter finalOut = out;
        dvdList.forEach(i -> {
            StringBuilder stringData = Serialization(i);
            finalOut.println(stringData);
            finalOut.flush();
        } );

        System.out.println("Data saved.");

        out.close();
    }

    private StringBuilder Serialization (DVD data)
    {
        StringBuilder write = new StringBuilder("\"" + data.getTitle() +"\"");
        write.append(",");
        write.append(data.getReleaseDate());
        write.append(",");
        write.append("\"").append(data.getmPAARating()).append("\"");
        write.append(",");
        write.append("\"").append(data.getDirectorName()).append("\"");
        write.append(",");
        write.append("\"").append(data.getStudio()).append("\"");
        write.append(",");
        write.append("\"").append(data.getRatingAndNote()).append("\"");
        return write;
    }

}
