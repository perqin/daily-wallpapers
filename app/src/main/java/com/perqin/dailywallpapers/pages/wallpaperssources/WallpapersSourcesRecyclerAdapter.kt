package com.perqin.dailywallpapers.pages.wallpaperssources

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.perqin.dailywallpapers.R
import com.perqin.dailywallpapers.data.models.wallpaperssource.WallpapersSource
import kotlinx.android.synthetic.main.item_wallpapers_source.view.*

/**
 * Author: perqin
 * Date  : 10/26/17
 */
class WallpapersSourcesRecyclerAdapter : RecyclerView.Adapter<WallpapersSourcesRecyclerAdapter.ViewHolder>() {
    private var wallpapersSources: List<WallpapersSource>

    init {
        wallpapersSources = emptyList()
    }

    override fun getItemCount(): Int = wallpapersSources.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int) = ViewHolder(
            LayoutInflater.from(parent!!.context).inflate(R.layout.item_wallpapers_source, parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder!!

        val source = wallpapersSources[position]
        holder.itemView.textView_title.text = source.title
        holder.itemView.textView_url.text = source.url
        holder.itemView.imageButton_edit.setOnClickListener {
        }
    }

    fun refreshWallpapersSources(wallpapersSources: List<WallpapersSource>) {
        this.wallpapersSources = wallpapersSources
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
