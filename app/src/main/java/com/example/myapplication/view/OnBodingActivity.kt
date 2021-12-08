package com.example.myapplication.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import com.example.myapplication.databinding.ActivityOnBodingBinding
import java.util.prefs.PreferenceChangeEvent

class OnBodingActivity : AppCompatActivity() {
    private lateinit var binding : ActivityOnBodingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnBodingBinding.inflate(layoutInflater)

        setContentView(binding.root)
    }
}