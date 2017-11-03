package com.perqin.dailywallpapers.data.android

import com.perqin.dailywallpapers.utils.longLiveData

/**
 * Author: perqin
 * Date  : 10/30/17
 */
object PreferencesStore {
    fun getSelectedWallpapersSourceUid() = AppServices.sharedPreferences.longLiveData(PK_SELECTED_WALLPAPERS_SOURCE_UID, -1)

    private val PK_SELECTED_WALLPAPERS_SOURCE_UID = "SELECTED_WALLPAPERS_SOURCE_UID"

    fun setSelectedWallpapersSourceUid(uid: Long) {
        AppServices.sharedPreferences.edit().putLong(PK_SELECTED_WALLPAPERS_SOURCE_UID, uid).apply()
    }
}
