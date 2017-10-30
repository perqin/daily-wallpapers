package com.perqin.dailywallpapers.pages.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.perqin.dailywallpapers.R
import com.perqin.dailywallpapers.viewmodels.WallpapersSourcesViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private lateinit var wallpapersSourcesVm: WallpapersSourcesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        wallpapersSourcesVm = ViewModelProviders.of(this).get(WallpapersSourcesViewModel::class.java)
        wallpapersSourcesVm.wallpapersSources.observe(this, Observer {
            navView.menu.apply {
                IntRange(0, this.size() - 1).forEach {
                    this.getItem(it)
                            .takeIf { it.groupId == R.id.menuGroup_wallpapersSources }
                            ?.let { this.removeItem(it.itemId) }
                }
                it?.withIndex()?.forEach {
                    this.add(R.id.menuGroup_wallpapersSources, it.index, it.index, it.value.title)
                }
            }
        })
    }
}
