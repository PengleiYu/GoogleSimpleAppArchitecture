package com.example.apparchitecture

import android.app.Application
import android.arch.persistence.room.Room
import com.example.apparchitecture.room.AppDatabase

/**
 * Created by yupenglei on 18/1/18.
 */
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        val dbName = "test.db"
        Constants.appDatabase = Room
                .databaseBuilder(this, AppDatabase::class.java, dbName)
                .fallbackToDestructiveMigration()
                .build()
    }
}