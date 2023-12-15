package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tvName : TextView = findViewById(R.id.tv_name)
        val tvScore : TextView = findViewById(R.id.tv_score)
        val btnFinish : Button = findViewById(R.id.btn_finish)

        // tv_name에 텍스트표시
        tvName.text = intent.getStringExtra(Constants.USER_NAME)


        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS,0) //전체질문의 개수
        val correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS,0) //맞힌질문의 개수


        // tv_score에 텍스트표시
        tvScore.text = "점수는 $totalQuestions 점만점중에 $correctAnswers 점입니다"


        // finish버튼 누르면 MainActivity로 넘어가도록
        btnFinish.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}