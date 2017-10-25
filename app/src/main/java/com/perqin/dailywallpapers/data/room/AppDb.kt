package com.perqin.dailywallpapers.data.room

import android.arch.persistence.room.Room
import com.perqin.dailywallpapers.app.AppContext

/**
 * Author: perqin
 * Date  : 10/25/17
 */
object AppDb {
    fun instance() = Room.databaseBuilder(
            AppContext,
            AppRoomDatabase::class.java,
            AppRoomDatabase.DB_NAME
    ).build()
}
