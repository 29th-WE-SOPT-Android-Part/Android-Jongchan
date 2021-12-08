package com.example.myapplication.util

import com.example.myapplication.FollowerData
import com.example.myapplication.data.login.RequestLoginData
import com.example.myapplication.data.login.ResponseLoginData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Path

interface GitService {
    //    @Headers("Content-Type:application/vnd.github.v3+json")
    @GET("users/{username}/followers")
    fun githubFollowersGet(
        @Path("username")
        username: String
    ): Call<FollowerData>

    @GET("users/{username}/repos")
    fun getFollowers(
        @Body body: RequestLoginData
    ): Call<ResponseLoginData>

    @GET("/users/{username}")
    fun githubGet(
        @Path("username")
        username: String
    ): Call<FollowerData>
}