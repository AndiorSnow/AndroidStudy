package com.example.yancourse2.components

import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class TestBroadCastReceiverActivity:AppCompatActivity() {
    private lateinit var receiver: TestBroadcastReceiver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //动态注册，不建议使用静态注册，但是应用自己定义的事件时，可以用静态注册
        receiver = TestBroadcastReceiver()
        //创建广播过滤器，指定只接收android.net.conn.CONNECTIVITY_CHANGE的广播事件
        val intentFilter = IntentFilter()
        intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION)
        registerReceiver(receiver, intentFilter)


    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(receiver)   //必须在onDestroy时反注册，否则会内存泄漏
    }
}