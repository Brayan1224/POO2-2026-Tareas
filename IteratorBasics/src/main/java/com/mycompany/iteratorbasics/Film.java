package com.mycompany.iteratorbasics;

public class Film {
    private String title;
    private int year;

    public Film(String title, int year) {
        this.title = title;
        this.year = year;
    }

    @Override
    public String toString() {
        return title + " (" + year + ")";
    }
}
