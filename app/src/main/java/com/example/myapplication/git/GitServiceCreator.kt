package com.example.myapplication.git

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object GitServiceCreator {
    private const val BASE_URL = "https://api.github.com"
    fun getApi(): GitService = Retrofit.Builder().baseUrl(BASE_URL).client(OkHttpClient())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(GitService::class.java)
}