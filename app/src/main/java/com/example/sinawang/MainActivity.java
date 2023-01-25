package com.example.sinawang;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();


    }

    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("Apakah anda ingin keluar aplikasi?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        MainActivity.this.finish();
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }

    public void tentangwayang(View view) {
        Intent tentangwayang = new Intent(MainActivity.this, TentangWayangActivity.class);
        startActivity(tentangwayang);
    }
    public void tokohwayang(View view) {
        Intent tokohwayang = new Intent(MainActivity.this, TokohWActivity.class);
        startActivity(tokohwayang);
    }

    public void quizwayang(View view) {
        Intent quizwayang = new Intent(MainActivity.this, QuizGameActivity.class);
        startActivity(quizwayang);
    }

    public void tentangaplikasi(View view) {
        Intent tentangaplikasi = new Intent(MainActivity.this, TentangAActivity.class);
        startActivity(tentangaplikasi);
    }
}