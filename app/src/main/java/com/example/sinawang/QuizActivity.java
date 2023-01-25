package com.example.sinawang;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class QuizActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        //Initialize the views
        TextView et_name = (TextView)findViewById(R.id.et_name);
        Button btn_start = (Button)findViewById(R.id.btn_start);

        btn_start.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                if(et_name.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(), "Masukan Nama ",Toast.LENGTH_LONG).show();
                }else {
                    Intent QuizGame = new Intent(QuizActivity.this, QuizGameActivity.class);
                    startActivity(QuizGame);
                    finish();
                }
            }

        });

    }

}