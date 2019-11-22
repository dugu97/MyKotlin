package com.example.mykotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val itemList: List<ListItem> = listOf(
        ListItem(1, "title---1"),
        ListItem(2, "title---2"),
        ListItem(3, "title---3"),
        ListItem(4, "title---4"),
        ListItem(1, "title---5")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.list)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ItemAdapter(itemList, object : ItemAdapter.OnItemClick{
            override fun invoke(item: ListItem, position: Int) {
                Toast.makeText(this@MainActivity, "点击Item $position", Toast.LENGTH_LONG).show()
            }
        })

    }


}
