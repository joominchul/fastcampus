package com.example.fastcampus

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.util.Log

class MasterApplication: Application() {

    val userId = 1000
    override fun onCreate() {
        super.onCreate()
        registerActivityLifecycleCallbacks(object :Application.ActivityLifecycleCallbacks{


            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
                Log.d("threadss", "onActivityCreated")
            }


            override fun onActivityStarted(activity: Activity) {
                Log.d("threadss", "onActivityStarted")
            }



            override fun onActivityResumed(activity: Activity) {
                Log.d("threadss", "onActivityResumed")
            }



            override fun onActivityPaused(activity: Activity) {
                Log.d("threadss", "onActivityPaused")
            }


            override fun onActivityStopped(activity: Activity) {
                Log.d("threadss", "onActivityStopped")
            }


            override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
                Log.d("threadss", "onActivitySaveInstanceState")
            }



            override fun onActivityDestroyed(activity: Activity) {
                Log.d("threadss", "onActivityDestroyed")
            }

        })


    }

    fun methodFromApplication(){
        Log.d("threadss", "methodFromApplication")
    }


}