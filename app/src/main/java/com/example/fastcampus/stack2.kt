package com.example.fastcampus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class stack2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stack2)

        (findViewById<TextView>(R.id.one)).setOnClickListener {
            startActivity(Intent(this@stack2, stack1::class.java))
        }
        (findViewById<TextView>(R.id.two)).setOnClickListener {
            val intent = Intent(this@stack2, stack2::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }
        (findViewById<TextView>(R.id.three)).setOnClickListener {
            startActivity(Intent(this@stack2, stack3::class.java))
        }
    }
}