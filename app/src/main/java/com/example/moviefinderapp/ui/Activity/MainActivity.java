package com.example.moviefinderapp.ui.Activity;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import com.example.moviefinderapp.R;
import com.example.moviefinderapp.databinding.ActivityMainBinding;
import com.example.moviefinderapp.Network.MovieDto;
import com.example.moviefinderapp.Network.MoviesResponseDto;
import com.example.moviefinderapp.Network.OmdbApi;
import com.example.moviefinderapp.Network.RetrofitClient;
import com.example.moviefinderapp.ui.Adapter.ImageAdapter;
import com.example.moviefinderapp.ui.Adapter.MoviesAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

// En tu actividad o fragmento principal
public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ImageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<String> imageUrls = generateImageUrls(); // Aquí generas una lista de URLs de imágenes aleatorias
        adapter = new ImageAdapter(imageUrls);
        recyclerView.setAdapter(adapter);
    }

    // Método para generar URLs de imágenes aleatorias
    private List<String> generateImageUrls() {
        List<String> urls = new ArrayList<>();
        for (int i = 0; i < 10; i++) { // Generar 10 URLs para la lista
            urls.add("https://random.imagecdn.app/500/150");
        }
        return urls;
    }
}
