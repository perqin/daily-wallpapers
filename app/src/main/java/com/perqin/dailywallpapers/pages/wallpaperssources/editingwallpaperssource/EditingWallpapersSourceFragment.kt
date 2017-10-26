package com.perqin.dailywallpapers.pages.wallpaperssources.editingwallpaperssource


import android.annotation.SuppressLint
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v7.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.perqin.dailywallpapers.R

private const val ARG_WALLPAPERS_SOURCE_UID = "WALLPAPERS_SOURCE_UID"

class EditingWallpapersSourceFragment : DialogFragment() {
    private var wallpapersSourceUid: Long? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        wallpapersSourceUid = arguments?.getLong(ARG_WALLPAPERS_SOURCE_UID)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return TextView(activity).apply {
            setText(R.string.hello_blank_fragment)
        }
    }

    @SuppressLint("InflateParams")
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val contentView = layoutInflater.inflate(R.layout.fragment_editing_wallpapers_source, null)
        return AlertDialog.Builder(context, theme)
                .setTitle(if (wallpapersSourceUid == null) R.string.dialogTitle_newWallpapersSource else R.string.dialogTitle_editWallpapersSource)
                .setView(contentView)
                .setPositiveButton(R.string.buttonText_save, { _, _ ->  })
                .setNegativeButton(R.string.buttonText_discard, null)
                .create()
    }

    companion object {
        @JvmStatic
        fun newInstance(wallpapersSourceUid: Long?): EditingWallpapersSourceFragment {
            return EditingWallpapersSourceFragment().apply {
                arguments = Bundle().apply {
                    if (wallpapersSourceUid != null) putLong(ARG_WALLPAPERS_SOURCE_UID, wallpapersSourceUid)
                }
            }
        }
    }
}
