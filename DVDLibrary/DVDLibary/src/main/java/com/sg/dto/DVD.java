package com.sg.dto;

import java.time.LocalDate;

public class DVD
{
    private String title;
    private LocalDate releaseDate;
    private String mPAARating;
    private String directorName;
    private String studio;
    private String ratingAndNote;

    public DVD(String title, LocalDate releaseDate, String mPAARating, String directorName, String studio, String ratingAndNote) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.mPAARating = mPAARating;
        this.directorName = directorName;
        this.studio = studio;
        this.ratingAndNote = ratingAndNote;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getmPAARating() {
        return mPAARating;
    }

    public void setmPAARating(String mPAARating) {
        this.mPAARating = mPAARating;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getRatingAndNote() {
        return ratingAndNote;
    }

    public void setRatingAndNote(String ratingAndNote) {
        this.ratingAndNote = ratingAndNote;
    }

    @Override
    public String toString() {
        return "Title:" + title + " Release Date:" + releaseDate + " MPAARating:" + mPAARating + " Director's Name:" + directorName + " Studio:" + studio + " Rating & Note:" + ratingAndNote;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DVD dvd = (DVD) o;

        return title.equals(dvd.title);
    }

    @Override
    public int hashCode() {
        return title.hashCode();
    }
}
