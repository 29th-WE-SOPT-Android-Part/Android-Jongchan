package com.example.myapplication.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.Toolbar
import androidx.appcompat.app.ActionBar
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityOnBodingBinding
import java.util.prefs.PreferenceChangeEvent

class OnBodingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOnBodingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnBodingBinding.inflate(layoutInflater)

        initToolBar()

        setContentView(binding.root)
    }

    private fun initToolBar() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_container) as NavHostFragment
        val navController = navHostFragment.navController
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        binding.tbTitle.setupWithNavController(navController, appBarConfiguration)
    }
}