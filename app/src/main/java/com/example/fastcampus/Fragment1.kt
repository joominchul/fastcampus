package com.example.fastcampus

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

class Fragment1:Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, //xml을 화면에 사용할 준비를 함. -> 뷰로 만듬
        container: ViewGroup?, //프라그먼트에서 사용될 xml의 부모뷰
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(
            R.layout.first_fragment, container, false
        ) //(프래그먼트 xml, 부모 뷰, 루트 뷰에 언제 붙을지(트루:바로, 펄스: 때가 되면))
        view.findViewById<TextView>(R.id.fragment_first).setOnClickListener {
            (activity as com.example.fastcampus.Fragment).printTestLog()
        }
        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val data:String? = arguments?.getString("key")
        Log.d("tesst", "data : " + data)
    }

    fun printTestLog1(){
        Log.d("tesst", "print test log1")
    }
}