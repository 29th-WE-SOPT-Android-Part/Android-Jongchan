package com.example.myapplication.view.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.myapplication.databinding.ActivitySignInBinding
import com.example.myapplication.data.login.RequestLoginData
import com.example.myapplication.data.login.ResponseLoginData
import com.example.myapplication.shortToast
import com.example.myapplication.util.ServiceCreator
import com.example.myapplication.util.SharedPreferences
import retrofit2.Call
import retrofit2.Response

class SignInActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignInBinding
    private lateinit var getResultText: ActivityResultLauncher<Intent>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        title = "SOPT_WEEK_4"

        val signUpIntent = Intent(this@SignInActivity, SignUpActivity::class.java)
//        val longIntent = Intent(this@SignInActivity, MainActivity::class.java)

        getResultText =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                if (it.resultCode == RESULT_OK) {
                    val id = it.data?.getStringExtra("setId")
                    val pw = it.data?.getStringExtra("setPw")
                    binding.idEditText.setText(id)
                    binding.pwEditText.setText(pw)
                }
            }

        initLogin()
        initSignup(signUpIntent)
        initClickEvent()
        isAutoLogin()
        setContentView(binding.root)
    }

    private fun initClickEvent() {
        binding.ibAutoLogin.setOnClickListener {
            binding.ibAutoLogin.isSelected = !binding.ibAutoLogin.isSelected
            SharedPreferences.setAutoLogin(this, binding.ibAutoLogin.isSelected)
        }

    }

    private fun initLogin() {
        binding.btLogin.setOnClickListener {
            if (!binding.idEditText.text.isNullOrBlank() && !binding.pwEditText.text.isNullOrBlank()) {
                Toast.makeText(this, "${binding.idEditText.text}님 환영합니다.", Toast.LENGTH_SHORT)
                    .show()
                initNetWork()
            } else {
                Toast.makeText(this, "로그인 실패", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun initSignup(signUpIntent: Intent) {
        binding.tvSignUp.setOnClickListener {
            getResultText.launch(signUpIntent)
        }
    }

    private fun isAutoLogin() {
        if (SharedPreferences.getAutoLogin(this)) {
            shortToast("자동 로그인")
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

    private fun initNetWork() {
        val requestLoginData = RequestLoginData(
            binding.idEditText.text.toString(),
            binding.pwEditText.text.toString(),
        )
        val call: Call<ResponseLoginData> = ServiceCreator.sampleService.postLogin(requestLoginData)
        call.enqueue(object : retrofit2.Callback<ResponseLoginData> {
            override fun onResponse(
                call: Call<ResponseLoginData>,
                response: Response<ResponseLoginData>
            ) {
                if (response.isSuccessful) {
                    val data = response.body()?.data
                    Toast.makeText(
                        this@SignInActivity,
                        "${data?.email}님 반갑습니다!",
                        Toast.LENGTH_SHORT
                    ).show()
                    startActivity(Intent(this@SignInActivity, MainActivity::class.java))
                } else {
                    Toast.makeText(this@SignInActivity, "Login_Fail", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<ResponseLoginData>, t: Throwable) {
                Log.e("Network_Test", "error : $t")
            }
        })
    }
}