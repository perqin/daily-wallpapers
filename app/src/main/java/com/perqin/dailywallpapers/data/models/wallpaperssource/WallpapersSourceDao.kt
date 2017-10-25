package com.perqin.dailywallpapers.data.models.wallpaperssource

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

/**
 * Author: perqin
 * Date  : 10/25/17
 */
@Dao
interface WallpapersSourceDao {
    @Insert
    fun insertWallpapersSource(wallpapersSource: WallpapersSource)

    @Query("SELECT * FROM ${WallpapersSource.TABLE_NAME}")
    fun queryAllWallpapersSources(): LiveData<List<WallpapersSource>>

    @Delete
    fun deleteWallpapersSource(wallpapersSource: WallpapersSource)
}
