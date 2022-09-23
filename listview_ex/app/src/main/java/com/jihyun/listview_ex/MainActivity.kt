package com.jihyun.listview_ex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

/*
    * ListView
    item들로 이루어짐
    MainActivity -> Adapter 데이터 보냄 -> listview_item.xml에 데이터를 하나씩 보냄 -> activity_main.xml의 ListView에 넣어줌
 */

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 아이템 만들기
        val list_item = mutableListOf<ListViewModel>()

        list_item.add(ListViewModel("a", "b"))
        list_item.add(ListViewModel("c", "d"))
        list_item.add(ListViewModel("e", "f"))

        // activity_main의 listView 가져옴
        val listView = findViewById<ListView>(R.id.mainListView)

        // 데이터 넘겨주기 (MainActivity -> Adapter)
        val listadapter = ListViewAdapter(list_item)

        // listview_item.xml과 activity_main.xml의 listview와 연결
        listView.adapter = listadapter

    }
}