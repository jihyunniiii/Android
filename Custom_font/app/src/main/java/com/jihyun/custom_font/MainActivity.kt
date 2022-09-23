package com.jihyun.custom_font

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

// 폰트 res 파일에 넣을 때 이름에 대문자가 존재하면 안드로이드 스튜디오가 인식을 못 함

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}