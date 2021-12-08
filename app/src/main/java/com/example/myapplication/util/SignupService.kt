package com.example.myapplication.util

import com.example.myapplication.data.signup.RequestSignupData
import com.example.myapplication.data.signup.ResponseSignupData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface SignupService {
    @Headers("Content-Type:application/json")
    @POST("user/signup")
    fun postSignup(
        @Body body: RequestSignupData
    ): Call<ResponseSignupData>
}