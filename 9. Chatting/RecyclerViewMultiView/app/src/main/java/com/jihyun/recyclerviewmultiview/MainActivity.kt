package com.jihyun.recyclerviewmultiview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.jihyun.recyclerviewmultiview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    lateinit var chatAdapter : itemAdapter
    var tempchat = ""
    var changeType = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.chatBtn.setOnClickListener {
            tempchat = binding.chatText.text.toString()

            val chat = if (changeType) {
                chatItem(tempchat, "right")
            }
            else {
                chatItem(tempchat, "left")
            }

            chatAdapter.addChat(chat)
            binding.chattingList.smoothScrollToPosition(chatAdapter.items.size - 1)
            chatAdapter.notifyItemChanged(chatAdapter.items.size - 1)
            changeType = !changeType

            binding.chatText.text = null
        }

        chatAdapter = itemAdapter()
        binding.chattingList.adapter = chatAdapter
        binding.chattingList.layoutManager = LinearLayoutManager(this)
    }
}