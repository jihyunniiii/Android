package com.jihyun.mangoplate

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class ViewActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {

        auth = Firebase.auth

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)

        val webView = findViewById<WebView>(R.id.webView)
        webView.loadUrl(intent.getStringExtra("url").toString())

        // Write a message to the database
        val database = Firebase.database
        val myBookmarkRef = database.getReference("bookmark_ref")

        val url = intent.getStringExtra("url").toString()
        val title = intent.getStringExtra("title").toString()
        val imageurl = intent.getStringExtra("imageurl").toString()

        val saveText = findViewById<TextView>(R.id.saveText)
        saveText.setOnClickListener {
            myBookmarkRef
                .child(auth.currentUser!!.uid)
                .push()
                .setValue(ContentsModel(url, imageurl, title))
        }
    }
}