package com.jihyun.recyclerviewmultiview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.jihyun.recyclerviewmultiview.databinding.LeftchatBinding
import com.jihyun.recyclerviewmultiview.databinding.RightchatBinding

class itemAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var leftBinding : LeftchatBinding
    private lateinit var rightBinding : RightchatBinding
    val items = mutableListOf<chatItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == 1)
        {
            leftBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.leftchat, parent, false)
            return leftViewHolder(leftBinding)
        }
        else
        {
            rightBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.rightchat, parent, false)
            return rightViewHolder(rightBinding)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is leftViewHolder) {
            holder.binding.leftChat.text = items[position].content
        }
        else if (holder is rightViewHolder) {
            holder.binding.rightChat.text = items[position].content
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemViewType(position: Int): Int {
        if (items[position].type == "left")
        {
            return 1
        }
        else
        {
            return 0
        }
    }

    inner class leftViewHolder(val binding: LeftchatBinding) : RecyclerView.ViewHolder(binding.root) {
    }

    inner class rightViewHolder(val binding: RightchatBinding) : RecyclerView.ViewHolder(binding.root) {
    }

    fun addChat(item : chatItem) {
        items.add(item)
    }
}