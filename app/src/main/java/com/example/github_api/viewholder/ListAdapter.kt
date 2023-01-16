package com.example.github_api.adapter


import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.github_api.R


class GithubViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var titleView: TextView
    var detailView: TextView

    init {
        titleView = itemView.findViewById(R.id.title)
        detailView = itemView.findViewById(R.id.detail)
    }
}