package com.perqin.dailywallpapers.data.models.wallpaper

import android.arch.lifecycle.LiveData
import com.perqin.dailywallpapers.data.models.wallpaperssource.WallpapersSource
import java.util.*

/**
 * Created on 11/5/17.
 *
 * @author perqin
 */
class WallpapersLiveData : LiveData<List<Wallpaper>>() {
    var wallpapersSource: WallpapersSource? = null
        set(value) {
            field = value
            updateWallpapers()
        }

    var date: Calendar = Calendar.getInstance()
        set(value) {
            field = value
            updateWallpapers()
        }

    private fun updateWallpapers() {
        // TODO: Update from network as well as local cache
        if (wallpapersSource != null) {
            val wallpaper = Wallpaper(null, wallpapersSource!!.uid!!, date.timeInMillis, "https://www.google.com/some-image.jpg")
            value = listOf(wallpaper)
        }
    }
}
