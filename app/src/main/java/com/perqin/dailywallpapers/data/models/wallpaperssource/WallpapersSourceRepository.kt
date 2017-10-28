package com.perqin.dailywallpapers.data.models.wallpaperssource

import com.perqin.dailywallpapers.data.room.AppDb

/**
 * Author: perqin
 * Date  : 10/25/17
 */
object WallpapersSourceRepository {
    private val wallpapersSourceDao = AppDb.instance.wallpapersSourceDao()

    fun getAllWallpapersSources() = wallpapersSourceDao.queryAllWallpapersSources()

    fun getWallpapersSource(wallpapersSourceUid: Long) = wallpapersSourceDao.queryWallpapersSourceByUid(wallpapersSourceUid)

    fun addWallpapersSource(wallpapersSource: WallpapersSource) {
        wallpapersSourceDao.insertWallpapersSource(wallpapersSource)
    }

    fun updateWallpapersSource(wallpapersSource: WallpapersSource) = wallpapersSourceDao.updateWallpapersSource(wallpapersSource)
}
