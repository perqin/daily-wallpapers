package com.perqin.dailywallpapers.data.models.wallpaperssource

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*

/**
 * Author: perqin
 * Date  : 10/25/17
 */
@Dao
interface WallpapersSourceDao {
    @Insert
    fun insertWallpapersSource(wallpapersSource: WallpapersSource)

    @Query("SELECT * FROM ${WallpapersSource.TABLE_NAME}")
    fun queryAllWallpapersSources(): LiveData<List<WallpapersSource>?>

    @Query("SELECT * FROM ${WallpapersSource.TABLE_NAME} WHERE ${WallpapersSource.UID} = :wallpapersSourceUid LIMIT 1")
    fun queryWallpapersSourceByUid(wallpapersSourceUid: Long): LiveData<WallpapersSource?>

    @Update
    fun updateWallpapersSource(wallpapersSource: WallpapersSource)

    @Delete
    fun deleteWallpapersSource(wallpapersSource: WallpapersSource)
}
