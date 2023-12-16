package com.example.moviefinderapp.ui.Activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.moviefinderapp.FirstFragment;
import com.example.moviefinderapp.R;
import com.example.moviefinderapp.SecondFragment;
import com.example.moviefinderapp.ThirdFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
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

    FirstFragment firstFragment = new FirstFragment();
    SecondFragment secondFragment = new SecondFragment();
    ThirdFragment thirdFragment = new ThirdFragment();
    private RecyclerView recyclerView;
    private ImageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = findViewById(R.id.bottom_navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<String> imageUrls = generateImageUrls(); // Aquí generas una lista de URLs de imágenes aleatorias
        adapter = new ImageAdapter(imageUrls);
        recyclerView.setAdapter(adapter);
    }

    private final BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            int itemId = item.getItemId();

            if (itemId == R.id.firstFragment) {
                loadFragment(firstFragment);
                return true;
            } else if (itemId == R.id.secondFragment) {
                loadFragment(secondFragment);
                return true;
            } else if (itemId == R.id.thirdFragment) {
                loadFragment(thirdFragment);
                return true;
            }

            return false;
        }

    };

    public void loadFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.commit();
    }

    private List<String> generateImageUrls() {
        List<String> urls = new ArrayList<>();
        for (int i = 0; i < 10; i++) { // Generar 10 URLs para la lista
            urls.add("https://random.imagecdn.app/500/150");
        }
        return urls;
    }





}
