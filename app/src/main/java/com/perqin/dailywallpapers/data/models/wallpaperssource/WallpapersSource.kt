package com.perqin.dailywallpapers.data.models.wallpaperssource

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Author: perqin
 * Date  : 10/25/17
 */
@Entity(tableName = WallpapersSource.TABLE_NAME)
data class WallpapersSource(
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "uid")
        var uid: Long? = null,
        var title: String = "",
        var url: String = "",
        var version: Int = -1
) {
    companion object {
        const val TABLE_NAME = "wallpapers_source"
        const val UID = "uid"
        const val TITLE = "title"
        const val URL = "url"
        const val VERSION = "version"
    }
}
