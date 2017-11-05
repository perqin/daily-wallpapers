package com.perqin.dailywallpapers.data.models.wallpaper

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.perqin.dailywallpapers.data.models.wallpaperssource.WallpapersSource
import java.util.*

/**
 * Created on 11/5/17.
 *
 * @author perqin
 */
object WallpaperRepository {
    fun getFilteredWallpapers(): WallpapersLiveData = WallpapersLiveData()

    fun getWallpapersBySourcesAndDate(wallpapersSource: WallpapersSource, calendar: Calendar): LiveData<List<Wallpaper>> {
        return MutableLiveData()
    }
}
