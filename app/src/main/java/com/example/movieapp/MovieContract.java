package com.example.movieapp;

import android.provider.BaseColumns;

public final class MovieContract {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private MovieContract() {}

    /* Inner class that defines the table contents */
    public static class Movie implements BaseColumns {
        public static final String TABLE_NAME = "movies";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_DIRECTOR = "director";
        public static final String COLUMN_NAME_YEAR = "year";
        public static final String COLUMN_NAME_RUNTIME = "runtime";
    }

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + Movie.TABLE_NAME + " (" +
                    Movie._ID + " INTEGER PRIMARY KEY," +
                    Movie.COLUMN_NAME_TITLE + " TEXT," +
                    Movie.COLUMN_NAME_DIRECTOR + " TEXT," +
                    Movie.COLUMN_NAME_YEAR + " TEXT," +
                    Movie.COLUMN_NAME_RUNTIME + " TEXT)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + Movie.TABLE_NAME;


}
