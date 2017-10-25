package com.perqin.dailywallpapers.pages.wallpaperssources

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.perqin.dailywallpapers.R
import com.perqin.dailywallpapers.data.models.wallpaperssource.WallpapersSourceViewModel
import kotlinx.android.synthetic.main.activity_wallpapers_sources.*

class WallpapersSourcesActivity : AppCompatActivity() {
    private lateinit var wallpapersSourcesViewModel : WallpapersSourceViewModel
    private lateinit var recyclerAdapter : WallpapersSourcesRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wallpapers_sources)

        recyclerAdapter = WallpapersSourcesRecyclerAdapter()

        recyclerView.adapter = recyclerAdapter
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        wallpapersSourcesViewModel = ViewModelProviders.of(this).get(WallpapersSourceViewModel::class.java)
        wallpapersSourcesViewModel.wallpapersSources.observe(this, Observer {
            recyclerAdapter.refreshWallpapersSources(it?:emptyList())
        })
    }
}
