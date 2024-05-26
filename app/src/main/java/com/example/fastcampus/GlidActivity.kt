package com.example.fastcampus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide

class GlidActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_glid)

        val image = findViewById<ImageView>(R.id.image)

        Glide.with(this).load(R.drawable._0230818_201250_001)
            .fitCenter().into(image)
    }
}