package com.example.myapplication.view.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.myapplication.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler(Looper.getMainLooper()).postDelayed({
          startActivity(Intent(this@SplashActivity, SignInActivity::class.java))
          finish()
        }, TIME)
    }
    companion object{
        const val TIME = 2000L
    }
}