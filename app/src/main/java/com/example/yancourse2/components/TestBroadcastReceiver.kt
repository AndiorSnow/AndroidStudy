package com.example.yancourse2.components

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.widget.Toast

class TestBroadcastReceiver:BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val action = intent?.action ?: return //接收动作，为空则返回
        if (action == ConnectivityManager.CONNECTIVITY_ACTION) {  // 判断网络是否连接
            val connectivityManager: ConnectivityManager = context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val info = connectivityManager.activeNetworkInfo      //当前网络连接类型
            if (info != null && info.isAvailable) {
                //有网络连接
                val typeName = info.typeName
                Toast.makeText(context, "当前网络类型：${typeName}", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(context, "当前无网络连接", Toast.LENGTH_LONG).show()
            }
        }
    }
}