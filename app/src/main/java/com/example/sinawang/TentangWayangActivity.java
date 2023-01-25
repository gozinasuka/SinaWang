package com.example.sinawang;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class TentangWayangActivity extends AppCompatActivity {

    private  int[] mImage = new int[]{
            R.drawable.ramayana,R.drawable.pandawa5,R.drawable.mahabarata,R.drawable.punokawan3
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tentang_wayang);

        CarouselView carouselView = findViewById(R.id.carousel);
        carouselView.setPageCount(mImage.length);
        carouselView.setImageListener(new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                imageView.setImageResource((mImage[position]));
            }
        });

    }

    public void ramayana(View view) {
        Intent ramayana = new Intent(TentangWayangActivity.this, RamayanaActivity.class);
        startActivity(ramayana);
    }

    public void mahabarata(View view) {
        Intent mahabarata = new Intent(TentangWayangActivity.this, MahabarataActivity.class);
        startActivity(mahabarata);
    }
}