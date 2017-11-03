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
    val selectableWallpapersSources: MediatorLiveData<Pair<List<WallpapersSource>, Long>> by lazy {
        MediatorLiveData<Pair<List<WallpapersSource>, Long>>().apply {
            addSource(WallpapersSourceRepository.getAllWallpapersSources(), {
                value = Pair(it!!, value!!.second)
            })
            addSource(WallpapersSourceRepository.getSelectedWallpapersSourceUid(), {
                value = Pair(value!!.first, it!!)
            })
            value = Pair(emptyList(), -1)
        }
    }

    fun selectWallpapersSources(uid: Long) {
        WallpapersSourceRepository.setSelectedWallpapersSourceByUid(uid)
    }
}
