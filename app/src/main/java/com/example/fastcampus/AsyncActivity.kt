package com.example.fastcampus

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ProgressBar
import android.widget.TextView
import java.lang.Thread

class AsyncActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_async)
        val backgroundAsyncTask = BackgroundAsyncTask(
            findViewById(R.id.progressBar), findViewById(R.id.progressText)
        )

        findViewById<TextView>(R.id.start).setOnClickListener {
            backgroundAsyncTask.execute()
        }

        findViewById<TextView>(R.id.stop).setOnClickListener {
            backgroundAsyncTask.cancel(true)
        }

        findViewById<TextView>(R.id.shot).setOnClickListener {
            Log.d("threadss","shot")
        }
    }
}

class BackgroundAsyncTask(
    val progressbar:ProgressBar,
    val progressText:TextView
): AsyncTask<Int, Int, Int>(){
// deprecated -> 코루틴 사용 -> 멀티 태스킹, 동기/비동기 처리
    //<Params, progress, Result>
    //params -> doInBackground에서 사용하는 타입
    //progress -> onProgressUpdate에서 사용할 타입
    //Result -> onPostExecute에서 사용할 타입

    var percent = 0
    override fun doInBackground(vararg params: Int?): Int {
        while (isCancelled == false){
            percent++
            if (percent>100) break
            else publishProgress(percent)
            Thread.sleep(100)
        }
        //백그라운드에서 할 작업
        return percent
    }

    override fun onPreExecute() {

        //BackgroundAsyncTask 실행하기 전에 할 작업
        percent = 0
        progressbar.setProgress(percent)
    }

    override fun onPostExecute(result: Int?) {
        progressText.text="완료"
        //BackgroundAsyncTask 작업이 다 끝나고 나서 할 작업
    }

    override fun onProgressUpdate(vararg values: Int?) {
        progressbar.setProgress(values[0]?:0)
        progressText.text = "percent : "+values[0]
        //진행 중에 업데이트 하고 싶은 작업
    }

    override fun onCancelled(result: Int?) {
        progressbar.setProgress(0)
        progressText.text = "취소"
        //BackgroundAsyncTask이 멈췄을 때 하고 싶은 작업
    }

    override fun onCancelled() {
        super.onCancelled()
    }
}