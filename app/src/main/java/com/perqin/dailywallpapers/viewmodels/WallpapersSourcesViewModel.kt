package com.perqin.dailywallpapers.viewmodels

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.perqin.dailywallpapers.data.models.wallpaperssource.WallpapersSource
import com.perqin.dailywallpapers.data.models.wallpaperssource.WallpapersSourceRepository

/**
 * Author: perqin
 * Date  : 10/25/17
 */
class WallpapersSourcesViewModel : ViewModel() {
    val wallpapersSources: LiveData<List<WallpapersSource>?> by lazy {
        WallpapersSourceRepository.getAllWallpapersSources()
    }
}
