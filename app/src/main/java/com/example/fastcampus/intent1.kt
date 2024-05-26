package com.example.fastcampus

import android.content.ComponentName
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Telephony.Mms.Intents
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

class intent1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent1)
        //암시적
        val implicit:TextView = findViewById(R.id.implicit)
        implicit.setOnClickListener {
            val intent: Intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:010-1111-1112"))
            startActivity(intent)
        }
        //명시적
//        val explicit:TextView = findViewById(R.id.explicit)
//        explicit.setOnClickListener {
//            val intent:Intent = Intent()
//            val componentName:ComponentName = ComponentName(
//                "com.example.fastcampus",
//                "com.example.fastcampus.intent2"
//            )
//            intent.component = componentName
//            startActivity(intent)
//        }
        (findViewById<TextView>(R.id.explicit)).apply {
            this.setOnClickListener {
                startActivity(
                    Intent(this@intent1, intent2::class.java)
                )
            }
        }

        //명시적 + 데이터
        (findViewById<TextView>(R.id.explicitData)).apply {
            this.setOnClickListener {
                val intent = Intent(this@intent1, intent2::class.java)
                intent.putExtra("extra-data", "data-one")
                startActivity(intent)
            }
        }

        //명시적 + 결과 받기
        // requestCode - 호출된 액티비티에서 보낸 인텐트를 구분하기 위해서. 보통 상수로 표현.
        (findViewById<TextView>(R.id.explicitResult)).apply {
            this.setOnClickListener {
                val intent = Intent(this@intent1, intent2::class.java)
                startActivityForResult(intent,1) //deprecated 지원 안 함.

            }
        }

        //명시적 + 결과 받기, 액티비티리절트 api 사용
        val startActivityLauncher: ActivityResultLauncher<Intent> =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
                //onActivityResult 함수 내용에 해당하는 부분
                when(it.resultCode){
                    RESULT_OK->{
                        Log.d("databb", it.data?.extras?.getInt("result").toString())
                    }
                }
        }
        (findViewById<TextView>(R.id.explicitResult1)).apply {
            this.setOnClickListener {
                val intent = Intent(this@intent1, intent2::class.java)
                startActivityLauncher.launch(intent)
            }
        }

        //명시적 + 이미지 (URI)전달
        (findViewById<TextView>(R.id.explicitAction)).apply {
            this.setOnClickListener {
                val intent = Intent(this@intent1, intent2::class.java).apply {
                    val imageUri = Uri.parse(
                        "android.resource://" + packageName + "/drawable/"+"youtube_logo")
                    this.action = Intent.ACTION_SEND
                    this.putExtra(Intent.EXTRA_STREAM, imageUri)
                    this.setType("image/*")
                }
                startActivity(intent)
            }
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        when(requestCode){
            1 -> {
                when (resultCode){
                    RESULT_OK -> {
                        //데이터 받음.
                        val data:Int? = data?.extras?.getInt("result")
                        Log.d("dataa", data.toString())
//                        Toast.makeText(this, data!!,Toast.LENGTH_SHORT)
                    }
                }
            }
            2 -> {

            }
        }
        super.onActivityResult(requestCode, resultCode, data)
    }
}