package com.example.moviest.model;

public class Movie {

    private String title;
    private String genre;
    private int year;
    private double rating;
    private String posterUrl;
    private String streamUrl;

    // Конструктор
    public Movie(String title, String genre, int year, double rating, String posterUrl, String streamUrl) {
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.rating = rating;
        this.posterUrl = posterUrl;
        this.streamUrl = streamUrl;
    }

    // Геттеры
    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public int getYear() {
        return year;
    }

    public double getRating() {
        return rating;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public String getStreamUrl() {
        return streamUrl;
    }
}
