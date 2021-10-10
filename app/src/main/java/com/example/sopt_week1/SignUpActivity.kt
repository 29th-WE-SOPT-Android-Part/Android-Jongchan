package com.example.sopt_week1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.sopt_week1.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    private fun textNullChecker(): Boolean {
        if (!binding.etName.text.isNullOrBlank()&& !binding.etId.text.isNullOrBlank() && !binding.etPw.text.isNullOrBlank())
            return true
        return false
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btSignUp.setOnClickListener {
            if (textNullChecker()) {
                val intent = Intent()
                intent.putExtra("setId", binding.etId.text.toString())
                intent.putExtra("setPw", binding.etPw.text.toString())
                setResult(RESULT_OK, intent)
                Toast.makeText(this, "회원가입이 완료 되었습니다.", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "입력되지 않은 정보가 있습니다.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}