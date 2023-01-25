package com.example.sinawang

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat

class QuizGameQuestionActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition : Int = 1
    private var mQuestionList: ArrayList<Question>? = null
    private var mSelectedOptionPosition : Int = 0
    private var mCorrectAnswers : Int = 0
    private var mUserName : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_game_question)

        //deklarasi id
//        val ProsesBar: ProgressBar = findViewById(R.id.ProsesBar)
//        val tv_Proses: TextView = findViewById(R.id.tv_Proses)
//        val Jawab_wayang : TextView = findViewById(R.id.Jawab_wayang)
//        val image_question : ImageView = findViewById(R.id.image_question)
        val tv_option_one : TextView = findViewById(R.id.tv_option_one)
        val tv_option_two : TextView = findViewById(R.id.tv_option_two)
        val tv_option_three : TextView = findViewById(R.id.tv_option_three)
        val btn_save : Button = findViewById(R.id.btn_save)

        mUserName = intent.getStringExtra(Constants.NAMA_USER)

        //CEK
//        val questionsList = Constants.getQustions()
//        Log.i("Questions Size", "${questionsList.size}")
        mQuestionList = Constants.getQustions()

        setQuestion()

        tv_option_one.setOnClickListener(this)
        tv_option_two.setOnClickListener(this)
        tv_option_three.setOnClickListener(this)
        btn_save.setOnClickListener(this)
    }
    private fun setQuestion(){


        val ProsesBar: ProgressBar = findViewById(R.id.ProsesBar)
        val tv_Proses: TextView = findViewById(R.id.tv_Proses)
        val Jawab_wayang : TextView = findViewById(R.id.Jawab_wayang)
        val image_question : ImageView = findViewById(R.id.image_question)
        val tv_option_one : TextView = findViewById(R.id.tv_option_one)
        val tv_option_two : TextView = findViewById(R.id.tv_option_two)
        val tv_option_three : TextView = findViewById(R.id.tv_option_three)
        val btn_save : Button = findViewById(R.id.btn_save)

        //id dari Constants

        //cek posisi pertanyaan
        //mCurrentPosition = 1
        val question = mQuestionList !![mCurrentPosition-1]

        defaultOptionsView()

        //cek posisi pertanyaan
        if(mCurrentPosition == mQuestionList!!.size){
            btn_save.text = "Selesai"
        }else{
            btn_save.text = "Simpan"
        }

        ProsesBar.progress = mCurrentPosition
        tv_Proses.text = "$mCurrentPosition" + "/" + ProsesBar.max

        Jawab_wayang .text = question!!.question
        image_question.setImageResource(question.image)

        tv_option_one.text = question.optionOne
        tv_option_two.text = question.optionTwo
        tv_option_three.text = question.optionThree
    }
    private fun defaultOptionsView(){
        val tv_option_one : TextView = findViewById(R.id.tv_option_one)
        val tv_option_two : TextView = findViewById(R.id.tv_option_two)
        val tv_option_three : TextView = findViewById(R.id.tv_option_three)

        val options = ArrayList<TextView>()
        options.add(0, tv_option_one)
        options.add(1, tv_option_two)
        options.add(2, tv_option_three)

        for( option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
              this,
                    R.drawable.default_border
            )
        }

    }

    override fun onClick(v: View?) {

        val tv_option_one : TextView = findViewById(R.id.tv_option_one)
        val tv_option_two : TextView = findViewById(R.id.tv_option_two)
        val tv_option_three : TextView = findViewById(R.id.tv_option_three)
        val btn_save : Button = findViewById(R.id.btn_save)

        when(v?.id){
            R.id.tv_option_one ->{
                selectedOptionView(tv_option_one, 1)
            }
            R.id.tv_option_two ->{
                selectedOptionView(tv_option_two, 2)
            }
            R.id.tv_option_three ->{
                selectedOptionView(tv_option_three, 3)
            }

            //koreksi jawaban benar atau salah menggunakan warna
            R.id.btn_save ->{
                if(mSelectedOptionPosition == 0){
                    mCurrentPosition ++

                    when{
                        mCurrentPosition <= mQuestionList!!.size ->{
                            setQuestion() //posisi pertanyaan
                        }else ->{
                        Toast.makeText(this, " Kamu telah menyelesaikan Quiz ", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, QuizResultGame::class.java)
                        intent.putExtra(Constants.NAMA_USER, mUserName)
                        intent.putExtra(Constants.JAWABAN_BENAR, mCorrectAnswers)
                        intent.putExtra(Constants.TOTAL_PERTANYAAN, mQuestionList!!.size)
                        startActivity(intent)
                        }
                    }
                }else{
                    val question = mQuestionList?.get(mCurrentPosition -1)
                    if(question!!.correctAnswer != mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition, R.drawable.wrong_border)
                    }else{
                        mCorrectAnswers++ //cek jawaban benar
                    }
                    answerView(question.correctAnswer, R.drawable.correct_border)

                    if(mCurrentPosition == mQuestionList!!.size){
                        btn_save.text = "Selesai"
                    }else{
                        btn_save.text = "Pertanya selanjutnya"
                    }
                    mSelectedOptionPosition = 0
                }
            }
        }
    }

    private fun answerView(answer: Int, drawableView: Int){
        val tv_option_one : TextView = findViewById(R.id.tv_option_one)
        val tv_option_two : TextView = findViewById(R.id.tv_option_two)
        val tv_option_three : TextView = findViewById(R.id.tv_option_three)
        when(answer){
            1->{
                tv_option_one.background = ContextCompat.getDrawable(this, drawableView )
            }
            2->{
                tv_option_two.background = ContextCompat.getDrawable(this, drawableView )
            }
            3->{
                tv_option_three.background = ContextCompat.getDrawable(this, drawableView )
            }
        }
    }

    private fun selectedOptionView(tv: TextView, selecedOptionNum: Int){

        defaultOptionsView()
        mSelectedOptionPosition = selecedOptionNum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
                this,
                R.drawable.selected_border
        )
    }
}