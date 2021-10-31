package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.databinding.ActivitySignInBinding

class SignInActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignInBinding
    private lateinit var getResultText: ActivityResultLauncher<Intent>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        title = "SOPT_WEEK_3"

        val signUpIntent = Intent(this@SignInActivity, SignUpActivity::class.java)
        val longIntent = Intent(this@SignInActivity, MainActivity::class.java)

        getResultText = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK) {
                val id = it.data?.getStringExtra("setId")
                val pw = it.data?.getStringExtra("setPw")
                binding.idEditText.setText(id)
                binding.pwEditText.setText(pw)
            }
        }

        binding.btLogin.setOnClickListener {
            if (!binding.idEditText.text.isNullOrBlank() && !binding.pwEditText.text.isNullOrBlank()) {
                Toast.makeText(this, "${binding.idEditText.text}님 환영합니다.", Toast.LENGTH_SHORT).show()
                startActivity(longIntent)
            } else {
                Toast.makeText(this, "로그인 실패", Toast.LENGTH_SHORT).show()
            }
        }

        binding.tvSignUp.setOnClickListener {
            getResultText.launch(signUpIntent)
        }

        setContentView(binding.root)
    }
}