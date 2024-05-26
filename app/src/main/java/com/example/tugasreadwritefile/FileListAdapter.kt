package com.example.tugasreadwritefile

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

class FileListAdapter(context: Context, files: List<File>) :
    ArrayAdapter<File>(context, R.layout.item_list, files) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var itemView = convertView
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_list, parent, false)
        }

        val fileNameTextView = itemView!!.findViewById<TextView>(R.id.txtFileName)
        val lastModifiedTextView = itemView.findViewById<TextView>(R.id.txtLastModified)

        val file = getItem(position)

        fileNameTextView.text = file?.name
        lastModifiedTextView.text = formatDate(file?.lastModified() ?: 0)

        return itemView
    }

    private fun formatDate(timestamp: Long): String {
        val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = timestamp
        return sdf.format(calendar.time)
    }
}
