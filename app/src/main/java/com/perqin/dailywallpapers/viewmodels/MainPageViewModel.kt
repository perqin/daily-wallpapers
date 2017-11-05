package com.perqin.dailywallpapers.viewmodels

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MediatorLiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel
import com.perqin.dailywallpapers.data.models.wallpaper.Wallpaper
import com.perqin.dailywallpapers.data.models.wallpaper.WallpaperRepository
import com.perqin.dailywallpapers.data.models.wallpaperssource.WallpapersSource
import com.perqin.dailywallpapers.data.models.wallpaperssource.WallpapersSourceRepository
import java.util.*

/**
 * Created on 11/1/17.
 *
 * @author perqin
 */
class MainPageViewModel : ViewModel() {
    val wallpapersSources: LiveData<List<WallpapersSource>> by lazy {
        WallpapersSourceRepository.getAllWallpapersSources()
    }

    val selectedWallpapersSource: LiveData<WallpapersSource> by lazy {
        WallpapersSourceRepository.getSelectedWallpapersSource()
    }

    val wallpapers: LiveData<List<Wallpaper>> by lazy {
        Transformations.switchMap(MediatorLiveData<Pair<WallpapersSource, Calendar>>().apply {
            addSource(WallpapersSourceRepository.getSelectedWallpapersSource(), {
                value = Pair(it!!, Calendar.getInstance())
            })
            // TODO: Change date
        }, {
            WallpaperRepository.getWallpapersBySourcesAndDate(it.first, it.second)
        })
    }

    fun selectWallpapersSource(wallpapersSource: WallpapersSource) {
        WallpapersSourceRepository.setSelectedWallpapersSource(wallpapersSource)
    }
}
