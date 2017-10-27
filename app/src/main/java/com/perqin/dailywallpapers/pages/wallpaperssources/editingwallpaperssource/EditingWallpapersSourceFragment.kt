package com.perqin.dailywallpapers.pages.wallpaperssources.editingwallpaperssource


import android.annotation.SuppressLint
import android.app.Dialog
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v7.app.AlertDialog
import android.view.LayoutInflater
import com.perqin.dailywallpapers.R
import com.perqin.dailywallpapers.viewmodels.EditingWallpapersSourceViewModel
import kotlinx.android.synthetic.main.fragment_editing_wallpapers_source.view.*

private const val ARG_WALLPAPERS_SOURCE_UID = "WALLPAPERS_SOURCE_UID"

class EditingWallpapersSourceFragment : DialogFragment() {
    private var wallpapersSourceUid: Long? = null
    private lateinit var editingWallpapersSourceViewModel: EditingWallpapersSourceViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        wallpapersSourceUid = arguments?.getLong(ARG_WALLPAPERS_SOURCE_UID)
        editingWallpapersSourceViewModel = ViewModelProviders.of(activity).get(EditingWallpapersSourceViewModel::class.java)
        editingWallpapersSourceViewModel.init(wallpapersSourceUid)
    }

    @SuppressLint("InflateParams")
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val contentView = LayoutInflater.from(activity).inflate(R.layout.fragment_editing_wallpapers_source, null)
        editingWallpapersSourceViewModel.url.observe(this, Observer { contentView.editText_url.setText(it?:"") })
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
