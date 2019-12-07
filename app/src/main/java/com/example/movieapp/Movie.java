package com.example.movieapp;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Movie {
    @PrimaryKey
    public int uid;

    @ColumnInfo(name = "title")
    public String title;

    @ColumnInfo(name = "director")
    public String director;

    @ColumnInfo(name = "year")
    public String year;

    @ColumnInfo(name = "runtime")
    public String runtime;

    public Movie(int uid, String title, String director, String year, String runtime) {
        this.uid = uid;
        this.title = title;
        this.director = director;
        this.year = year;
        this.runtime = runtime;
    }
}
