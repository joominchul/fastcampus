package com.example.fastcampus

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.widget.ImageView
import android.widget.TextView

class intent2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent2)
        //intent2 액티비티를 호출한 액티비티의 인텐트.
        val intent = intent
        val data:String? = intent.extras?.getString("extra-data")
        if (data != null) Log.d("extra", data)

        (findViewById<TextView>(R.id.finish)).apply {
            this.setOnClickListener {
                val intent = Intent()
                intent.putExtra("result", 100)
                setResult(RESULT_OK, intent)
                finish()//액티비티를 종료해서 원래 액티비티로 돌아감.
            }
        }
        //이미지 받기
        val imageView = findViewById<ImageView>(R.id.image)
        val uri = Uri.parse(
            intent.getParcelableExtra<Parcelable>(Intent.EXTRA_STREAM).toString()
        )
        imageView.setImageURI(uri)
    }


}