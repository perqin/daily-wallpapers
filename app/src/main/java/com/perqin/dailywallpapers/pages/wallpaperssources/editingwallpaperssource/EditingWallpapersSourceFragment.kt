package com.perqin.dailywallpapers.pages.wallpaperssources.editingwallpaperssource


import android.annotation.SuppressLint
import android.app.Dialog
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v7.app.AlertDialog
import android.text.Editable
import android.text.TextWatcher
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
        // Setup contentView
        val contentView = LayoutInflater.from(activity).inflate(R.layout.fragment_editing_wallpapers_source, null)
        contentView.editText_url.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                s?.toString()?.let { editingWallpapersSourceViewModel.changeUrl(it) }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
        contentView.editText_title.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                s?.toString()?.let { editingWallpapersSourceViewModel.changeTitle(it) }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
        contentView.editText_version.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                s?.toString()?.toIntOrNull()?.let { editingWallpapersSourceViewModel.changeVersion(it) }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
        // Observe ViewModel changes
        editingWallpapersSourceViewModel.getEditingWallpapersSource().observe(this, Observer {
            if (it?.url != contentView.editText_url.text.toString()) contentView.editText_url.setText(it?.url)
            if (it?.title != contentView.editText_title.text.toString()) contentView.editText_title.setText(it?.title)
            if (it?.version.toString() != contentView.editText_version.text.toString()) contentView.editText_version.setText(it?.version.toString())
        })
        return AlertDialog.Builder(context, theme)
                .setTitle(if (wallpapersSourceUid == null) R.string.dialogTitle_newWallpapersSource else R.string.dialogTitle_editWallpapersSource)
                .setView(contentView)
                .setPositiveButton(R.string.buttonText_save, { _, _ -> editingWallpapersSourceViewModel.saveNewWallpapersSource() })
                .setNegativeButton(R.string.buttonText_discard, null)
                .create()
    }

    companion object {
        @JvmStatic
        fun newInstance(wallpapersSourceUid: Long?): EditingWallpapersSourceFragment {
            return EditingWallpapersSourceFragment().apply {
                if (wallpapersSourceUid != null) {
                    arguments = Bundle().apply {
                        putLong(ARG_WALLPAPERS_SOURCE_UID, wallpapersSourceUid)
                    }
                }
            }
        }
    }
}
