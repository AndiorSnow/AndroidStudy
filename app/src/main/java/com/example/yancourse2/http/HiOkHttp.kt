package com.example.yancourse2.http

import android.util.Log
import okhttp3.Call
import okhttp3.Callback
import okhttp3.FormBody
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.IOException
import java.util.concurrent.TimeUnit

object HiOkHttp {
    private val BASE_URL = "123.56.232.18:8080/serverdemo"
    val client = OkHttpClient.Builder()                   //Builder Design Pattern
        .connectTimeout(10, TimeUnit.SECONDS)      //Connection timeout
        .readTimeout(10, TimeUnit.SECONDS)         //Read timeout
        .writeTimeout(10, TimeUnit.SECONDS)        //Write timeout, i.e. request timeout
        .build()

    // Android is divided into main thread and sub thread.
    // The main thread is the main thread (UI thread) that the Android framework layer will start after the APP is launched.
    // sub thread  --new Thread().start()

    fun get() {            // Network Request Interface
        Thread(Runnable {  // Child Thread
            // Construct request body
            val requst: Request = Request.Builder()
                .url("$BASE_URL/user/query")
                .build()
            // Construct request object
            val call: Call = client.newCall(requst)
            // Initiate synchronization request execute - synchronous execution, 100ms, 1000ms, synchronization request cannot be placed in the main thread
            val request = call.execute()
            //
            val body = request.body?.string()
            println("get response: ${body}")
        }).start()
    }

    fun getAsync() {   // asynchronous
        val requst: Request = Request.Builder()
            .url("$BASE_URL/api/v1/top?type=Imdb&skip=0&limit=50&lang=Cn")
            .build()
        // Construct request object
        val call: Call = client.newCall(requst)
        // Initiate asynchronous request execute - asynchronous execution, 100ms, 1000ms
        call.enqueue(object : Callback {
            // The callbacks for both functions are in the child thread and need to be switched to the main thread in order to operate the UI widgets
            override fun onFailure(call: Call, e: IOException) {
                Log.e("OKHTTP", "get response onFailure:${e.message}")
            }

            override fun onResponse(call: Call, response: Response) {
                val body = response.body?.string()
                if (body != null) {
                    //filmList(body)
                }
                Log.e("OKHTTP"," get response: $body")
            }
        })

    }

    // "post" synchronization request
    fun post() {
        val body = FormBody.Builder()
            .add("userId", "1600932269")
            .add("tagID", "71")
            .build()
        val request = Request.Builder().url("$BASE_URL/tag/toggleTagFollow")
            .post(body)
            .build()
        val call = client.newCall(request)
        Thread(Runnable {
            val response = call.execute()
            Log.e("OKHTTP", "post response:${response.body?.string()}")
        }).start()
    }
}