package com.example.myapplication.util

import android.content.Context

object SharedPreferences {
    private const val USER_AUTH = "USER_AUTH"
    private const val AUTO_LOGIN = "AUTO_LOGIN"

    fun getAutoLogin(context: Context): Boolean {
        val preferences = context.getSharedPreferences(USER_AUTH, Context.MODE_PRIVATE)

        return preferences.getBoolean(AUTO_LOGIN, false)
    }

    fun setLogout(context: Context) {
        val preferences = context.getSharedPreferences(USER_AUTH, Context.MODE_PRIVATE)
        preferences.edit()
            .remove(AUTO_LOGIN)
            .apply()
    }

    fun setAutoLogin(context: Context, auto: Boolean) {
        val preferences = context.getSharedPreferences(USER_AUTH, Context.MODE_PRIVATE)

        preferences.edit()
            .putBoolean(AUTO_LOGIN, auto)
            .apply()
    }
}