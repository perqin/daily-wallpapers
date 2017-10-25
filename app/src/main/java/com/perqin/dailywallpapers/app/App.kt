package com.perqin.dailywallpapers.app

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

/**
 * Author: perqin
 * Date  : 10/25/17
 */
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        context = this
    }

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
    }
}

val AppContext by lazy { App.context }
