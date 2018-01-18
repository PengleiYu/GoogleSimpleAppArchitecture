package com.example.apparchitecture.room

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import com.example.apparchitecture.Constants
import com.example.apparchitecture.R
import kotlinx.android.synthetic.main.activity_room.*
import java.util.*
import java.util.concurrent.Executors

/**
 * Created by yupenglei on 18/1/18.
 */
class RoomActivity : AppCompatActivity() {
    private val db = Constants.appDatabase
    private val dao = db.userDao()
    private val random = Random()
    private val threadPool = Executors.newCachedThreadPool()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)

        val adapter = ArrayAdapter<User>(this, android.R.layout.simple_list_item_1, mutableListOf())
        listView_room.adapter = adapter
        btn_add_room.setOnClickListener {
            val fist = "Tom" + random.nextInt(100)
            val last = "Jerry" + random.nextInt(100)
            threadPool.execute { dao.insertAll(User(fist, last)) }
        }
        btn_reload_room.setOnClickListener {
            threadPool.execute {
                val data = dao.all
                runOnUiThread { adapter.clear().let { adapter.addAll(data) } }
            }
        }

    }
}