package com.perqin.dailywallpapers.data.models.wallpaperssource

import android.arch.lifecycle.Transformations
import com.perqin.dailywallpapers.data.android.PreferencesStore
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

    fun getSelectedWallpapersSourceUid() = PreferencesStore.getSelectedWallpapersSourceUid()

    fun getSelectedWallpapersSource() = Transformations.switchMap(PreferencesStore.getSelectedWallpapersSourceUid(), {
        wallpapersSourceDao.queryWallpapersSourceByUid(it)
    })!!

    fun setSelectedWallpapersSourceByUid(uid: Long) {
        PreferencesStore.setSelectedWallpapersSourceUid(uid)
    }

    fun setSelectedWallpapersSource(wallpapersSource: WallpapersSource) {
        PreferencesStore.setSelectedWallpapersSourceUid(wallpapersSource.uid!!)
    }
}
