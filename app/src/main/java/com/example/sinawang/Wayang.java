package com.example.sinawang;

import android.content.Context;
import android.content.Intent;

import androidx.annotation.DrawableRes;

public class Wayang {
    private final String title;
    private final String info;
    private final String description;
    private final int imageResource;

    static final String TITLE_KEY = "Title";
    static final String IMAGE_KEY = "Image Resource";
    static final String OTHER_KEY = "Other";
    static final String DESCRIPTION_KEY = "Description";

    Wayang( String title, String info, String description, int imageResource) {
        this.title = title;
        this.info = info;
        this.description = description;
        this.imageResource = imageResource;
    }

    String getTitle() {
        return title;
    }

    String getInfo() {
        return info;
    }

    String getDescription() {
        return description;
    }

    int getImageResource() {
        return imageResource;
    }



    static Intent starter(Context context, String title, String other, String description, @DrawableRes int imageResId) {



        Intent detailIntent = new Intent(context, DetailActivity.class);
        detailIntent.putExtra(TITLE_KEY, title);
        detailIntent.putExtra(OTHER_KEY, other);
        detailIntent.putExtra(DESCRIPTION_KEY, description);
        detailIntent.putExtra(IMAGE_KEY, imageResId);
        return detailIntent;
    }
}
