package com.example.fastcampus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

open class Fragment : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

        val fragmentManager = supportFragmentManager
        val fragment1 = Fragment1()
        val fragment2 = Fragment1()

        (findViewById<TextView>(R.id.attach)).setOnClickListener {
            val transaction = fragmentManager.beginTransaction() //시작
            //프래그먼트에 데이터를 전달
            val bundle = Bundle()
            bundle.putString("key", "hello")
            fragment1.arguments = bundle

            transaction.replace(R.id.root, fragment1, "fragment_tag")
            transaction.commit() //끝

        }

        (findViewById<TextView>(R.id.detach)).setOnClickListener {
            val transaction = fragmentManager.beginTransaction() //시작
            transaction.remove(fragment1)
            transaction.commit() //끝
        }

        // 같은 프래그먼트를 매개변수로 받으면 attach로 프래그먼트 뷰를 생성했다가 detach1로 없앨 수 있음.
        // 하지만 attach와 attach1을 둘 다 사용하면 튕김.
        // 다른 프래그먼트로 설정하면 각각 독립적으로 작용함.
//        (findViewById<TextView>(R.id.attach1)).setOnClickListener {
//            val transaction = fragmentManager.beginTransaction() //시작
//            transaction.replace(R.id.root1, fragment2)
//            transaction.commit() //끝
//
//        }
//
//        (findViewById<TextView>(R.id.detach1)).setOnClickListener {
//            val transaction = fragmentManager.beginTransaction() //시작
//            transaction.remove(fragment2)
//            transaction.commit() //끝
//        }

        (findViewById<TextView>(R.id.access)).setOnClickListener {
            //xml에 있는 프래그먼트를 찾는 방법
//            val fragmentFirst = supportFragmentManager.findFragmentById(R.id.fragment_first) as Fragment1
//            fragmentFirst.printTestLog1()

            //xml에 없는 프래그먼트를 찾는 방법(코드)
            //프래그먼트 뷰를 붙이고 나서 실행해야 됨.
            val fragmentSecond = supportFragmentManager.findFragmentByTag("fragment_tag") as Fragment1
            fragmentSecond.printTestLog1()
        }
    }

    fun printTestLog(){
        Log.d("tesst", "print test log")
    }
}