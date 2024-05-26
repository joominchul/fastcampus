package com.example.fastcampus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat

class ResourceMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resource_main)

        findViewById<TextView>(R.id.text).setOnClickListener {
            (it as TextView).text = resources.getText(R.string.app_name)
//            it.background = resources.getDrawable(R.drawable.arrows)

            //셋 다 동일. minSDK 때문에 안 되는 것이 있을 수 있음.
            it.background = resources.getDrawable(R.drawable.back, this.theme)
            it.background = ContextCompat.getDrawable(this, R.drawable.arrows)
            it.background = ResourcesCompat.getDrawable(resources, R.drawable.arrows, null)


        }
    }
}