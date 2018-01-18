package com.example.apparchitecture

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.apparchitecture.room.RoomActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val activities = listOf(RoomActivity::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView_main.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1,
                activities.map { it.simpleName })
        listView_main.setOnItemClickListener { _, _, position, _ ->
            startActivity(Intent(this, activities[position]))
        }
    }
}
