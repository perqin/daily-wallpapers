package com.perqin.dailywallpapers.data.models.wallpaper

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey
import com.perqin.dailywallpapers.data.models.wallpaperssource.WallpapersSource

/**
 * Created: 10/30/17
 *
 * @author perqin
 */
@Entity(
        tableName = Wallpaper.TABLE_NAME,
        foreignKeys = [
        ForeignKey(entity = WallpapersSource::class, parentColumns = [WallpapersSource.UID], childColumns = [Wallpaper.SOURCE_UID])
        ]
)
data class Wallpaper(
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = UID)
        var uid: Long? = null,
        @ColumnInfo(name = SOURCE_UID)
        var sourceUid: Long = 0,
        var date: Long = 0,
        var uri: String = ""
) {
    companion object {
        const val TABLE_NAME = "wallpaper"
        const val UID = "uid"
        const val SOURCE_UID = "source_uid"
    }
}
