package com.example.myapplication.data.login

data class ResponseLoginData(
    val status: Int,
    val success: Boolean,
    val message: String,
    val data : Data,
) {
    data class Data(
        val id: Int,
        val name: String,
        val email: String,
    )
}