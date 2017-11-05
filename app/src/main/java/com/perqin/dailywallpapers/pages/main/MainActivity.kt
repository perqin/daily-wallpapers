package com.perqin.dailywallpapers.pages.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v4.view.GravityCompat
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import com.perqin.dailywallpapers.R
import com.perqin.dailywallpapers.data.models.wallpaperssource.WallpapersSource
import com.perqin.dailywallpapers.pages.wallpaperssources.WallpapersSourcesActivity
import com.perqin.dailywallpapers.viewmodels.MainPageViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private lateinit var vs: ViewStates
    private lateinit var mainVm: MainPageViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        vs = ViewStates()
        mainVm = ViewModelProviders.of(this).get(MainPageViewModel::class.java)
        mainVm.wallpapersSources.observe(this, Observer {
            vs.wallpapersSources = it!!
            updateNavMenu()
        })
        mainVm.selectedWallpapersSource.observe(this, Observer {
            vs.selectedWallpapersSource = it!!
            updateNavMenu()
        })

        navView.setNavigationItemSelectedListener {
            if (it.itemId >= 0 && it.itemId < vs.wallpapersSources.size) {
                mainVm.selectWallpapersSource(vs.wallpapersSources[it.itemId])
                drawerLayout.closeDrawer(GravityCompat.START)
            } else if (it.itemId == R.id.menuItem_edit) {
                startActivity(Intent(this, WallpapersSourcesActivity::class.java))
            }
            true
        }
    }

    private fun updateNavMenu() {
        navView.menu.apply {
            // Remove old menu
            clear()
            // Add Edit
            add(Menu.NONE, R.id.menuItem_edit, 0, "Edit")
            // Add new sources
            vs.wallpapersSources.withIndex().forEach {
                this.add(R.id.menuGroup_wallpapersSources, it.index, 1 + it.index, it.value.title).apply {
                    isChecked = it.value.uid == vs.selectedWallpapersSource?.uid
                }
            }
        }
    }

    class ViewStates {
        var wallpapersSources: List<WallpapersSource> = emptyList()
        var selectedWallpapersSource: WallpapersSource? = null
    }
}
