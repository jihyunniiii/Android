package com.jihyun.mangoplate

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private val items = mutableListOf<ContentsModel>()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bookmarkButton = findViewById<TextView>(R.id.bookmarkBtn)
        bookmarkButton.setOnClickListener {
            val intent = Intent(this, BookmarkActivity::class.java)
            startActivity(intent)
        }

        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/aeO_cG35KO",
                "https://mp-seoul-image-production-s3.mangoplate.com/584169_1499487656176648.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "패스트리부티크"
            )
        )

        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/QxTRZZv3Dl",
                "https://mp-seoul-image-production-s3.mangoplate.com/180/488522_1639593249305_20640?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "삐아프"
            )
        )

        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/MMEELt3usvci",
                "https://mp-seoul-image-production-s3.mangoplate.com/817437_1610944024756964.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "라바즈"
            )
        )

        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/DgRCxk7eoWVA",
                "https://mp-seoul-image-production-s3.mangoplate.com/47875_1645581499288730.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "바이러닉에스프레소바"
            )
        )

        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/aeO_cG35KO",
                "https://mp-seoul-image-production-s3.mangoplate.com/584169_1499487656176648.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "패스트리부티크"
            )
        )

        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/QxTRZZv3Dl",
                "https://mp-seoul-image-production-s3.mangoplate.com/180/488522_1639593249305_20640?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "삐아프"
            )
        )

        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/MMEELt3usvci",
                "https://mp-seoul-image-production-s3.mangoplate.com/817437_1610944024756964.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "라바즈"
            )
        )

        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/DgRCxk7eoWVA",
                "https://mp-seoul-image-production-s3.mangoplate.com/47875_1645581499288730.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "바이러닉에스프레소바"
            )
        )

        val recyclerview = findViewById<RecyclerView>(R.id.rv)
        val rvAdapter = RVAdapter(baseContext, items)
        recyclerview.adapter = rvAdapter

        rvAdapter.itemClick = object: RVAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                val intent = Intent(baseContext, ViewActivity::class.java)
                intent.putExtra("url", items[position].url)
                intent.putExtra("title", items[position].titleText)
                intent.putExtra("imageurl", items[position].titleImageUrl)

                startActivity(intent)
            }
        }

        recyclerview.layoutManager = GridLayoutManager(this, 2)
    }
}