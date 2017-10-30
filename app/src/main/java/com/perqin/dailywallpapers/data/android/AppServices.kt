package com.perqin.dailywallpapers.data.android

import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.perqin.dailywallpapers.app.App

/**
 * Author: perqin
 * Date  : 10/30/17
 */
object AppServices {
    val sharedPreferences: SharedPreferences by lazy {
        PreferenceManager.getDefaultSharedPreferences(App.context)
    }
}
