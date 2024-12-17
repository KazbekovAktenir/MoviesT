package com.example.moviest;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviest.adapter.MovieAdapter;
import com.example.moviest.model.Movie;
import com.example.moviest.network.ApiClient;
import com.example.moviest.network.MovieApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MovieAdapter movieAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //инициализация RecyclerView
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //инициализация Retrofit
        MovieApi movieApi = ApiClient.getRetrofitInstance().create(MovieApi.class);

        //запрос на получение списка фильмов
        Call<List<Movie>> call = movieApi.getMovies();
        call.enqueue(new Callback<List<Movie>>() {
            @Override
            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                if (response.isSuccessful()) {
                    List<Movie> movies = response.body();
                    //обновление UI с полученными данными
                    movieAdapter = new MovieAdapter(movies);
                    recyclerView.setAdapter(movieAdapter);
                    Toast.makeText(MainActivity.this, "Fetched " + movies.size() + " movies", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Error: " + response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Movie>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Failed to load movies", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
