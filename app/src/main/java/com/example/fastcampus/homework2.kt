package com.example.fastcampus

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText

class homework2 : AppCompatActivity() {
    lateinit var url: EditText
    lateinit var open: Button
    lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homework2)
        url = findViewById(R.id.url)
        open = findViewById(R.id.open)
        webView = findViewById(R.id.webview)

        webView.setWebViewClient(object :WebViewClient(){
            override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: WebResourceRequest?
            ): Boolean {
                return false
            }
        })


        open.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url.text.toString()))
            //webView.loadUrl(intent.data!!.toString())
            Log.d("testt", "button")
            //webView.loadUrl(url.text.toString())
            startActivity(intent)
        }

    }
}