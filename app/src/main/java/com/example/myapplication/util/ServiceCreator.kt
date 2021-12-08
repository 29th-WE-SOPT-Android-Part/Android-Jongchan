package com.example.myapplication.util

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceCreator {
    private const val BASE_URL = "https://asia-northeast3-we-sopt-29.cloudfunctions.net/api/"
    // Retrofit 객체 생성
    private val retrofit: Retrofit = Retrofit
        .Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val sampleService: SampleService = retrofit.create(SampleService::class.java)
    val signupService : SignupService = retrofit.create(SignupService::class.java)
}