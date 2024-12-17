package com.example.moviest.network;

import com.example.moviest.model.Movie;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MovieApi {

    @GET("movies")
    Call<List<Movie>> getMovies();
}
