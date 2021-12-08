package com.example.myapplication

import android.content.Context
import android.widget.Toast

// -> React Store 같은 파일
// 사용 하는 거는 Store -> useContext 쓰는 기분이네
fun Context.shortToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}