package com.example.movieapp;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Movie.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase INSTANCE;
    private static final String DB_NAME = "movies.db";
    public static AppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, DB_NAME)
                            .allowMainThreadQueries() // SHOULD NOT BE USED IN PRODUCTION !!!
                            .addCallback(new RoomDatabase.Callback() {
                                @Override
                                public void onCreate(@NonNull SupportSQLiteDatabase db) {
                                    super.onCreate(db);
                                    Log.d("AppDatabase", "populating with data...");
                                    new PopulateDbAsync(INSTANCE).execute();
                                }
                            })
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    public void clearDb() {
        if (INSTANCE != null) {
            new PopulateDbAsync(INSTANCE).execute();
        }
    }

    public abstract MovieDao movieDao();

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {
        private final MovieDao movieDao;
        public PopulateDbAsync(AppDatabase instance) {
            movieDao = instance.movieDao();
        }
        @Override
        protected Void doInBackground(Void... voids) {
            movieDao.deleteAll();
            Movie movie1 = new Movie(1,"Podły, okrutny, zły", "Joe Berlinger", "2019", "108 min");
            Movie movie2 = new Movie(2,"Piraci z Karaibów: Skrzynia umarlaka", "Gore Verbinski", "2006", "151 min");
            Movie movie3 = new Movie(3,"Depresja i kumple", "Arnaud Lemort", "2012", "95 min");
            Movie movie4 = new Movie(4,"Droga przez piekło", "Oliver Stone", "1997", "125 min");
            movieDao.insert(movie1, movie2, movie3, movie4);
            return null;
        }
    }
}
