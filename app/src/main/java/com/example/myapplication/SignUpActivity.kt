package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.myapplication.databinding.ActivitySignUpBinding
import com.example.myapplication.login.ServiceCreator
import com.example.myapplication.signup.RequestSignupData
import com.example.myapplication.signup.ResponseSignupData
import retrofit2.Call
import retrofit2.Response

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    private fun textNullChecker(): Boolean {
        if (!binding.etName.text.isNullOrBlank() && !binding.etId.text.isNullOrBlank() && !binding.etPw.text.isNullOrBlank())
            return true
        return false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btSignup.setOnClickListener {
            if (textNullChecker()) {
                initNetWork()
            } else {
                Toast.makeText(this, "입력되지 않은 정보가 있습니다.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun initNetWork() {
        val requestSignupData = RequestSignupData(
            id = binding.etId.text.toString(),
            name = binding.etName.text.toString(),
            password = binding.etPw.text.toString(),
        )
        val call: Call<ResponseSignupData> = ServiceCreator.signupService.postSignup(requestSignupData)
        call.enqueue(object : retrofit2.Callback<ResponseSignupData> {
            override fun onResponse(call: Call<ResponseSignupData>, response: Response<ResponseSignupData>) {
                if (response.isSuccessful) {
                    val data = response.body()?.data
                    Toast.makeText(this@SignUpActivity, "${data?.name}님 회원가입 되었습니다.", Toast.LENGTH_SHORT).show()
                    finish()
                } else {
                    Toast.makeText(this@SignUpActivity, "Signup Fail", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<ResponseSignupData>, t: Throwable) {
                Log.e("Network_Test", "error : $t")
            }
        })
    }
}