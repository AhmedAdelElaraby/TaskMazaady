package com.workdev.example.ui.Host

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.workdev.example.R
import com.workdev.example.databinding.ActivitySecondScreenBinding

class SecondScreen : AppCompatActivity() {
    lateinit var binding: ActivitySecondScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         enableEdgeToEdge()
        binding=DataBindingUtil.setContentView(this,R.layout.activity_second_screen)






    }
}