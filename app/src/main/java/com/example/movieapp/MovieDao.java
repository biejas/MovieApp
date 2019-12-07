package com.example.movieapp;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MovieDao {
    @Query("SELECT * FROM movie")
    List<Movie> getAll();

    @Query("SELECT * FROM movie WHERE uid IN (:userIds)")
    List<Movie> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM movie WHERE title LIKE :title")
    Movie findByName(String title);

    @Insert
    void insertAll(Movie... movies);

    @Delete
    void delete(Movie movie);
}
