package com.example.sinawang

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class QuizResultGame : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar!!.hide()

        setContentView(R.layout.activity_quiz_result_game)


        val tv_name : TextView = findViewById(R.id.tv_name)
        val tv_score : TextView = findViewById(R.id.tv_score)
        val btn_selesai : Button = findViewById(R.id.btn_selesai)

        val namauser = intent.getStringExtra(Constants.NAMA_USER)
        tv_name.text = namauser
        val jawabanbenar = intent.getIntExtra(Constants.JAWABAN_BENAR, 0)
        val totalpertanyaan = intent.getIntExtra(Constants.TOTAL_PERTANYAAN, 0)

        tv_score.text = "Skor Quiz Anda adalah : $jawabanbenar / $totalpertanyaan"

        btn_selesai.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}