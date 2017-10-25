package com.perqin.dailywallpapers.data.room

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.perqin.dailywallpapers.data.models.wallpaperssource.WallpapersSource
import com.perqin.dailywallpapers.data.models.wallpaperssource.WallpapersSourceDao

/**
 * Author: perqin
 * Date  : 10/25/17
 */
@Database(entities = arrayOf(
        WallpapersSource::class
), version = 1)
abstract class AppRoomDatabase : RoomDatabase() {
    abstract fun wallpapersSourceDao(): WallpapersSourceDao

    companion object {
        val DB_NAME = "app_db"
    }
}
