package com.example.yancourse2.components

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.widget.Toast

class TestBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action?.equals(ConnectivityManager.CONNECTIVITY_ACTION)==true){
            val connectivityManager: ConnectivityManager = context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val info = connectivityManager.activeNetworkInfo
            if(info != null && info.isAvailable) {
                val typeName = info.typeName
                Toast.makeText(context,"Current network name:${typeName}", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(context,"Currently no network connection.",Toast.LENGTH_LONG).show()
            }
        }
    }
}