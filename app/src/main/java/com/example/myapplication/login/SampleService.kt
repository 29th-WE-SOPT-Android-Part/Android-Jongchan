package com.example.myapplication.login

import com.example.myapplication.signup.RequestSignupData
import com.example.myapplication.signup.ResponseSignupData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface SampleService {
    @Headers("Content-Type:application/json")
    @POST("user/login")
    fun postLogin(
        @Body body: RequestLoginData
    ) : Call<ResponseLoginData>
}