package com.example.apparchitecture

import com.example.apparchitecture.room.AppDatabase

/**
 * Created by yupenglei on 18/1/18.
 */
class Constants {
    companion object {
        // todo 需要单例实现
        lateinit var appDatabase: AppDatabase
    }
}