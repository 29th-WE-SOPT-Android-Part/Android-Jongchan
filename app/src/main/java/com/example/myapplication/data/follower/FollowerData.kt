package com.example.myapplication

import com.google.gson.annotations.SerializedName

data class FollowerData(
    val id: String,
    val profile: String,
//    val bio: String,
)

data class getBio(
    val bio: String?
)

data class ResponseFollowerData(
    @SerializedName("login")
    val nickname: String,
    @SerializedName("avatar_url")
    val profile: String,
)

