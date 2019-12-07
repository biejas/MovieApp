package com.example.movieapp;

import android.content.Context;

import androidx.room.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieContent {

    public static final List<MovieItem> ITEMS = new ArrayList<MovieItem>();
    public static final Map<String, MovieItem> ITEM_MAP =  new HashMap<>();

    private static Context context;

    private static AppDatabase db;

    static {
//        addItem(new MovieItem(1, "Film1", "Director1", "2001", "101 min"));
//        addItem(new MovieItem(2, "Film2", "Director2", "2002", "102 min"));
//        addItem(new MovieItem(3, "Film3", "Director3", "2003", "103 min"));
//        addItem(new MovieItem(4, "Film4", "Director4", "2004", "104 min"));
//        addItem(new MovieItem(5, "Film5", "Director5", "2005", "105 min"));
    }

    public static void setContext(Context c) {
        context = c;
    }

    public static void addItem(MovieItem item){
        ITEMS.add(item);
        ITEM_MAP.put(item.uid, item);
    }

    public static class MovieItem {
        public final String uid;
        public final String title;
        public final String director;
        public final String year;
        public final String runtime;


        public MovieItem(int uid, String title, String director, String year, String runtime) {
            this.uid = Integer.toString(uid);
            this.title = title;
            this.director = director;
            this.year = year;
            this.runtime = runtime;
        }

        @Override
        public String toString() {
            return title + " " + director + " " + year + " " + runtime;
        }
    }
}
