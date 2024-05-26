package com.example.fastcampus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import java.lang.Thread

class Thread : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thread)

        val currentThread = Thread.currentThread()
        Log.d("threadss", ""+currentThread)

//        Thread{
//            for (a in 1..1000){
//                Log.d("threadss", "a "+a)
//            }
//        }.start()
//
//        Thread{
//            for (a in 1..1000){
//                Log.d("threadss", "b "+a)
//            }
//        }.start()
        Thread{
            val currentThread = Thread.currentThread()
            Log.d("threadss", ""+currentThread)
            runOnUiThread {
                findViewById<TextView>(R.id.test).text = "changed"
            }
        }.start()
    }
}