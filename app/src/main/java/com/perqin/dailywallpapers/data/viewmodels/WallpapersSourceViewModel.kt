package com.perqin.dailywallpapers.data.viewmodels

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.perqin.dailywallpapers.data.models.wallpaperssource.WallpapersSource
import com.perqin.dailywallpapers.data.models.wallpaperssource.WallpapersSourceRepository

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
