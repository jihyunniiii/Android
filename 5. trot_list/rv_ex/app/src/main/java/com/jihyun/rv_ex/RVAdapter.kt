package com.jihyun.rv_ex

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RVAdapter(val items : MutableList<String>) : RecyclerView.Adapter<RVAdapter.ViewHolder>() {

    // Rv의 Item을 가져옴
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_item, parent, false)

        return ViewHolder(view)
    }
    
    //ItemClick을 직접 만들어 줘야함
    interface ItemClick {
        fun onClick(view : View, position: Int)
    }

    var itemClick : ItemClick? = null

    // ViewHolder에 바인딩
    // 뷰바인딩? : Adapter에 넘어온 데이터를 recyclerview_item.xml을 통해 recyclerview에 넣어주는 것
    override fun onBindViewHolder(holder: RVAdapter.ViewHolder, position: Int) {

        if (itemClick != null) {
            holder.itemView.setOnClickListener {v->
                itemClick?.onClick(v, position)
            }
        }
        holder.bindItems(items[position])
    }

    // 전체 RV의 개수
    override fun getItemCount(): Int {
        return items.size
    }

    // ViewHolder 만들기
    inner class ViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {

        fun bindItems(item : String) {
            val rv_text = itemView.findViewById<TextView>(R.id.rvItem)
            rv_text.text = item
            // 여기에서 item은 onBindViewHolder의 bindItems
        }

    }
}