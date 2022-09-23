package com.jihyun.questionmark

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

/*
    * 물음표(?) -> null일 수 있음
    * 느낌표(!) -> null이 아님
 */

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 물음표가 들어가면 null일 수도 있고 해당하는 형태의 값일 수 있음(여기서는 문자열)
        val value : String? = "a"
        val value2 : String? = null

        // Log.d("MainActivity", value2!!) -> NullPointerException Error 발생 => !면 null값을 가질 수 없음


    }
}