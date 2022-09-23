package com.jihyun.listview_ex

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class ListViewAdapter(val List : MutableList<ListViewModel>) : BaseAdapter(){
    // ListView의 개수 -> item의 개수
    override fun getCount(): Int {
        return List.size
        // 리스트의 크기만큼으로 설정
    }

    // getItem과 getItemId는 크게 신경쓰지 않아도 됨
    override fun getItem(p0: Int): Any {
        return List[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {

        var convertView = p1

        // listView_item에 있는 View를 가져오는 부분
        if (convertView == null) {
            convertView = LayoutInflater.from(p2?.context).inflate(R.layout.listview_item, p2, false)
        }

        val title = convertView!!.findViewById<TextView>(R.id.listviewItem)
        val content = convertView!!.findViewById<TextView>(R.id.listviewItem2)

        title.text = List[p0].title
        content.text = List[p0].content
        // List[0] -> ListVIewModel("a","b")

        return convertView!!
    }
}