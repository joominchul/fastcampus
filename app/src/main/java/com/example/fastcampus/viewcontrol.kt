package com.example.fastcampus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView

class viewcontrol : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewcontrol)
        //뷰를 액티비티로 가져오는 방법
        val textViewOne:TextView = findViewById(R.id.textView)
        val buttonOne:Button = findViewById(R.id.vcbutton)

        Log.d("textt", textViewOne.text.toString())

        //리스너 사용법
        buttonOne.setOnClickListener {
            Log.d("textt", "click")
        }

        //풀버전
        val click = object : View.OnClickListener{
            override fun onClick(v: View?) {
                Log.d("textt", "click1")
            }
        }
        textViewOne.setOnClickListener(click)

        //익명함수 버전
        textViewOne.setOnClickListener(object :View.OnClickListener{
            override fun onClick(v: View?) {
                Log.d("textt", "click2")
            }
        })
    }
}