package com.example.print.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.print.R
import com.example.print.databinding.ActivityMainBinding
import com.example.print.util.manager.system.PrintManager

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_main
        )
        initListener()
    }

    private fun initListener() {
        binding.apply {
            tvTest.setOnClickListener {
                PrintManager.doPhotoPrint(
                    this@MainActivity,
                    R.drawable.ic_launcher,
                    "print_launcher"
                )
            }
        }
    }

}