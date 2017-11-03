package com.perqin.dailywallpapers.pages.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.perqin.dailywallpapers.R
import com.perqin.dailywallpapers.data.models.wallpaperssource.WallpapersSource
import com.perqin.dailywallpapers.viewmodels.MainPageViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private lateinit var mainVm: MainPageViewModel
    private var wallpapersSources: List<WallpapersSource> = emptyList()
    private var selectedWallpapersSourceUid: Long = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainVm = ViewModelProviders.of(this).get(MainPageViewModel::class.java)
        mainVm.selectableWallpapersSources.observe(this, Observer {
            it!!
            wallpapersSources = it.first
            selectedWallpapersSourceUid = it.second
            updateNavMenu()
        })

        navView.setNavigationItemSelectedListener {
            mainVm.selectWallpapersSources(wallpapersSources[it.itemId].uid!!)
            true
        }
    }

    private fun updateNavMenu() {
        navView.menu.apply {
            // Remove old group
            IntRange(0, this.size() - 1)
                    .map { this.getItem(it) }
                    .filter { it.groupId == R.id.menuGroup_wallpapersSources }
                    .forEach { this.removeItem(it.itemId) }
            // Add new one
            wallpapersSources.withIndex().forEach {
                this.add(R.id.menuGroup_wallpapersSources, it.index, it.index, it.value.title).apply {
                    isChecked = it.value.uid == selectedWallpapersSourceUid
                }
            }
        }
    }
}
