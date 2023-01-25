package com.example.sinawang

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class QuizGameActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_game)

//        Button btn_start = findViewById(R.id.btn_start);

        val btn_start: Button = findViewById(R.id.btn_start)
        val et_name: TextView = findViewById(R.id.et_name)


        btn_start.setOnClickListener {


            if(et_name.text.toString().isEmpty()){
                Toast.makeText(this, "Isikan Nama anda ", Toast.LENGTH_LONG).show()
            }else{
                val intent = Intent(this, QuizGameQuestionActivity::class.java)
                intent.putExtra(Constants.NAMA_USER, et_name.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }
}