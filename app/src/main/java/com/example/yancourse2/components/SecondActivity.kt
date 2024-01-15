package com.example.yancourse2.components

import android.app.Activity
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.yancourse2.R
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.example.yancourse2.databinding.ActivitySecondBinding
import com.google.android.material.button.MaterialButton
import com.google.android.material.button.MaterialButtonToggleGroup
import java.lang.IllegalStateException


class SecondActivity : AppCompatActivity(){
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toggleGroup.addOnButtonCheckedListener {group, checkId, isChecked ->
            val childCount = group.childCount
            var selectIndex = 0
            for (index in 0 until childCount) {
                val button = group.getChildAt(index) as MaterialButton
                if (button.id == checkId) {
                    // Selected button
                    selectIndex = index
                    button.setTextColor(Color.RED)
                    button.iconTint = ColorStateList.valueOf((Color.RED))
                } else {
                    button.setTextColor(Color.BLACK)
                    button.iconTint = ColorStateList.valueOf((Color.BLACK))
                }
            }

            switchFragment(selectIndex)
        }

        binding.toggleGroup.check(R.id.tab1)

//        //Fragment
//        val fragment = SecondFragment()
//        // Passing Parameters
//        val bundle = Bundle()
//        bundle.putInt("int_extra", 100)
//        bundle.putString("string_extra", "string_extra_value")
//        fragment.arguments = bundle
//
//        // Dynamic addition
//        val ft = supportFragmentManager.beginTransaction()
//        ft.add(R.id.container, fragment)
//        ft.commitAllowingStateLoss()

        // Activity
//        val stringExtra = intent.getStringExtra("extra_data")
//        val intExtra = intent.getIntExtra("extra_int_data", 0)
//
//        val textView = TextView(this)
//        textView.text = "SecondActivity${stringExtra}--${intExtra}"
//        textView.gravity = Gravity.CENTER
//        setContentView(textView)
//
//        textView.setOnClickListener {
//            val resultIntent  = Intent()
//            resultIntent.putExtra("result_extra_string", "result_extra_string")
//            resultIntent.putExtra("result_extra_int", 1000)
//            setResult(Activity.RESULT_OK, resultIntent)
//            finish()
//        }

        Log.e("SecondActivity", "OnCreate")
    }

    private var tab1Fragment: SecondFragment? = null
    private var tab2Fragment: SecondFragment? = null
    private var tab3Fragment: SecondFragment? = null
    private var showFragment: Fragment? = null
    private fun switchFragment(selectIndex: Int) {
        val fragment = when(selectIndex) {
            0 -> {
                if (tab1Fragment == null) {
                    tab1Fragment = SecondFragment()
                    val bundle = Bundle()
                    bundle.putString("tab", "tab1")
                    tab1Fragment!!.arguments = bundle //!!Only accessible when it is not empty
                }
                tab1Fragment
            }
            1 -> {
                if (tab2Fragment == null) {
                    tab2Fragment = SecondFragment()
                    val bundle = Bundle()
                    bundle.putString("tab", "tab2")
                    tab2Fragment!!.arguments = bundle
                }
                tab2Fragment
            }
            2 -> {
                if (tab3Fragment == null) {
                    tab3Fragment = SecondFragment()
                    val bundle = Bundle()
                    bundle.putString("tab", "tab3")
                    tab3Fragment!!.arguments = bundle
                }
                tab3Fragment
            }
            else -> {
                throw IllegalStateException("下标不符合预期")
            }
        } ?: return // If the fragment is empty, it will be returned directly. Otherwise, what are the types?, mismatch with type requirement for add()

        val ft = supportFragmentManager.beginTransaction()
        if (!fragment.isAdded) {
            ft.add(R.id.container, fragment)
        }
        if (showFragment != null) {
            ft.hide(showFragment!!)
        }
        ft.show(fragment)
        showFragment = fragment
        ft.commitAllowingStateLoss()
    }


    override fun onStart() {
        super.onStart()
        Log.e("SecondActivity", "OnStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e("SecondActivity", "OnResume")
    }

    override fun onPause() {
        super.onPause()
        Log.e("SecondActivity", "OnPause")
    }

    override fun onStop() {
        super.onStop()
        Log.e("SecondActivity", "OnStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("SecondActivity", "OnDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.e("SecondActivity", "OnRestart")
    }
}