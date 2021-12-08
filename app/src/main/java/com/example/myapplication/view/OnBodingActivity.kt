package com.example.myapplication.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityOnBodingBinding

class OnBodingActivity : AppCompatActivity() {
    private lateinit var binding : ActivityOnBodingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnBodingBinding.inflate(layoutInflater)

        setContentView(binding.root)
    }
}