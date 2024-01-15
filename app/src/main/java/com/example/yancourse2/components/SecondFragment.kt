package com.example.yancourse2.components

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class SecondFragment: Fragment() {
    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.e("SecondFragment", "onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("SecondFragment", "onCreate")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val textView = TextView(context)
        textView.text = "SecondFragment"
        textView.gravity = Gravity.CENTER
        Log.e("SecondFragment", "onCreateView")
        return textView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val intValue = arguments?.getInt("int_extra")
//        val stringValue = arguments?.getString("string_extra")
//
//        val textView = view as TextView
//        textView.text = "${intValue}--${stringValue}"


        val textView = view as TextView
        textView.text = "${arguments?.getString("tab")}"

        //Service
//        textView.setOnClickListener {
//            startActivity(Intent(context, TestServiceActivity::class.java))
//        }

        //BroadcastReceiver
        textView.setOnClickListener {
            startActivity(Intent(context, TestBroadCastReceiverActivity::class.java))
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.e("SecondFragment", "onActivityCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.e("SecondFragment", "onStart")
    }

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        // If and only if there are multiple Fragments in the Activity and show-hide is called
        // Calling ft.show, the current Fragment is visible and hidden is false
        // Calling ft.hide, the current Fragment is invisible and hidden is hidden为true
        Log.e("SecondFragment", "onHideChanged:${arguments?.getString("tab")}-${hidden}")
    }

    override fun onResume() {
        super.onResume()
        Log.e("SecondFragment", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.e("SecondFragment", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.e("SecondFragment", "onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.e("SecondFragment", "onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("SecondFragment", "onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.e("SecondFragment", "onDetach")
    }
}