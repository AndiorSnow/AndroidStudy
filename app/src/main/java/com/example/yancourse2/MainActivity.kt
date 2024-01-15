package com.example.yancourse2

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.yancourse2.databinding.ActivityMainBinding
import com.example.yancourse2.http.HiOkHttp
import com.google.android.material.button.MaterialButton
import com.google.android.material.button.MaterialButtonToggleGroup
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView  // lazy initialization

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(R.layout.activity_main)
//        // Change this to R.layout.comps_ Material_ After the button, this layout file can be associated with MainActivity and the widget named "toggleGroup" below can be found
//        val navView: BottomNavigationView = findViewById(R.id.nav_view)
//
//        val navController = findNavController(R.id.nav_host_fragment_activity_main)
//        // Passing each menu ID as a set of Ids because each
//        // menu should be considered as top level destinations.
////        val appBarConfiguration = AppBarConfiguration(
////            setOf(
////                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
////            )
////        )
////        setupActionBarWithNavController(navController, appBarConfiguration)
//        navView.setupWithNavController(navController)


        textView = TextView(this)
        textView.text = "MainActivity"
        textView.gravity = Gravity.CENTER
        setContentView(textView)

        HiOkHttp.get()

//        textView.setOnClickListener {
            // Explicit startup
//            val intent = Intent(MainActivity@ this, SecondActivity::class.java)
//            intent.putExtra("extra_data", "extra_data")
//            intent.putExtra("extra_int_data", 100)
//            //startActivity(intent)
//            startActivityForResult(intent, 1000)

            // Implicit startup, no need to specify the intent page, but action and category must be specified
//            val intent = Intent()
//            intent.action = "com.example.yancourse2.action.SECONDACTIVITY"
//            intent.addCategory("com.example.yancourse2.category.SECONDACTIVITY")
//
//            intent.putExtra("extra_data", "extra_data")
//            intent.putExtra("extra_int_data", 100)
//            startActivity(intent)

            // Making phone calls
//            val uri: Uri = Uri.parse("tel:10086")
//            val intent = Intent(Intent.ACTION_DIAL, uri)
//            startActivity(intent)

            // send message
//            val uri: Uri = Uri.parse("smsto:10086")
//            val intent = Intent(Intent.ACTION_SENDTO, uri)
//            intent.putExtra("sms_body", "Hello")
//            startActivity(intent)
//
//        }

        Log.e("MainActivity", "OnCreate")
//        val toggleGroup = findViewById<MaterialButtonToggleGroup>(R.id.toggle_group)
//        toggleGroup.addOnButtonCheckedListener(object :
//            MaterialButtonToggleGroup.OnButtonCheckedListener{
//            override fun onButtonChecked(
//                group: MaterialButtonToggleGroup?,
//                checkedId: Int,
//                isChecked: Boolean
//            ) {
//                Log.e("MainActivity", isChecked.toString())
//            }
//        })
    }


override fun onStart() {
        super.onStart()
        Log.e("MainActivity", "OnStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e("MainActivity", "OnResume")
    }

    override fun onPause() {
        super.onPause()
        Log.e("MainActivity", "OnPause")
    }

    override fun onStop() {
        super.onStop()
        Log.e("MainActivity", "OnStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("MainActivity", "OnDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.e("MainActivity", "OnRestart")
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1000 && resultCode == Activity.RESULT_OK && data != null) {
            val stringExtraResult = data.getStringExtra("result_extra_string")
            val intExtraResult = data.getIntExtra("result_extra_int", 0)

            textView.text = "${stringExtraResult}--${intExtraResult}"
        }
    }
}