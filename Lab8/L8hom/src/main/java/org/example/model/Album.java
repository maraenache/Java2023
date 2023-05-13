package org.example.model;

import java.util.List;

public class Album extends AbstractEntity {

    private int releaseYear;
    private String title;
    private String artist;
    private List<String> genres;

    public Album(int releaseYear, String title, String artist, List<String> genres) {
        this.releaseYear = releaseYear;
        this.title = title;
        this.artist = artist;
        this.genres = genres;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    @Override
    public String toString() {
        return " releaseYear=" + releaseYear +
                ", title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", genres=" + genres +
                '}';
    }
}

