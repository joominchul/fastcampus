package com.example.fastcampus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class stack3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stack3)

        (findViewById<TextView>(R.id.one)).setOnClickListener {
            startActivity(Intent(this@stack3, stack1::class.java))
        }
        (findViewById<TextView>(R.id.two)).setOnClickListener {
            startActivity(Intent(this@stack3, stack2::class.java))
        }
        (findViewById<TextView>(R.id.three)).setOnClickListener {
            startActivity(Intent(this@stack3, stack3::class.java))
        }
    }
}