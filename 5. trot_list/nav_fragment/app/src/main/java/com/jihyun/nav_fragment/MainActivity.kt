package com.jihyun.nav_fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

/*
    기존에는 Activity를 여러 개 만들어서 화면 전환
    네비게이션 바를 만들어 프래그먼트를 전환시켜서 화면전환을 할 수도 있음
    한 개의 Activity에 여러 개의 프래그먼트가 존재하고 프래그먼트를 전환시켜서 화면 전환
 */

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}