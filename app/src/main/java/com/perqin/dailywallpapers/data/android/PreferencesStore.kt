package com.perqin.dailywallpapers.data.android

/**
 * Author: perqin
 * Date  : 10/30/17
 */
object PreferencesStore {
    fun getSelectedWallpapersSourceUid() = AppServices.sharedPreferences.getLong(PK_SELECTED_WALLPAPERS_SOURCE_UID, -1)

    private val PK_SELECTED_WALLPAPERS_SOURCE_UID = "SELECTED_WALLPAPERS_SOURCE_UID"
}
