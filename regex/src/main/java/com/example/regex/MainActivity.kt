package com.example.regex

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        val tvTest = findViewById<TextView>(R.id.tv_test)
        val text = "  测试\n  "
        val replace = text.replace("<!--BA-->(.*?)<!--EA-->", "$1")
        tvTest.text = replace
        Log.d(TAG, "initView:trim ${replace.trim()}"+"jjjj")
    }

    companion object {
        private const val TAG = "MainActivity"
    }

}