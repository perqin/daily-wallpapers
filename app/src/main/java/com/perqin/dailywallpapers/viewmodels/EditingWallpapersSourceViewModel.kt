package com.perqin.dailywallpapers.viewmodels

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
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
    var uid: Long? = null
    val url: MutableLiveData<String> = MutableLiveData()
    val title: MutableLiveData<String> = MutableLiveData()
    val version: MutableLiveData<Int> = MutableLiveData()

    fun init(wallpapersSourceUid: Long?) {
        uid = wallpapersSourceUid?.also {
            launch(UI) {
                run(CommonPool) {
                    WallpapersSourceRepository.getWallpapersSource(it).value
                }?.also {
                    url.postValue(it.url)
                    title.postValue(it.title)
                    version.postValue(it.version)
                }
            }
        }
    }
}
