package com.perqin.dailywallpapers.data.room

import android.arch.persistence.room.Room
import com.perqin.dailywallpapers.app.App

/**
 * Author: perqin
 * Date  : 10/25/17
 */
object AppDb {
    val instance by lazy {
        Room.databaseBuilder(App.context, AppRoomDatabase::class.java, AppRoomDatabase.DB_NAME).build()
    }
}
