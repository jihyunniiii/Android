package com.jihyun.databinding_ex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.jihyun.databinding_ex.databinding.ActivityMainBinding

/*
    * DataBinding
    * 기존 : activity_main.xml -> 버튼 존재 (디자인 하는 공간)
            MainActivity -> 버튼의 이름을 찾아와서 동작시킴 (ex. val vtn = findViewByld<Button>(R.id.button) btn.setOnclick
    * DataBinding -> 새로운 방식
 */

class MainActivity : AppCompatActivity() {

    // Databinding을 위해 추가
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // 1번 방식 : 기존 방식 (findViewById)
        /*val btn = findViewById<Button>(R.id.testBtnId)
        btn.setOnClickListener {
            Toast.makeText(this,"click", Toast.LENGTH_LONG).show()
        }*/

        // 2번 방식 : BataBinding
        // bundle.gradle - Module에 databinding enable true 해서 사용
        // activity_main.xml에서 layout으로 감싸줌줌
       // 코드 양 줄일 수 있음
        binding.testBtnId.setOnClickListener {
            Toast.makeText(this,"click", Toast.LENGTH_LONG).show()
        }

    }
}