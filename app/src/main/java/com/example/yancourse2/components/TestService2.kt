package com.example.yancourse2.components

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log

class TestService2: Service() {
    private val TAG= "TestService2"
    private var count = 0
    private var quit = false
    override fun onCreate() {
        Log.e(TAG, "onCreate")
        super.onCreate()

        Thread(Runnable {
            while (true) {
                if (quit) {
                    break
                }
                Thread.sleep(1000)
                count++
            }
        }).start()
    }

    private val binder = MyBinder()

    inner class MyBinder: Binder() {
        fun getCount(): Int {
            return count
        }
    }

    override fun onBind(intent: Intent?): IBinder? {
        Log.e(TAG, "onBind")
        return binder
    }

    // onStartCommand will not be triggered for services launched through bindService
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.e(TAG, "onStartCommand")
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onUnbind(intent: Intent?): Boolean {
        Log.e(TAG, "onUnbind")
        quit = true
        return super.onUnbind(intent)
    }

    override fun onDestroy() {
        Log.e(TAG, "onDestroy")
        super.onDestroy()
    }

}