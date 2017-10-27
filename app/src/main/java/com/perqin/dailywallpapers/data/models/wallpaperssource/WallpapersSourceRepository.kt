package com.perqin.dailywallpapers.data.models.wallpaperssource

import android.arch.lifecycle.LiveData
import com.perqin.dailywallpapers.data.room.AppDb

/**
 * Author: perqin
 * Date  : 10/25/17
 */
object WallpapersSourceRepository {
    private val wallpapersSourceDao = AppDb.instance.wallpapersSourceDao()

    fun getAllWallpapersSources(): LiveData<List<WallpapersSource>> = wallpapersSourceDao.queryAllWallpapersSources()

    fun addWallpapersSource(wallpapersSource: WallpapersSource) {
        wallpapersSourceDao.insertWallpapersSource(wallpapersSource)
    }

    fun getWallpapersSource(wallpapersSourceUid: Long) = wallpapersSourceDao.queryWallpapersSourceByUid(wallpapersSourceUid)
}
