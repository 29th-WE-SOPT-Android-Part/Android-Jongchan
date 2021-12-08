package com.example.myapplication.view.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivitySettingBinding
import com.example.myapplication.shortToast
import com.example.myapplication.util.SharedPreferences

class SettingActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySettingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingBinding.inflate(layoutInflater)
        logoutSetting()
        setContentView(binding.root)
    }

    private fun logoutSetting() {
        binding.btnLogout.setOnClickListener {
            SharedPreferences.setLogout(this)
            finish()
            startActivity(Intent(this, SignInActivity::class.java))
            shortToast("자동 로그인 해제")
        }
    }
}