package com.example.yancourse2.components

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class TestBroadcastRecevierActivity : AppCompatActivity(){
    private lateinit var myReceiver: TestBroadcastReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        myReceiver = TestBroadcastReceiver()
        // Create a broadcast filter that only accepts android.net.conn.CONNECTIVITY_ Chang's broadcast event
        val intentFilter = IntentFilter()
        // Add broadcast events that need to be monitored
        intentFilter.addAction(Intent.ACTION_CONFIGURATION_CHANGED)
        // Dynamic registration of broadcast receivers
        registerReceiver(myReceiver, intentFilter)
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(myReceiver)   // It is necessary to unregister during onDestroy, otherwise there will be a memory leak.
    }
}