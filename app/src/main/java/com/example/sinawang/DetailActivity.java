package com.example.sinawang;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //Initialize the views
        TextView wayangTitle = (TextView)findViewById(R.id.titleDetail);
        ImageView wayangImage = (ImageView)findViewById(R.id.wImageDetail);
        TextView wayangNlain = (TextView)findViewById(R.id.nama_l_t);
        TextView wayangDescription= (TextView)findViewById(R.id.watak_t);


        Drawable drawable = ContextCompat.getDrawable
                (this,getIntent().getIntExtra(Wayang.IMAGE_KEY, 0));

        //Create a placeholder gray scrim while the image loads
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.GRAY);


        //Make it the same size as the image
        if(drawable!=null) {
            gradientDrawable.setSize(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }

//        //Set the text from the Intent extra
        wayangTitle.setText(getIntent().getStringExtra(Wayang.TITLE_KEY));
        wayangNlain.setText(getIntent().getStringExtra(Wayang.OTHER_KEY));
        wayangDescription.setText(getIntent().getStringExtra(Wayang.DESCRIPTION_KEY));
        //Load the image using the glide library and the Intent extra
        Glide.with(this).load(getIntent().getIntExtra(Wayang.IMAGE_KEY,0))
                .placeholder(gradientDrawable).into(wayangImage);


    }
}