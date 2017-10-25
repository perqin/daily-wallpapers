package com.perqin.dailywallpapers.data.models.wallpaperssource

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel

/**
 * Author: perqin
 * Date  : 10/25/17
 */
class WallpapersSourceViewModel : ViewModel() {
    val wallpapersSources: LiveData<List<WallpapersSource>> by lazy {
        WallpapersSourceRepository.getAllWallpapersSources()
    }

    fun addWallpapersSource(wallpapersSource: WallpapersSource) {
        WallpapersSourceRepository.addWallpapersSource(wallpapersSource)
    }
}
