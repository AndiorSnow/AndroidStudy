package com.example.yancourse2.components

import android.app.Service
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.yancourse2.R
import com.example.yancourse2.databinding.ActivityTestServiceBinding

class TestServiceActivity: AppCompatActivity() {
    private lateinit var binding: ActivityTestServiceBinding
    private var myBinder: TestService2.MyBinder? = null
    private var connection: ServiceConnection? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_test_service)
        // Bind Start Service
        // Maintain the IBind object of the started Service and define a ServiceConnection object at the same time
        connection = object : ServiceConnection {
            // Call back this method when the connection between Activity and Service is failed
            override fun onServiceDisconnected(name: ComponentName?) {
                Log.e("TestService2", "-----Service Disconnected-----")
            }

            // Callback this method when the connection between Activity and Service is successful
            override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
                Log.e("TestService2", "-----Service Connected-----")
                myBinder = service as TestService2.MyBinder
                var myService = myBinder!!.getCount()
            }
        }


        /*
        * Run some backend tasks that are equivalent to the Activity lifecycle, such as cross process communication.
        * */
        val intent = Intent(this, TestService2::class.java)
        bindService(intent, connection as ServiceConnection, Context.BIND_AUTO_CREATE)

        binding = ActivityTestServiceBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.startService.setOnClickListener {
            Log.e("TestService2", "getCount:=${myBinder?.getCount()}")
        }
        binding.stopService.setOnClickListener {
            unbindService(connection!!)
        }


        // Normal Start Service
//        binding = ActivityTestServiceBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        binding.startService.setOnClickListener {
//            val intent = Intent(this, TestService1::class.java)
//            startService(intent)
//        }
//
//        binding.stopService.setOnClickListener {
//            val intent = Intent(this, TestService1::class.java)
//            stopService(intent)
//        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unbindService(connection!!)
    }
}