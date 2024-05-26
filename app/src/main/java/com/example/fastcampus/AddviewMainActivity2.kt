package com.example.fastcampus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.widget.LinearLayoutCompat

class AddviewMainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addview_main2)

        var carList = mutableListOf<Car>()
        for (i in 0..10){
            carList.add(Car("" + i+"번째 자동차", ""+i+"번째 엔진"))
        }

        val container = findViewById<LinearLayoutCompat>(R.id.container)

        val inflater=LayoutInflater.from(this@AddviewMainActivity2)
        carList.forEach{
            val carImageView = inflater.inflate(R.layout.car_item, null)
            val carImage = carImageView.findViewById<ImageView>(R.id.carImage)
            val nthCar = carImageView.findViewById<TextView>(R.id.nthCar)
            val nthEngine = carImageView.findViewById<TextView>(R.id.nthEngine)

            carImage.setImageDrawable(resources.getDrawable(R.drawable.youtube_logo, this.theme))
            nthCar.text = it.nthCar
            nthEngine.text = it.nthEngine

            container.addView(carImageView)

        }
    }
}

class Car(val nthCar:String, val nthEngine:String){

}