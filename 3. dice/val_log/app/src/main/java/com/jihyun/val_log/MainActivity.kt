package com.jihyun.val_log

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
            * val vs var
            * val : 한 번 선언하면 값을 바꿀 수 없음
            * var : 선언 후에 값을 바꿀 수 있음
        */

        /*
        // * val vs var 실습
        var value = "여기는 value입니다!"
        val value2 = "여기는 value2입니다!"

        value = "여기는 value가 아닙니다!"
        */

        // Log 찍는 법
        // Log.로그 종류("지금 있는 곳이 어디인지 (어떤 파일인지), 값"
        // Logcat에서 확인 가능
        val test = " 여기는 테스트 값입니다."

        Log.e("MainActivity", test) // 오류
        Log.w("MainActivity", test) // 경고
        Log.i("MainActivity", test) // 정보
        Log.d("MainActivity", test) // 디버그
        Log.v("MainActivity", test) // 상세
    }
}