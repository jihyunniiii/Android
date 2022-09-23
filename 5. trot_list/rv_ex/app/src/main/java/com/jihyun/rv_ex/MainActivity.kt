package com.jihyun.rv_ex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/*
     * RecyclerView
     ListView와 비슷하나 ListView보다 더 효율적임 하지만 만들기가 더 어려움
     뷰홀더로 뷰 재사용 가능
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val items = mutableListOf<String>()

        items.add("a")
        items.add("b")
        items.add("c")

        val rv = findViewById<RecyclerView>(R.id.rv)
        val rvAdapter = RVAdapter(items)

        rv.adapter = rvAdapter
        rv.layoutManager = LinearLayoutManager(this)

        rvAdapter.itemClick = object : RVAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                Toast.makeText(baseContext, items[position], Toast.LENGTH_LONG).show()
            }
        }

    }
}