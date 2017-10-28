package com.perqin.dailywallpapers.viewmodels

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModel
import com.perqin.dailywallpapers.data.models.wallpaperssource.WallpapersSource
import com.perqin.dailywallpapers.data.models.wallpaperssource.WallpapersSourceRepository
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.run

/**
 * @author perqin
 * @date 10/27/17
 */
class EditingWallpapersSourceViewModel : ViewModel() {
    private val editingWallpapersSource: MutableLiveData<WallpapersSource> = MutableLiveData()
    private val existingSourceObserver: Observer<WallpapersSource?> = Observer { wallpapersSource ->
        editingWallpapersSource.value = wallpapersSource
    }
    private var existingSource: LiveData<WallpapersSource?>? = null

    override fun onCleared() {
        existingSource?.removeObserver(existingSourceObserver)
    }

    fun init(wallpapersSourceUid: Long?) {
        if (wallpapersSourceUid == null) {
            editingWallpapersSource.value = WallpapersSource()
        } else {
            launch(UI) {
                existingSource = run(CommonPool) {
                    WallpapersSourceRepository.getWallpapersSource(wallpapersSourceUid)
                }.also {
                    it.observeForever(existingSourceObserver)
                }
            }
        }
    }

    fun getEditingWallpapersSource(): LiveData<WallpapersSource> = editingWallpapersSource
}
