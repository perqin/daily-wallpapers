package com.perqin.dailywallpapers.viewmodels

import android.arch.lifecycle.MediatorLiveData
import android.arch.lifecycle.ViewModel
import com.perqin.dailywallpapers.data.models.wallpaperssource.WallpapersSource
import com.perqin.dailywallpapers.data.models.wallpaperssource.WallpapersSourceRepository

/**
 * Created on 11/1/17.
 *
 * @author perqin
 */
class MainPageViewModel : ViewModel() {
    val selectableWallpapersSources: MediatorLiveData<Pair<List<WallpapersSource>, WallpapersSource>> by lazy {
        MediatorLiveData<Pair<List<WallpapersSource>, WallpapersSource>>().apply {
            addSource(WallpapersSourceRepository.getAllWallpapersSources(), {
            })
            addSource(WallpapersSourceRepository.getSelectedWallpapersSource(), {
            })
        }
    }
}