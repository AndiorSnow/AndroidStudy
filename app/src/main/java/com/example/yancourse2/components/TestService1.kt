package com.example.yancourse2.components

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class TestService1: Service(){
    private val TAG= "TestService1"
    override fun onCreate() {
        Log.e(TAG, "onCreate")
        super.onCreate()
    }

    override fun onBind(intent: Intent?): IBinder? {
        Log.e(TAG, "onBind")
        return null
    }

    /*
    * For startService, onStartCommand is the place used to handle backend tasks.
    * If startService is called multiple times, it will directly call onStartService instead of onCreate.
    *
    * The service launched in this way has a lifecycle that is as long as the application's lifecycle.
    * If the application is not killed, the service will continue to run unless stopService is called.
    * Usually used to create a background task that runs continuously for a long time, such as socket, file upload and download tasks.
    * */

     override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.e(TAG, "onStartCommand")
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onUnbind(intent: Intent?): Boolean {
        Log.e(TAG, "onUnbind")
        return super.onUnbind(intent)
    }

    override fun onDestroy() {
        Log.e(TAG, "onDestroy")
        super.onDestroy()
    }

}