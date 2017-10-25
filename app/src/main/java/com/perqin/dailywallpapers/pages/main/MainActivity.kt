package com.perqin.dailywallpapers.pages.main

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.perqin.dailywallpapers.R
import com.perqin.dailywallpapers.pages.wallpaperssources.WallpapersSourcesActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // TODO: DEBUG ONLY
        startActivity(Intent(this, WallpapersSourcesActivity::class.java))
    }
}
