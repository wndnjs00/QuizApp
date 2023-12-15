package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 변수 초기화
        val btnStart : Button = findViewById(R.id.btn_start)
        val etName : EditText = findViewById(R.id.et_name)


        //btn_start버튼 눌렀을때
        btnStart.setOnClickListener {

            //텍스트가 비어있는지 아닌지 확인
            //텍스트가 비어있다면 토스트메세지를 출력
            if(etName.text.isEmpty()){
                Toast.makeText(this,"이름을 입력해주세요", Toast.LENGTH_SHORT).show()
            }else{
                //텍스트가 비어있지 않다면 QuizQuestionActivity로 이동
                val intent = Intent(this, QuizQuestionActivity::class.java)
                startActivity(intent)
                finish()
            }
        }

    }
}