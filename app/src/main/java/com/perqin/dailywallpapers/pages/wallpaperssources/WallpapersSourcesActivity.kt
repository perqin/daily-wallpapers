package com.perqin.dailywallpapers.pages.wallpaperssources

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.perqin.dailywallpapers.R
import com.perqin.dailywallpapers.data.models.wallpaperssource.WallpapersSource
import com.perqin.dailywallpapers.pages.wallpaperssources.editingwallpaperssource.EditingWallpapersSourceFragment
import com.perqin.dailywallpapers.viewmodels.WallpapersSourcesViewModel
import kotlinx.android.synthetic.main.activity_wallpapers_sources.*

class WallpapersSourcesActivity : AppCompatActivity() {
    private lateinit var wallpapersSourcesViewModel : WallpapersSourcesViewModel
    private lateinit var recyclerAdapter : WallpapersSourcesRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wallpapers_sources)

        recyclerAdapter = WallpapersSourcesRecyclerAdapter()
        recyclerAdapter.setItemInteractListener(object : WallpapersSourcesRecyclerAdapter.ItemInteractListener {
            override fun onItemEditClick(wallpapersSource: WallpapersSource) {
                EditingWallpapersSourceFragment
                        .newInstance(wallpapersSource.uid)
                        .show(supportFragmentManager, EditingWallpapersSourceFragment::class.java.name)
            }
        })

        setup()

        wallpapersSourcesViewModel = ViewModelProviders.of(this).get(WallpapersSourcesViewModel::class.java)
        wallpapersSourcesViewModel.wallpapersSources.observe(this, Observer {
            recyclerAdapter.refreshWallpapersSources(it?:emptyList())
        })
    }

    private fun setup() {
        recyclerView.adapter = recyclerAdapter
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        fab.setOnClickListener {
            EditingWallpapersSourceFragment
                    .newInstance(null)
                    .show(supportFragmentManager, EditingWallpapersSourceFragment::class.java.name)
        }
    }
}
