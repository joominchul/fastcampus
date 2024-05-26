package com.example.fastcampus

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class ListViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        var carList = mutableListOf<Car>()
        for (i in 0..100){
            carList.add(Car(""+i+" car", ""+i+" engine"))
        }

        val adapter = ListViewAdapter(carList, LayoutInflater.from(this), this)
        //어댑터 장착 방법
        val listView = findViewById<ListView>(R.id.listView)
        listView.adapter = adapter

        //리스너 장착 방법
        listView.setOnItemClickListener { parent, view, position, id ->
            var car = adapter.carList.get(position)
            val nthCar = car.nthCar
            val nthEngine = car.nthEngine

            Toast.makeText(this, nthCar + " " + nthEngine, Toast.LENGTH_SHORT).show()
        }
        //데이터 갱신 방법
        findViewById<TextView>(R.id.addCar).setOnClickListener {
            adapter.carList.add(
                Car("new car", "new Engine")
            )
            adapter.notifyDataSetChanged()
        }
    }
}

class ListViewAdapter(
    val carList: MutableList<Car>,
    val layoutInflater: LayoutInflater,
    val context:Context
) : BaseAdapter(){
    override fun getCount(): Int {
        //전체 데이터 개수
        return carList.size
    }

    override fun getItem(position: Int): Any {
        //전체 데이터 중에서 해당 번째 데이터 리턴
        return carList.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view:View
        val holder:com.example.fastcampus.ViewHolder

        // 해당 번째 뷰를 리턴
        // convertView : 재활용 뷰

        if (convertView == null){
            //재활용 불가능
            view = layoutInflater.inflate(R.layout.car_item, null)
            holder = ViewHolder()
            holder.carImage = view.findViewById(R.id.carImage)
            holder.nthCar = view.findViewById<TextView>(R.id.nthCar)
            holder.nthEngine = view.findViewById<TextView>(R.id.nthEngine)

            view.tag = holder

        }else{
            //재활용 가능
            holder = convertView.tag as com.example.fastcampus.ViewHolder
            view = convertView
        }
        val car = carList.get(position)
        holder.carImage?.setImageDrawable(context.resources.getDrawable(R.drawable.youtube_logo, context.theme))
        holder.nthCar?.text = car.nthCar
        holder.nthEngine?.text = car.nthEngine

//        val view = layoutInflater.inflate(R.layout.car_item, null)
//        val carImage = view.findViewById<ImageView>(R.id.carImage)
//        val nthCar = view.findViewById<TextView>(R.id.nthCar)
//        val nthEngine = view.findViewById<TextView>(R.id.nthEngine)
//
//        val car = carList.get(position)
//        carImage.setImageDrawable(context.resources.getDrawable(R.drawable.youtube_logo, context.theme))
//        nthCar.text = car.nthCar
//        nthEngine.text = car.nthEngine
        return view
    }
}

class ViewHolder{
    var carImage:ImageView? = null
    var nthCar:TextView? = null
    var nthEngine:TextView? = null
}