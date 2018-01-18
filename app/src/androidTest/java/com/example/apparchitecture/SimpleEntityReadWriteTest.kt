package com.example.apparchitecture

import android.arch.persistence.room.Room
import android.content.Context
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import com.example.apparchitecture.room.AppDatabase
import com.example.apparchitecture.room.User
import com.example.apparchitecture.room.UserDao
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by yupenglei on 18/1/18.
 */
@RunWith(AndroidJUnit4::class)
class SimpleEntityReadWriteTest {
    private lateinit var dao: UserDao
    private lateinit var db: AppDatabase

    @Before
    fun createDb() {
        val context: Context = InstrumentationRegistry.getTargetContext()
        db = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).build()
        dao = db.userDao()
    }

    @After
    fun closeDb() {
        db.close()
    }

    @Test
    fun writeUserAndReadInList() {
        val user = User("Tom", "Kat")
        dao.insertAll(user)
        val byName = dao.findByName("Tom", "Kat")
//      找不到equalTo函数
//        assertThat(byName, )
    }

}