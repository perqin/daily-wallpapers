package com.perqin.dailywallpapers.viewmodels

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.perqin.dailywallpapers.data.models.wallpaperssource.WallpapersSource
import com.perqin.dailywallpapers.data.models.wallpaperssource.WallpapersSourceRepository

/**
 * @author perqin
 * @date 10/27/17
 */
class EditingWallpapersSourceViewModel : ViewModel() {
    var editingWallpapersSource: LiveData<WallpapersSource>? = null

    fun init(wallpapersSourceUid: Long?) {
        editingWallpapersSource =
                if (wallpapersSourceUid == null) MutableLiveData<WallpapersSource>()
                else WallpapersSourceRepository.getWallpapersSource(wallpapersSourceUid)
    }
}
