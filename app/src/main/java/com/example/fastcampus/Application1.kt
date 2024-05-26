package com.example.fastcampus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class Application1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_application1)

        findViewById<TextView>(R.id.changeActivity).setOnClickListener {
            startActivity(
                Intent(this, Application2::class.java)
            )
        }

        findViewById<TextView>(R.id.testMethod).setOnClickListener {
            (applicationContext as MasterApplication).methodFromApplication()
            val userid = (applicationContext as MasterApplication).userId
            Log.d("threadss", "user id : "+userid)
        }
    }
}